package com.cgi.asset.builder;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.michelin.solutions.model.NewbizModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cgi.asset.angular.AngularObjects;
import com.cgi.asset.liquibase.LiquibaseObjects;
import com.cgi.asset.springboot.JavaDatabaseObjectDescriptor;
import com.cgi.asset.springboot.SpringBootObjects;

import freemarker.template.Configuration;

public class AppGeneratorCore {

	//Properties applicationProperties = null;
	
	private static final String CODE_ROOT_FOLDER = "springBootCodeFolderGeneration";
	
	private static final Logger logger = LoggerFactory.getLogger(AppGeneratorCore.class);

	
	public static void generateApplication(Properties prop, Configuration cfg) throws Exception{

		
		//Map<String, Object> objectDescriptor = new HashMap<String, Object>();
		
		//objectDescriptor = generateMapTestForElectrumTraductionLanguage();
		
		
		for (Map<String, Object> objectDescriptor : generateObjectsDescriptor()){
			if (prop.get("generateAngularPart").equals("true")){
				AngularObjects.generateAngularFilesForObject(prop, cfg, objectDescriptor);   
			}
	        
			if (prop.get("generateSpringPart").equals("true")){
				SpringBootObjects.generateSpringFilesForObject(prop, cfg, objectDescriptor);
				
			}
			
			if (prop.get("generateDatabasePart").equals("true")){
				LiquibaseObjects.generateLiquibaseFilesForObject(prop, cfg, objectDescriptor);
				
			}
		}
		
		mergingGeneratedJavaFiles(prop);
		
				
	}
	
	
	private static void mergingGeneratedJavaFiles(Properties prop){
		
		String rootFolderName = prop.getProperty(CODE_ROOT_FOLDER);
		
		if (AppUtils.createDirectory(rootFolderName)){
			//File dir = new File(rootFolderName);
		   Path p = Paths.get(rootFolderName);
		    FileVisitor<Path> fv = new SimpleFileVisitor<Path>() {
		      @Override
		      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
		          throws IOException {
		    	
		    	  
		        System.out.println(file);
		        return FileVisitResult.CONTINUE;
		      }
		    };

		    try {
		      Files.walkFileTree(p, fv);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }

			
			
			//dir.
			
			
		}
		else{
			logger.error("it sucks");
		}
		
		
		
	}
	
	private static List<Map<String, Object>> generateObjectsDescriptor()
	{
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();

        //result.add(NewbizModel.generateMapForArticle());
        //result.add(NewbizModel.generateMapForStock());
        //result.add(NewbizModel.generateMapForSupplier());
		result.add(NewbizModel.generateMapForContacts());

		/*result.add(generateMapTestForRefValueConsumptionVehicle());
		result.add(generateMapTestForRefValueConsumptionGroup());
		result.add(generateMapTestForAnalysisParameters());
		result.add(generateMapTestForDataAnalysisVehicle());
		result.add(generateMapTestForDataAnalysisGroup());*/
		
		//result.add(generateMapTestForCustomer());
		//result.add(generateMapTestForParamSeuil());
		
		//result.add(generateMapForRawDriverId());
		//result.add(generateMapForHubTable());
		//result.add(generateMapTestForBrick());
		//result.add(generateMapTestForBrickOption());
		
		
		return result;		
	}

}
