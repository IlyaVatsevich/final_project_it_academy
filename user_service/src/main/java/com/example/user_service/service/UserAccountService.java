package com.example.user_service.service;

import com.example.user_service.controllers.util.JwtTokenUtil;
import com.example.user_service.dao.entity.UserEntity;
import com.example.user_service.dao.repositories.UserRepository;
import com.example.user_service.security.UserImpDetails;
import com.example.user_service.service.api.IService;
import com.example.user_service.service.dto.UsersPage;
import com.example.user_service.service.dto.account.UserLogin;
import com.example.user_service.service.dto.account.UserRegistration;
import com.example.user_service.service.dto.api.IAccountUserMapper;
import com.example.user_service.service.dto.api.IUsersMapper;
import com.example.user_service.service.dto.users.UserToAdd;
import com.example.user_service.service.dto.users.UserToRead;
import com.example.user_service.service.exceptions.PasswordNotCorrectException;
import com.example.user_service.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserAccountService implements IService, UserDetailsService {

    private final UserRepository userRepository;

    private final IUsersMapper usersMapper;

    private final PasswordEncoder encoder;

    private final UserHolder holder;

    private final IAccountUserMapper accountMapper;

    @Autowired
    public UserAccountService(UserRepository userRepository, IUsersMapper usersMapper,
                              PasswordEncoder encoder, UserHolder holder, IAccountUserMapper accountMapper) {
        this.userRepository = userRepository;
        this.usersMapper = usersMapper;
        this.encoder = encoder;
        this.holder = holder;
        this.accountMapper = accountMapper;
    }

    @Override
    public void userRegistration(UserRegistration userReg) {

        UserEntity userEntity = accountMapper.fromDTOtoEntity(userReg);

        userEntity.setPassword(encoder.encode(userEntity.getPassword()));

        userRepository.save(userEntity);

        userReg.setPassword(userEntity.getPassword());

    }

    @Override
    public String userLogin(UserLogin userLog) {

        UserDetails userDetails = loadUserByUsername(userLog.getLogin());

        if (!encoder.matches(userLog.getPassword(),userDetails.getPassword())) {
            throw new PasswordNotCorrectException(userLog.getPassword());
        }

        return JwtTokenUtil.generateAccessToken(userDetails);
    }

    @Override
    public UserToRead userInfo() {

        UserDetails user = holder.getUser();

        return accountMapper.fromEntityToDTO(((UserImpDetails) user).getUser());
    }

    @Override
    public UserToAdd addNewUser(UserToAdd userAdd) {

        UserEntity userEntity = usersMapper.fromDTOtoEntity(userAdd);

        userEntity.setPassword(encoder.encode(userEntity.getPassword()));

        userRepository.save(userEntity);

        userAdd.setPassword(userEntity.getPassword());

        return userAdd;
    }

    @Override
    public UsersPage<UserToRead> getUserPage(Integer size, Integer page) {

        Page<UserEntity> userPage = userRepository.findAll(
                PageRequest.of(--page, size, Sort.by(Sort.Direction.ASC, "nick")));

        return usersMapper.fromEntityPageToDTOPage(userPage);

    }

    @Override
    public UserToRead readUserInfo(String uuid) {

        UserEntity userEntityFound = findUserById(UUID.fromString(uuid));

        return usersMapper.fromEntityToDTO(userEntityFound);
    }

    @Override
    public UserToAdd updateUserInfo(UserToAdd userUpd, String uuid, LocalDateTime dtUpdate) {

        UserEntity user = usersMapper.updateUserEntity(findUserById(UUID.fromString(uuid)), userUpd);

        user.setPassword(encoder.encode(user.getPassword()));

        if (dtUpdate.equals(user.getDtUpdate())) {
            userRepository.save(user);
        } else {
            throw new OptimisticLockException("User with uuid " + uuid + " updated early. Try again.");
        }

        userUpd.setPassword(user.getPassword());

        return userUpd;
    }

    private UserEntity findUserById(UUID uuid) {
        return userRepository.findById(uuid).orElseThrow(()-> new UserNotFoundException(uuid));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findUserEntityByMail(username).orElseThrow(
                () -> new UsernameNotFoundException("User with such mail not found"));

        return new UserImpDetails(user);
    }
}
