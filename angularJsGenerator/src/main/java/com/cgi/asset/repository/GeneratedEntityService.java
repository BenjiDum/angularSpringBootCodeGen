package com.cgi.asset.repository;

import com.cgi.asset.domain.GeneratedEntity;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by dumasbe on 03/02/2016.
 */import java.util.List;

@Service
public interface GeneratedEntityService{

    List<GeneratedEntity> findAll();

    void saveEntity(GeneratedEntity GeneratedEntity);

    GeneratedEntity updateEntity(GeneratedEntity GeneratedEntity);

    GeneratedEntity findByNameIgnoringCase(String name);

    //GeneratedEntity findByNameAndCountryAllIgnoringCase(String name, String country);

}
