package com.cgi.asset.angular;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cgi.asset.builder.AppUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class AngularObjects {
	
	private static final Logger logger = LoggerFactory.getLogger(AngularObjects.class);

	private static final String OBJECT_NAME = "objectName";
	
	private static final String ANGULAR_FOLDER = "angularCodeFolderGeneration";
	
	private static final String ANGULAR_MAIN_TPL = "/angular/object.main.ftl";
	
	private static final String ANGULAR_CREATE_MODAL_TPL = "/angular/object.modal.create.ftl";
	
	private static final String ANGULAR_EDIT_MODAL_TPL = "/angular/object.modal.edit.ftl";
	
	private static final String ANGULAR_CONTROLLER_TPL = "/angular/object.controller.ftl";
	
	private static final String ANGULAR_FILTER_TPL = "/angular/object.filters.ftl";
	
	private static final String ANGULAR_SERVICE_TPL = "/angular/object.services.ftl";
	
	private static final String ANGULAR_FILE_SUFFIX_MAIN_TPL = ".main.html";
	
	private static final String ANGULAR_FILE_SUFFIX_CREATE_MODAL_TPL = ".create.partial.html";
	
	private static final String ANGULAR_FILE_SUFFIX_EDIT_MODAL_TPL = ".edit.partial.html";
	
	private static final String ANGULAR_FILE_SUFFIX_CONTROLLER_TPL = ".controllers.js";
	
	private static final String ANGULAR_FILE_SUFFIX_FILTER_TPL = ".filters.js";
	
	private static final String ANGULAR_FILE_SUFFIX_SERVICE_TPL = ".services.js";
	
	
	
	public static void generateAngularFilesForObject(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor){        
        
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
	
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(ANGULAR_MAIN_TPL, "UTF-8");
        
        String folderName = prop.getProperty(ANGULAR_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/";
        if (AppUtils.createDirectory(folderName))
        {
        	 /* Merge data-model with template */
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
		
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(ANGULAR_CREATE_MODAL_TPL, "UTF-8");
        
        String folderName = prop.getProperty(ANGULAR_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/";
        if (AppUtils.createDirectory(folderName))
        {
        	 /* Merge data-model with template */
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
		
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(ANGULAR_EDIT_MODAL_TPL, "UTF-8");
        
        String folderName = prop.getProperty(ANGULAR_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/";
        if (AppUtils.createDirectory(folderName))
        {
        	 /* Merge data-model with template */
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
		/* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(ANGULAR_CONTROLLER_TPL, "UTF-8");
        
        String folderName = prop.getProperty(ANGULAR_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/";
        if (AppUtils.createDirectory(folderName))
        {
	        	 /* Merge data-model with template */
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
		/* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(ANGULAR_FILTER_TPL, "UTF-8");
        
        String folderName = prop.getProperty(ANGULAR_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/";
        if (AppUtils.createDirectory(folderName))
        {
        	 /* Merge data-model with template */
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
		/* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(ANGULAR_SERVICE_TPL, "UTF-8");
        
        String folderName = prop.getProperty(ANGULAR_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/";
        if (AppUtils.createDirectory(folderName))
        {
        	 /* Merge data-model with template */
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
	}

}
