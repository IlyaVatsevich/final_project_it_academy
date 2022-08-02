package com.example.user_service.dao;

import com.example.user_service.security.UserImpDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import javax.sql.DataSource;
import java.util.Objects;

public class JdbcUserDetailsManagerImp extends JdbcUserDetailsManager {

    /*private static final String CREATE_USER = "" +
            "INSERT INTO users (uuid,date_of_create,date_of_update,mail,nick,password,status) " +
            "values (?,?,?,?,?,?,?);";

    private static final String ROLE = "INSERT INTO user_roles (uuid,role) values (?,?)";

    public JdbcUserDetailsManagerImp(DataSource dataSource) {
        super(dataSource);
    }
    @Override
    public void createUser(UserDetails user) {
        Objects.requireNonNull(getJdbcTemplate()).update(CREATE_USER, ps -> {
            ps.setObject(1, ((UserImpDetails) user).getUser().getUuid());
            ps.setObject(2, ((UserImpDetails) user).getUser().getDtCreate());
            ps.setObject(3, ((UserImpDetails) user).getUser().getDtUpdate());
            ps.setString(4, user.getUsername());
            ps.setString(5,((UserImpDetails) user).getUser().getNick());
            ps.setString(6, user.getPassword());
            ps.setString(7, String.valueOf(((UserImpDetails) user).getUser().getStatus()));
        });
        if (null!= ((UserImpDetails) user).getUser().getRole()) {
            ((UserImpDetails) user).getUser().getRole().forEach(userRole ->
                    Objects.requireNonNull(getJdbcTemplate()).
                    update(ROLE, ((UserImpDetails) user).getUser().getUuid(),
                    userRole.getAuthority()));
        }
    }*/
}
