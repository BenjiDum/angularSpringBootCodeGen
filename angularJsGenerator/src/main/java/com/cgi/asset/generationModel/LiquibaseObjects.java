package com.cgi.asset.generationModel;

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

public class LiquibaseObjects {
	
	private static final Logger logger = LoggerFactory.getLogger(LiquibaseObjects.class);

	private static final String OBJECT_NAME = "objectName";
	
	private static final String LIQUIBASE_FOLDER = "codeRootFolderGeneration";
	
	private static final String LIQUIBASE_MAIN_TPL = "/liquibase/object.changeSet.ftl";
	
	private static final String LIQUIBASE_FILE_SUFFIX_MAIN_TPL = ".changelog.xml";
	
	
	public static void generateLiquibaseFilesForObject(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor){        
        
		try {
			generateMainChangeSetFile(prop, cfg, objectDescriptor);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	private static void generateMainChangeSetFile(Properties prop, Configuration cfg, Map<String, Object> objectDescriptor)  throws Exception {
	
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(LIQUIBASE_MAIN_TPL, "UTF-8");
        
        String folderName = prop.getProperty(LIQUIBASE_FOLDER)+objectDescriptor.get(OBJECT_NAME)+"/";
        if (AppUtils.createDirectory(folderName))
        {
        	 /* Merge data-model with template */
            String fileName = folderName+objectDescriptor.get(OBJECT_NAME)+LIQUIBASE_FILE_SUFFIX_MAIN_TPL;
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
