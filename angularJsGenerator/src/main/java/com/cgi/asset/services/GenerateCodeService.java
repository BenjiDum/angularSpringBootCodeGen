package com.cgi.asset.services;

import com.cgi.asset.angular.AngularObjects;
import com.cgi.asset.builder.AppUtils;
import com.cgi.asset.liquibase.LiquibaseObjects;
import com.cgi.asset.objectModelorEntity.ObjectDescriptor;
import com.cgi.asset.springboot.SpringBootObjects;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.Charset;
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

    public File buildZipFromObject(ObjectDescriptor object){

        byte[] buffer = new byte[1024];
        File masterFile = null;

        try {
            masterFile = new File(EXPORT_FILE+ object.getName() + ".zip");
            FileOutputStream fos = new FileOutputStream(masterFile);
            ZipOutputStream zos = new ZipOutputStream(fos);

            List<File> result = new ArrayList<File>();

            //JpaObjects objectJpa = new JpaObjects();

           // freemarkerConfiguration.ge

            if (generateAngular){
                //AngularObjects.generateAngularFilesForObject(prop, cfg, objectDescriptor);
            }

            if (generateSpring){
                //SpringBootObjects.generateSpringFilesForObject(prop, cfg, objectDescriptor);

            }

            if (generateDatabase){
               // LiquibaseObjects.generateLiquibaseFilesForObject(prop, cfg, objectDescriptor);

            }

            if (generateJPA){
                result.addAll(jpaObjectsGeneratorService.generateJPAFilesForObject(object));
            }


            if (result.size()!=0){
                for(File file : result){
                    ZipEntry ze= new ZipEntry(file.getName());
                    zos.putNextEntry(ze);
                    FileInputStream in = new FileInputStream(file);
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                    in.close();
                    zos.closeEntry();
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
            //logger.error(ioe.printStackTrace());
        }



        return masterFile;
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
