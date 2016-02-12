package com.cgi.asset.services;

import com.cgi.asset.domain.GeneratedEntity;
import com.cgi.asset.generationModel.AngularObjectsService;
import com.cgi.asset.generationModel.JpaObjectsGeneratorService;
import com.cgi.asset.objectModelorEntity.ObjectDescriptor;
import com.cgi.asset.repository.GeneratedEntityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * Created by dumasbe on 27/01/2016.
 */
@Service
public class GenerateCodeService {

    @Value("${generator.rules.angular}")
    private boolean generateAngular;

    @Value("${generator.rules.spring}")
    private boolean generateSpring;

    @Value("${generator.rules.database}")
    private boolean generateDatabase;

    @Value("${generator.rules.jpa}")
    private boolean generateJPA;


    @Autowired
    private JpaObjectsGeneratorService jpaObjectsGeneratorService;

    @Autowired
    private AngularObjectsService angularObjectsService;

    @Autowired
    private GeneratedEntityService generatedEntityService;

    /*
    protected String composeHtml(Alert alert) throws IOException, TemplateException {
        return processTemplateIntoString(freemarkerConfiguration.getTemplate(TEMPLATE), ImmutableMap.of(
                "alertType", alert.getAlertType(),
                "message", alert.getMessage(),
                "nodeName", alert.getEvent().getNodeName(),
                "event", toJson(alert.getEvent(), true)
        ));
    }*/

    private static final Logger logger = LoggerFactory.getLogger(GenerateCodeService.class);

    private static final String EXPORT_FILE = "GENERATE_CODE_";

    public void persistObjectInDatabase(ObjectDescriptor object) {
        ObjectMapper mapper = new ObjectMapper();

        // convert java object to JSON format,
        // and returned as JSON formatted string
        String json = null;
        try {
            json = mapper.writeValueAsString(object);

            GeneratedEntity existing = generatedEntityService.findByNameIgnoringCase(object.getName());
            if (existing != null){
                existing.setJsonValue(json);


                generatedEntityService.updateEntity(existing);
            }else{
                GeneratedEntity entityToPersist = new GeneratedEntity();
                entityToPersist.setName(object.getName());
                entityToPersist.setJsonValue(json);


                generatedEntityService.saveEntity(entityToPersist);
            }


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }


    public File buildZipFromObject(ObjectDescriptor object){


        File masterFile = null;

        try {
            masterFile = new File(EXPORT_FILE+ object.getName() + ".zip");
            FileOutputStream fos = new FileOutputStream(masterFile);
            ZipOutputStream zos = new ZipOutputStream(fos);



            //JpaObjects objectJpa = new JpaObjects();

           // freemarkerConfiguration.ge

            if (object.isAngularController()){
                //AngularObjects.generateAngularFilesForObject(prop, cfg, objectDescriptor);
                List<File> files = new ArrayList<File>();
                files.addAll(angularObjectsService.generateAngularFilesForObject(object));
                if (files.size()!=0){
                    zos = buildZipPart(files, "ANGULAR", zos);
                }
            }

            if (generateSpring){
                //SpringBootObjects.generateSpringFilesForObject(prop, cfg, objectDescriptor);

            }

            if (generateDatabase){
               // LiquibaseObjects.generateLiquibaseFilesForObject(prop, cfg, objectDescriptor);

            }

            if (object.isJavaPart()){
                List<File> jpaGeneratedFile = new ArrayList<File>();
                jpaGeneratedFile.addAll(jpaObjectsGeneratorService.generateJPAFilesForObject(object));
                if (jpaGeneratedFile.size()!=0){
                    //
                    zos = buildZipPart(jpaGeneratedFile, "JPA", zos);
                }

            }

            zos.close();
            fos.flush();
            fos.close();

        }catch (java.io.FileNotFoundException fnf){
            logger.error("File not found exception");
            logger.error(fnf.getMessage());
        }catch (java.io.IOException ioe){
            logger.error("IOException");
            logger.error(ioe.getMessage());
        }



        return masterFile;
    }

    private ZipOutputStream buildZipPart(List<File> files, String folderName, ZipOutputStream zos) {
        byte[] buffer = new byte[1024];
        try {
            for(File file : files){
                ZipEntry ze= new ZipEntry(folderName+"\\"+file.getName());
                zos.putNextEntry(ze);
                FileInputStream in = new FileInputStream(file);
                int len;
                while ((len = in.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                in.close();
                zos.closeEntry();
            }
        }catch (java.io.FileNotFoundException fnf){
            logger.error("File not found exception");
            logger.error(fnf.getMessage());
        }catch (java.io.IOException ioe){
            logger.error("IOException");
            logger.error(ioe.getMessage());
            //logger.error(ioe.printStackTrace());
        }
        return zos;
    }

    private final static String STRING = "String";

    private final static String BOOLEAN = "Boolean";

    private final static String FLOAT = "float";

    private final static String INTEGER = "Integer";

    public List<String> getAllSupportedTypes(){
        List<String> results = new ArrayList<String>();
        results.add(STRING);
        results.add(BOOLEAN);
        results.add(FLOAT);
        results.add(INTEGER);
        return results;
    }





}
