package com.cgi.asset.controller;

import com.cgi.asset.domain.GeneratedEntity;
import com.cgi.asset.generationModel.template.BackendTemplate;
import com.cgi.asset.generationModel.template.DatabaseTemplate;
import com.cgi.asset.generationModel.template.FrontendTemplate;
import com.cgi.asset.objectModelorEntity.ObjectDescriptor;
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
@RequestMapping(value="/templates/")
public class TemplateController {

    @Autowired
    private GeneratedEntityService generatedEntityService;

    @Autowired
    private TypeService typeServices;

    @RequestMapping(value="/backendTpl", method= RequestMethod.GET, produces = "application/json")
    @Produces("application/json")
    public BackendTemplate[] getBackendTemplates(){
        return BackendTemplate.values();
    }

    @RequestMapping(value="/frontendTpl", method= RequestMethod.GET, produces = "application/json")
    @Produces("application/json")
    public FrontendTemplate[] getFrontendTemplate(){
        return FrontendTemplate.values();
    }

    @RequestMapping(value="/databaseTpl", method= RequestMethod.GET, produces = "application/json")
    @Produces("application/json")
    public DatabaseTemplate[] getDatabaseTemplate(){
        return DatabaseTemplate.values();
    }

}
