package com.cgi.asset.controller;

import com.cgi.asset.domain.GeneratedEntity;
import com.cgi.asset.objectModelorEntity.ObjectDescriptor;
import com.cgi.asset.repository.GeneratedEntityRepository;
import com.cgi.asset.repository.GeneratedEntityService;
import com.cgi.asset.services.TypeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dumasbe on 03/02/2016.
 */
@RestController
@RequestMapping(value="/generatedEntity")
public class GeneratedEntityController {

    @Autowired
    private GeneratedEntityService generatedEntityService;

    @Autowired
    private TypeService typeServices;

    @RequestMapping(value="/supportedTypes", method= RequestMethod.GET, produces = "application/json")
    @Produces("application/json")
    public List<String> getSupportedAttributesTypes(){
        List<String> result = new ArrayList<String>();
        result.addAll(typeServices.getAllSupportedTypes());

        for (GeneratedEntity gen : generatedEntityService.findAll()){
            result.add(gen.getName());
        };

        return result;
    }


    @RequestMapping(value="/generatedTypes", method= RequestMethod.GET, produces = "application/json")
    @Produces("application/json")
    public List<String> getGeneratedTypes(){
        List<String> result = new ArrayList<String>();

        for (GeneratedEntity gen : generatedEntityService.findAll()){
            result.add(gen.getName());
        };

        return result;
    }


    @RequestMapping(value="/all", method= RequestMethod.GET, produces = "application/json")
    @Produces("application/json")
    public List<GeneratedEntity> findAll(){
        return generatedEntityService.findAll();
    }

    @RequestMapping(value="/entity", method= RequestMethod.GET, produces = "application/json")
    @Produces("application/json")
    public ObjectDescriptor findEntityByName(@RequestParam("entityName") String entityName){
        ObjectMapper mapper = new ObjectMapper();
        GeneratedEntity result = generatedEntityService.findByNameIgnoringCase(entityName);

        ObjectDescriptor object = null;
        try {
            object = mapper.readValue(result.getJsonValue(), ObjectDescriptor.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

}
