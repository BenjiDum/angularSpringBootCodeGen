package com.cgi.asset.generationModel;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.cgi.asset.objectModelorEntity.ObjectDescriptor;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cgi.asset.builder.AppUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AngularObjectsService {

    @Autowired
    private Configuration freemarkerConfiguration;
	
	private static final Logger logger = LoggerFactory.getLogger(AngularObjectsService.class);

	private static final String ANGULAR_CONTROLLER_TEMPLATE = "object.angular.controller.ftl";

    public List<File> generateAngularFilesForObject(ObjectDescriptor object) throws IOException{
        List<File> angularFileList = new ArrayList<File>();
        angularFileList.add(generateControllerFile(object));
        return angularFileList;
    }

    private File generateControllerFile(ObjectDescriptor object) throws IOException {
        String fileName = object.getName()+".js";
        File f = new File(fileName);

        try {
            Template temp = freemarkerConfiguration.getTemplate(ANGULAR_CONTROLLER_TEMPLATE);

            Writer out = new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName("UTF-8"));
            try {
                temp.process(object, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
            out.flush();
            out.close();

        }catch (java.io.FileNotFoundException fnfd){
            logger.error("File not found exception");
            logger.error(fnfd.getMessage());
        }
        return f;
    }

}
