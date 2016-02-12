package com.cgi.asset.generationModel;

import com.cgi.asset.objectModelorEntity.ObjectDescriptor;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service
public class JpaSimpleObjectsGeneratorService {

	private static final Logger logger = LoggerFactory.getLogger(JpaSimpleObjectsGeneratorService.class);

    public static final String JPA_ENTITY_TEMPLATE = "object.javaJpaSimple.domain.ftl";

    public static final String JPA_SERVICE_TEMPLATE = "object.javaJpaSimple.service.ftl";

    public static final String JPA_SERVICE_IMPL_TEMPLATE = "object.javaJpaSimple.serviceImpl.ftl";

    public static final String JPA_CONTROLLER_TEMPLATE = "object.javaJpaSimple.controller.ftl";

    public static final String JPA_REPOSITORY_TEMPLATE = "object.javaJpaSimple.repository.ftl";

    @Autowired
    private Configuration freemarkerConfiguration;


    public List<File> generateJPAFilesForObject(ObjectDescriptor object) throws IOException{
        List<File> jpaFileList = new ArrayList<File>();

        File jpaFolder = new File("JPA");


        //jpaFileList.add(generateEntityFile(object));
        jpaFileList.add(generateFile(object, JPA_ENTITY_TEMPLATE, ""));
        jpaFileList.add(generateFile(object, JPA_SERVICE_TEMPLATE, "Service"));
        jpaFileList.add(generateFile(object, JPA_SERVICE_IMPL_TEMPLATE, "ServiceImpl"));
        jpaFileList.add(generateFile(object, JPA_CONTROLLER_TEMPLATE, "Controller"));
        jpaFileList.add(generateFile(object, JPA_REPOSITORY_TEMPLATE, "Repository"));

        //generateFile

        return jpaFileList;
    }


