package com.cgi.asset.generationModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cgi.asset.builder.AppUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class SpringBootObjects {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringBootObjects.class);

	private static final String OBJECT_NAME = "objectName";
	
	private static final String OBJECT_NAME_UPPER = "objectNameUpper";
	
	private static final String SPRING_BOOT_FOLDER = "springBootCodeFolderGeneration";

	private static final String SPRING_DOMAIN_TPL =     "/appArchetype/springBootBackEnd/src/main/java/packageNameTpl/domain/object.domain.ftl";
	
	private static final String SPRING_CONTROLLER_TPL = "/appArchetype/springBootBackEnd/src/main/java/packageNameTpl/controller/object.controller.ftl";

	private static final String SPRING_SERVICE_TPL =    "/appArchetype/springBootBackEnd/src/main/java/packageNameTpl/service/object.service.ftl";
	
	private static final String SPRING_DAO_TPL = "/appArchetype/springBootBackEnd/src/main/java/packageNameTpl/dao/object.dao.ftl";
	
	private static final String SPRING_FILE_SUFFIX_DOMAIN_TPL = ".java";
	
	private static final String SPRING_FILE_SUFFIX_CONTROLLER_TPL = "Controller.java";
	
	private static final String SPRING_FILE_SUFFIX_DAO_TPL = "DAO.java";

	private static final String SPRING_FILE_SUFFIX_SERVICE_TPL = "Service.java";

	private static final String SPRING_DOMAIN_PREFIX = "domain";
	
	private static final String SPRING_DAO_PREFIX = "dao";
	
	private static final String SPRING_CONTROLLER_PREFIX = "controller";

	private static final String SPRING_SERVICE_PREFIX = "service";
	
	
	public static void generateSpringFilesForObject(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor){
//		/* Create a data-model */
//        Map root = new HashMap();
//        root.put("user", "Big Joe");
//        Map latest = new HashMap();
//        root.put("latestProduct", latest);
//        latest.put("url", "products/greenmouse.html");
//        latest.put("name", "green mouse");
//        
        
        
        
        
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
		
		try {
			generateDomainFile(prop, cfg, objectDescriptor);
			
			generateControllerFile(prop, cfg, objectDescriptor);
			
			generateDaoFile(prop, cfg, objectDescriptor);

			generateServiceFile(prop, cfg, objectDescriptor);
			
			//generataServiceFile(prop, cfg, objectDescriptor);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	private static void generateDomainFile(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor)  throws Exception {
		
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(SPRING_DOMAIN_TPL, "UTF-8");
        
        
        /* Merge data-model with template */
        String folderName = prop.getProperty(SPRING_BOOT_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/"+SPRING_DOMAIN_PREFIX+"/";
        if (AppUtils.createDirectory(folderName))
        {
	        String fileName = folderName+objectDescriptor.get(OBJECT_NAME_UPPER)+SPRING_FILE_SUFFIX_DOMAIN_TPL;
	        logger.debug("fileName to generate : "+ fileName);
	        
	        File f = new File(fileName);
	        if(!f.exists()){
	        	Writer out = new OutputStreamWriter(new FileOutputStream(fileName));
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
        Template temp = cfg.getTemplate(SPRING_CONTROLLER_TPL, "UTF-8");
        
        /* Merge data-model with template */
        String folderName = prop.getProperty(SPRING_BOOT_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/"+SPRING_CONTROLLER_PREFIX+"/";
        if (AppUtils.createDirectory(folderName))
        {
        
	        String fileName = folderName+objectDescriptor.get(OBJECT_NAME_UPPER)+SPRING_FILE_SUFFIX_CONTROLLER_TPL;
	        logger.debug("fileName to generate : "+ fileName);
	        
	        File f = new File(fileName);
	        if(!f.exists()){
	        	Writer out = new OutputStreamWriter(new FileOutputStream(fileName));
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
	
	private static void generateDaoFile(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor)  throws Exception {
		/* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(SPRING_DAO_TPL, "UTF-8");
        
        /* Merge data-model with template */
        String folderName = prop.getProperty(SPRING_BOOT_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/"+SPRING_DAO_PREFIX+"/";
        if (AppUtils.createDirectory(folderName))
        {
        	String fileName = folderName + objectDescriptor.get(OBJECT_NAME_UPPER)+SPRING_FILE_SUFFIX_DAO_TPL;
            logger.debug("fileName to generate : "+ fileName);
            
            File f = new File(fileName);
            if(!f.exists()){
            	Writer out = new OutputStreamWriter(new FileOutputStream(fileName));
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
		
	private static void generateServiceFile(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor)  throws Exception {
		/* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(SPRING_SERVICE_TPL, "UTF-8");

		String folderName = prop.getProperty(SPRING_BOOT_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/"+SPRING_SERVICE_PREFIX+"/";
		if (AppUtils.createDirectory(folderName))
		{
			String fileName = folderName + objectDescriptor.get(OBJECT_NAME_UPPER)+SPRING_FILE_SUFFIX_SERVICE_TPL;
			logger.debug("fileName to generate : "+ fileName);

			File f = new File(fileName);
			if(!f.exists()){
				Writer out = new OutputStreamWriter(new FileOutputStream(fileName));
				temp.process(objectDescriptor, out);
				out.flush();
				out.close();
			}
			else
			{
				logger.info("fileName "+ fileName+" already exists, skipping it");
			}
		}

        /* Merge data-model with template */
        /*String fileName = folderName+objectDescriptor.get(OBJECT_NAME)+SPRING_FILE_SUFFIX_SERVICE_TPL;
        logger.debug("fileName to generate : "+ fileName);

        File f = new File(fileName);
        if(f.exists() && !f.isDirectory()){
        	Writer out = new OutputStreamWriter(new FileOutputStream(fileName));
            temp.process(objectDescriptor, out);
            out.flush();
            out.close();
        }
        else
        {
        	logger.info("fileName "+ fileName+" already exists, skipping it");
        }*/
	}

}
