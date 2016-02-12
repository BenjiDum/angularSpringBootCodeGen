package com.cgi.asset.repository;

import com.cgi.asset.domain.GeneratedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("generatedEntityService")
@Transactional
public class GeneratedEntityServiceImpl implements GeneratedEntityService {

    @Autowired
    private GeneratedEntityRepository generatedEntityRepository;

    @Override
    public List<GeneratedEntity> findAll() {
        return generatedEntityRepository.findAll();
    }

    @Override
    public void saveEntity(GeneratedEntity generatedEntity){
        generatedEntityRepository.save(generatedEntity);
    }

    @Override
    public GeneratedEntity updateEntity(GeneratedEntity generatedEntity) {
        return generatedEntityRepository.save(generatedEntity);
    }

    @Override
    public GeneratedEntity findByNameIgnoringCase(String name) {
        return generatedEntityRepository.findByNameIgnoringCase(name);
    }


    //GeneratedEntity findByNameAndCountryAllIgnoringCase(String name, String country);

}