    private File generateEntityFile(ObjectDescriptor object) throws IOException{
        String fileName = object.getName()+".java";
        File f = new File(fileName);

        try {
            Template temp = freemarkerConfiguration.getTemplate(JPA_ENTITY_TEMPLATE);

            //if(!f.exists()){
            Writer out = new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName("UTF-8"));
            try {
                temp.process(object, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
            out.flush();
            out.close();
            /*}
            else
            {
                logger.info("fileName "+ fileName+" already exists, skipping it");
            }*/

        }catch (FileNotFoundException fnfd){
            logger.error("File not found exception");
            logger.error(fnfd.getMessage());
        }
        return f;
    }

    private File generateFile(ObjectDescriptor object, String fileTpl, String fileSuffixName) throws IOException{

        String fileName = object.getName()+fileSuffixName+".java";

        File f = new File(fileName);

        try {
            Template temp = freemarkerConfiguration.getTemplate(fileTpl);
            Writer out = new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName("UTF-8"));
            try {
                temp.process(object, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
            out.flush();
            out.close();
        }catch (FileNotFoundException fnfd){
            logger.error("File not found exception");
            logger.error(fnfd.getMessage());
        }
        return f;
    }


	/*public static void generateAngularFilesForObject(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor){
        
		try {
			generateMainHtmlFile(prop, cfg, objectDescriptor);
			
			generateCreateModalFile(prop, cfg, objectDescriptor);
			
			generateEditModalFile(prop, cfg, objectDescriptor);
			
			generateControllerFile(prop, cfg, objectDescriptor);
			
			generateFilterFile(prop, cfg, objectDescriptor);
			
			generataServiceFile(prop, cfg, objectDescriptor);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	private static void generateMainHtmlFile(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor)  throws Exception {
	

        Template temp = cfg.getTemplate(ANGULAR_MAIN_TPL, "UTF-8");
        
        String folderName = prop.getProperty(ANGULAR_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/";
        if (AppUtils.createDirectory(folderName))
        {

            String fileName = folderName+objectDescriptor.get(OBJECT_NAME)+ANGULAR_FILE_SUFFIX_MAIN_TPL;
            logger.debug("fileName to generate : "+ fileName);
            
            File f = new File(fileName);
            if(!f.exists()){
            	Writer out = new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName("UTF-8"));
                temp.process(objectDescriptor, out);
                out.flush();
                out.close();
            }
            else
            {
            	logger.info("fileName "+ fileName+" already exists, skipping it");
            }
        }
	}
	
	private static void generateCreateModalFile(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor)  throws Exception {
		

        Template temp = cfg.getTemplate(ANGULAR_CREATE_MODAL_TPL, "UTF-8");
        
        String folderName = prop.getProperty(ANGULAR_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/";
        if (AppUtils.createDirectory(folderName))
        {
        	String fileName = folderName+objectDescriptor.get(OBJECT_NAME)+ANGULAR_FILE_SUFFIX_CREATE_MODAL_TPL;
            logger.debug("fileName to generate : "+ fileName);
            
            File f = new File(fileName);
            if(!f.exists()){
            	Writer out = new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName("UTF-8"));
                temp.process(objectDescriptor, out);
                out.flush();
                out.close();
            }
            else
            {
            	logger.info("fileName "+ fileName+" already exists, skipping it");
            }
        }
	}
	
	private static void generateEditModalFile(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor)  throws Exception {
		
        Template temp = cfg.getTemplate(ANGULAR_EDIT_MODAL_TPL, "UTF-8");
        
        String folderName = prop.getProperty(ANGULAR_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/";
        if (AppUtils.createDirectory(folderName))
        {
        	String fileName = folderName+objectDescriptor.get(OBJECT_NAME)+ANGULAR_FILE_SUFFIX_EDIT_MODAL_TPL;
            logger.debug("fileName to generate : "+ fileName);
            
            File f = new File(fileName);
            if(!f.exists()){
            	Writer out = new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName("UTF-8"));
                temp.process(objectDescriptor, out);
                out.flush();
                out.close();
            }
            else
            {
            	logger.info("fileName "+ fileName+" already exists, skipping it");
            }
        }
	}
	
	private static void generateControllerFile(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor)  throws Exception {
		 Template temp = cfg.getTemplate(ANGULAR_CONTROLLER_TPL, "UTF-8");
        
        String folderName = prop.getProperty(ANGULAR_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/";
        if (AppUtils.createDirectory(folderName))
        {
	        String fileName = folderName+objectDescriptor.get(OBJECT_NAME)+ANGULAR_FILE_SUFFIX_CONTROLLER_TPL;
	        logger.debug("fileName to generate : "+ fileName);
	        
	        File f = new File(fileName);
	        if(!f.exists()){
	        	Writer out = new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName("UTF-8"));
	            temp.process(objectDescriptor, out);
	            out.flush();
	            out.close();
	        }
	        else
	        {
	        	logger.info("fileName "+ fileName+" already exists, skipping it");
	        }   
        }
	}
	
	private static void generateFilterFile(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor)  throws Exception {
		Template temp = cfg.getTemplate(ANGULAR_FILTER_TPL, "UTF-8");
        
        String folderName = prop.getProperty(ANGULAR_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/";
        if (AppUtils.createDirectory(folderName))
        {
        	 String fileName = folderName+objectDescriptor.get(OBJECT_NAME)+ANGULAR_FILE_SUFFIX_FILTER_TPL;
	        logger.debug("fileName to generate : "+ fileName);
	        
	        File f = new File(fileName);
	        if(!f.exists()){
	        	Writer out = new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName("UTF-8"));
	            temp.process(objectDescriptor, out);
	            out.flush();
	            out.close();
	        }
	        else
	        {
	        	logger.info("fileName "+ fileName+" already exists, skipping it");
	        }
        }
	}
	
	private static void generataServiceFile(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor)  throws Exception {
		 Template temp = cfg.getTemplate(ANGULAR_SERVICE_TPL, "UTF-8");
        
        String folderName = prop.getProperty(ANGULAR_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/";
        if (AppUtils.createDirectory(folderName))
        {
        	String fileName = folderName+objectDescriptor.get(OBJECT_NAME)+ANGULAR_FILE_SUFFIX_SERVICE_TPL;
	        logger.debug("fileName to generate : "+ fileName);
	        
	        File f = new File(fileName);
	        if(!f.exists()){
	        	Writer out = new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName("UTF-8"));
	            temp.process(objectDescriptor, out);
	            out.flush();
	            out.close();
	        }
	        else
	        {
	        	logger.info("fileName "+ fileName+" already exists, skipping it");
	        }
        }
	}*/

}
