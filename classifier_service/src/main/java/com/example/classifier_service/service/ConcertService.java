package com.example.classifier_service.service;


import com.example.classifier_service.dao.entity.ConcertCategory;
import com.example.classifier_service.dao.repositories.ConcertRepository;
import com.example.classifier_service.service.api.IConcertMapper;
import com.example.classifier_service.service.api.IConcertService;
import com.example.classifier_service.service.dto.PageToReadClassifier;
import com.example.classifier_service.service.dto.concerts.ConcertToCreate;
import com.example.classifier_service.service.dto.concerts.ConcertToRead;
import com.example.classifier_service.service.util.ValidPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;


@Service
public class ConcertService implements IConcertService {

    private final ConcertRepository concertRepository;

    private final IConcertMapper mapper;

    @Autowired
    public ConcertService(ConcertRepository concertRepository, IConcertMapper mapper) {
        this.concertRepository = concertRepository;
        this.mapper = mapper;
    }


    @Override
    public ConcertToCreate create( ConcertToCreate classifier) {

        ConcertCategory concertCategory = mapper.fromDtoToEntity(classifier);

        concertRepository.saveAndFlush(concertCategory);

        return classifier;
    }

    @Override
    public PageToReadClassifier<ConcertToRead> getPageOfClassifier(Integer size, Integer page) {

        ValidPage.pageSizeValid(page,size);

        Page<ConcertCategory> entityRead = concertRepository.findAll(
                PageRequest.of(--page, size, Sort.by(Sort.Direction.ASC, "title")));

        return mapper.fromEntityPageToDtoPage(entityRead);
    }

    @Override
    public Boolean searchByUuid(String uuid) {
        Optional<ConcertCategory> concertCategory = concertRepository.searchByUuid(UUID.fromString(uuid));
        return concertCategory.isPresent();
    }
}
