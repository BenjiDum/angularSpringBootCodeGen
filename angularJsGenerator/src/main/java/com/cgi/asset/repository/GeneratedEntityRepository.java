package com.cgi.asset.repository;

import com.cgi.asset.domain.GeneratedEntity;

/**
 * Created by dumasbe on 03/02/2016.
 */

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.*;

import java.util.List;

@org.springframework.stereotype.Repository
public interface GeneratedEntityRepository extends CrudRepository<GeneratedEntity, Long> {

    List<GeneratedEntity> findAll();

    GeneratedEntity findByNameIgnoringCase(String name);

    //vodi create(GeneratedEntity entity);

    //GeneratedEntity findByNameAndCountryAllIgnoringCase(String name, String country);

}
