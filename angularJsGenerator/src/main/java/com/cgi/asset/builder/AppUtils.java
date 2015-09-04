package com.cgi.asset.builder;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cgi.asset.springboot.SpringBootObjects;

public class AppUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(AppUtils.class);


	public static boolean createDirectory(String folderPath) {
		File dir = new File(folderPath);
		boolean result = false;
		if(!dir.exists()){
			logger.info("Creating folder  : "+folderPath);
			result = dir.mkdirs();
			
			if (!result){
				logger.error("Unable to create folder  : "+folderPath);
			}
		}
		else{
			if(!dir.isDirectory()){
				result = true;
				logger.error("File "+folderPath+"exists but it is not a directory.");
			}
			else{
				result = true;
				logger.info("Folder "+folderPath+" already exists");
			}
		}		
		return result;
	}
	
}
