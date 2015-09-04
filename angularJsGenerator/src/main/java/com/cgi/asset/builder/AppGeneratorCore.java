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
	
		/*result.add(generateMapTestForRefValueConsumptionVehicle());
		result.add(generateMapTestForRefValueConsumptionGroup());
		result.add(generateMapTestForAnalysisParameters());
		result.add(generateMapTestForDataAnalysisVehicle());
		result.add(generateMapTestForDataAnalysisGroup());*/
		
		//result.add(generateMapTestForCustomer());
		//result.add(generateMapTestForParamSeuil());
		
		result.add(generateMapForRawDriverId());
		result.add(generateMapForHubTable());
		//result.add(generateMapTestForBrick());
		//result.add(generateMapTestForBrickOption());
		
		
		return result;		
	}
	
	private static Map<String, Object> generateMapForHubTable(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
		
		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("webServiceTechName");
        elet.add("webServiceDisplayName");
        elet.add("providedByElectrum");
        elet.add("providedByNewbiz");
        
        String objectName = "refRoutingTable";
        String objectNameUpper = "RefRoutingTable";
        String packageName = "com.michelin.solutions.electrum";
        String objectNameTable = "ref_routing_table";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        String moduleBaseUrlParamName = "CServerUrlOffer";
        
        objectDescriptor.put("moduleBaseUrlParamName", moduleBaseUrlParamName);
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("objectNameFullUpper", objectNameUpper.toUpperCase());
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("web_service_tech_name", "String", "webServiceTechName", "WebServiceTechName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("web_service_display_name", "String", "webServiceDisplayName", "WebServiceDisplayName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("provided_by_electrum", "Boolean", "webServiceDisplayName", "WebServiceDisplayName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("provided_by_newbiz", "Boolean", "providedByNewbiz", "ProvidedByNewbiz"));


                
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		
		return objectDescriptor;
	}
	
	private static Map<String, Object> generateMapForRawDriverId(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
		
		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("driverFk");
        elet.add("rawDriverId");
        
        String objectName = "rawDriverIdRef";
        String objectNameUpper = "RawDriverIdRef";
        String packageName = "com.michelin.solutions.newbiz";
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        String objectNameTable = "raw_driver_id_ref";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        String moduleBaseUrlParamName = "CServerUrlOffer";
        
        objectDescriptor.put("moduleBaseUrlParamName", moduleBaseUrlParamName);
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("objectNameFullUpper", objectNameUpper.toUpperCase());
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("driver_fk", "Integer", "driverFk", "DriverFk"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("raw_driver_id", "String", "rawDriverId", "RawDriverId"));


                
        objectDescriptor.put("packageName", packageName);
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		
		return objectDescriptor;
	}
	
	
	private static Map<String, Object> generateMapForOfferConfiguration(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
		
		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("offerId");
        elet.add("brickId");
        elet.add("brickOptionId");
        elet.add("brickStatus");
        
        String objectName = "offerConfiguration";
        String objectNameUpper = "OfferConfiguration";
        String packageName = "com.michelin.solutions.newbiz.offer";
        String objectNameTable = "offer_configuration";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        String moduleBaseUrlParamName = "CServerUrlOffer";
        
        objectDescriptor.put("moduleBaseUrlParamName", moduleBaseUrlParamName);
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("objectNameFullUpper", objectNameUpper.toUpperCase());
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("offer_id", "Integer", "offerId", "OfferId"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("brick_id", "Integer", "brickId", "BrickId"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("brick_option_id", "Integer", "brickOptionId", "BrickOptionId"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("brick_status", "String", "brickStatus", "BrickStatus"));

                
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		
		return objectDescriptor;
	}
	
	
	private static Map<String, Object> generateMapTestForBrick(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
		
		List<String> elet = new ArrayList<String>();
		elet.add("id");
        elet.add("brickName");
        
        
        String objectName = "brick";
        String objectNameUpper = "Brick";
        String packageName = "com.michelin.solutions.newbiz.offer";
        String objectNameTable = "brick";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        String moduleBaseUrlParamName = "CServerUrlOffer";
        
        objectDescriptor.put("moduleBaseUrlParamName", moduleBaseUrlParamName);
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("objectNameFullUpper", objectNameUpper.toUpperCase());
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("brick_name", "String", "brickName", "BrickName"));
        
                
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		
		
		return objectDescriptor;
	}
	
	private static Map<String, Object> generateMapTestForBrickOption(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
		
		List<String> elet = new ArrayList<String>();
		elet.add("id");
        elet.add("brickOptionName");
        elet.add("relatedBrickId");
        
        
        String objectName = "brickOption";
        String objectNameUpper = "BrickOption";
        String packageName = "com.michelin.solutions.newbiz.offer";
        String objectNameTable = "brick_option";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        String moduleBaseUrlParamName = "CServerUrlOffer";
        
        objectDescriptor.put("moduleBaseUrlParamName", moduleBaseUrlParamName);
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("objectNameFullUpper", objectNameUpper.toUpperCase());
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("brick_option_name", "String", "brickOptionName", "BrickOptionName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_brick_id", "Integer", "relatedBrickId", "RelatedBrickId"));

                
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		
		return objectDescriptor;
	}
	
	
	private static Map<String, Object> generateMapTestForCustomer(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
		
		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("customerReportingName");
        elet.add("custDeliveredId");
        elet.add("custInvoicedId");
        elet.add("custCommercialId");
        
        
        String objectName = "newbizCustomer";
        String objectNameUpper = "NewbizCustomer";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "newbiz_customer";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("customer_reporting_name", "String", "customerReportingName", "CustomerReportingName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("cust_delivered_id", "Integer", "custDeliveredId", "CustDeliveredId"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("cust_invoiced_id", "Integer", "custInvoicedId", "CustInvoicedId"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("cust_commercial_id", "Integer", "custCommercialId", "CustCommercialId"));

                
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		
		return objectDescriptor;
	}
		
	

	private static Map<String, Object> generateMapTestForParamSeuil(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
			
		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("groupId");
        elet.add("isActive");
        elet.add("seuilConsoVert");
        elet.add("seuilConsoOrange");
        elet.add("seuilConsoRouge");
        elet.add("seuilTendanceVert");
        elet.add("seuilTendanceOrange");
        elet.add("seuilTendanceRouge");
        elet.add("seuilChargeVert");
        elet.add("seuilChargeOrange");
        elet.add("seuilChargeRouge");
        elet.add("seuilKmVert");
        elet.add("seuilKmOrange");
        elet.add("seuilKmRouge");
        elet.add("seuilEcoScoreGlobalVert");
        elet.add("seuilEcoScoreGlobalOrange");
        elet.add("seuilEcoScoreGlobalRouge");
        
        
        
        String objectName = "electrumParamSeuil";
        String objectNameUpper = "ElectrumParamSeuil";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "electrum_param_seuil";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("group_id", "Integer", "groupId", "GroupId"));		
        databaseElements.add(new JavaDatabaseObjectDescriptor("is_active", "boolean", "isActive", "IsActive"));
        //Conso
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_conso_vert", "float", "seuilConsoVert", "SeuilConsoVert"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_conso_orange", "float", "seuilConsoOrange", "SeuilConsoOrange"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_conso_rouge", "float", "seuilConsoRouge", "SeuilConsoRouge"));
        
        //Tendance
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_tendance_vert", "float", "seuilTendanceVert", "SeuilTendanceVert"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_tendance_orange", "float", "seuilTendanceOrange", "SeuilTendanceOrange"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_tendance_rouge", "float", "seuilTendanceRouge", "SeuilTendanceRouge"));
        
      	//Charge
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_charge_vert", "float", "seuilChargeVert", "SeuilChargeVert"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_charge_orange", "float", "seuilChargeOrange", "SeuilChargeOrange"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_charge_rouge", "float", "seuilChargeRouge", "SeuilChargeRouge"));
        
        //Km
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_km_vert", "float", "seuilKmVert", "SeuilKmVert"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_km_orange", "float", "seuilKmOrange", "SeuilKmOrange"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_km_rouge", "float", "seuilKmRouge", "SeuilKmRouge"));
        
        //EcoScoreGlobal
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_eco_score_vert", "float", "seuilEcoScoreVert", "SeuilEcoScoreVert"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_eco_score_orange", "float", "seuilEcoScoreOrange", "SeuilEcoScoreOrange"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("seuil_eco_score_rouge", "float", "seuilEcoScoreRouge", "SeuilEcoScoreRouge"));
        
                
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		
		return objectDescriptor;
	}
	
	
	
	private static Map<String, Object> generateMapTestForRefValueConsumptionVehicle(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
	

		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("relatedVehicleId");
        elet.add("startDate");
        elet.add("endDate");
        elet.add("creationDate");
        elet.add("referenceValue");
        
        String objectName = "refValueConsumptionVehicle";
        String objectNameUpper = "RefValueConsumptionVehicle";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "ref_value_consumption_vehicle";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_vehicle_id", "Integer", "relatedVehicleId", "RelatedVehicleId"));		
        databaseElements.add(new JavaDatabaseObjectDescriptor("start_date", "Date", "startDate", "StartDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("end_date", "Date", "endDate", "EndDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("creation_date", "Date", "creationDate", "CreationDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("reference_value", "float", "referenceValue", "ReferenceValue"));
                
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		
		return objectDescriptor;
	}
	
	private static Map<String, Object> generateMapTestForRefValueConsumptionGroup(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
	

		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("relatedGroupId");
        elet.add("startDate");
        elet.add("endDate");
        elet.add("creationDate");
        elet.add("referenceValue");
        
        String objectName = "refValueConsumptionGroup";
        String objectNameUpper = "RefValueConsumptionGroup";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "ref_value_consumption_group";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_group_id", "Integer", "relatedGroupId", "RelatedGroupId"));		
        databaseElements.add(new JavaDatabaseObjectDescriptor("start_date", "Date", "startDate", "StartDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("end_date", "Date", "endDate", "EndDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("creation_date", "Date", "creationDate", "CreationDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("reference_value", "float", "referenceValue", "ReferenceValue"));
                
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		
		return objectDescriptor;
	}
	
	private static Map<String, Object> generateMapTestForAnalysisParameters(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
		
		
		/*
		analysis_parameters 
		Integer id
		String parameter_name
		*/


		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("parameterName");

        
        String objectName = "analysisParameter";
        String objectNameUpper = "AnalysisParameter";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "analysis_parameter";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("parameter_name", "String", "parameterName", "ParameterName"));		

                
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		
		return objectDescriptor;
	}
	
	
	private static Map<String, Object> generateMapTestForDataAnalysisVehicle(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
	


		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("relatedVehicleId");
        elet.add("relatedParameterId");
        elet.add("startDate");
        elet.add("endDate");
        elet.add("creationDate");
        elet.add("paramValue");
        
        
        
        String objectName = "analysisParameterVehicleLevel";
        String objectNameUpper = "AnalysisParameterVehicleLevel";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "analysis_parameter_vehicle_level";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_vehicle_id", "Integer", "relatedVehicleId", "RelatedVehicleId"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_parameter_id", "Integer", "relatedParameterId", "RelatedParameterId"));	
        databaseElements.add(new JavaDatabaseObjectDescriptor("start_date", "Date", "startDate", "StartDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("end_date", "Date", "endDate", "EndDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("creation_date", "Date", "creationDate", "CreationDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("parameter_value", "float", "parameterValue", "ParameterValue"));
                
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		
		return objectDescriptor;
	}
	
	
	private static Map<String, Object> generateMapTestForDataAnalysisGroup(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
	


		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("relatedGroupId");
        elet.add("relatedParameterId");
        elet.add("startDate");
        elet.add("endDate");
        elet.add("creationDate");
        elet.add("paramValue");
        
        
        
        String objectName = "analysisParameterGroupLevel";
        String objectNameUpper = "AnalysisParameterGroupLevel";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "analysis_parameter_group_level";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_group_id", "Integer", "relatedGroupId", "RelatedGroupId"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_parameter_id", "Integer", "relatedParameterId", "RelatedParameterId"));	
        databaseElements.add(new JavaDatabaseObjectDescriptor("start_date", "Date", "startDate", "StartDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("end_date", "Date", "endDate", "EndDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("creation_date", "Date", "creationDate", "CreationDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("parameter_value", "float", "parameterValue", "ParameterValue"));
                
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		
		return objectDescriptor;
	}

	
	private static Map<String, Object> generateMapTestForElectrumTraductionLanguage(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
	
		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("isoCode");
        elet.add("displayName");
        
        String objectName = "electrumLanguage";
        String objectNameUpper = "ElectrumLanguage";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "electrum_language";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("iso_code", "String", "isoCode", "IsoCode"));		
        databaseElements.add(new JavaDatabaseObjectDescriptor("display_name", "String", "displayName", "DisplayName"));
        
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		return objectDescriptor;
	}
	
	private static Map<String, Object> generateMapTestForElectrumTraductionLanguageValues(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
		
		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("elementKey");
        elet.add("elementValue");
        elet.add("relatedLanguage");
        
        String objectName = "electrumTraductibleElement";
        String objectNameUpper = "ElectrumTraductibleElement";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "electrum_trad_element";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("element_key", "String", "elementKey", "ElementKey"));		
        databaseElements.add(new JavaDatabaseObjectDescriptor("element_value", "String", "elementValue", "ElementValue"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_language", "String", "relatedLanguage", "RelatedLanguage"));
        
        
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);
		
		return objectDescriptor;
	}
	
		
	private static Map<String, Object> generateMapTestForDriverId(){
		
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
		
		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("driverId");
        elet.add("firstName");
        elet.add("lastName");
        elet.add("trainingValidationDate");
        elet.add("trainer");
        elet.add("driverFleetName");
        elet.add("trainingComment");
        
        
        
        
      
        String objectName = "driver";
        String objectNameUpper = "Driver";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "driver";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> eletZ = new ArrayList<JavaDatabaseObjectDescriptor>();
        
        eletZ.add(new JavaDatabaseObjectDescriptor("driver_id", "String", "driverId", "DriverId"));		
        eletZ.add(new JavaDatabaseObjectDescriptor("first_name", "String", "firstName", "FirstName"));
        eletZ.add(new JavaDatabaseObjectDescriptor("last_name", "String", "lastName", "LastName"));
        eletZ.add(new JavaDatabaseObjectDescriptor("training_val_dt", "Date", "trainingValidationDate", "TrainingValidationDate"));
        eletZ.add(new JavaDatabaseObjectDescriptor("trainer", "String", "trainer", "trainer"));
        eletZ.add(new JavaDatabaseObjectDescriptor("driver_fleet_name", "String", "driverFleetName", "DriverFleetName"));
        eletZ.add(new JavaDatabaseObjectDescriptor("training_comment", "String", "trainingComment", "TrainingComment"));
        
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", eletZ);
		
		return objectDescriptor;
		
	}
	
	private static Map<String, Object> generateMapTestForWorkingSample(){
		
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
		
		List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("driverId");
        elet.add("driverFirstName");
        elet.add("driverLastName");
        elet.add("driverValidationDate");
        
        
        
      
        String objectName = "vehicleGroupBis";
        String objectNameUpper = "VehicleGroupBis";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "vehicle_group";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);
        
        List<JavaDatabaseObjectDescriptor> eletZ = new ArrayList<JavaDatabaseObjectDescriptor>();

        eletZ.add(new JavaDatabaseObjectDescriptor("group_code", "String", "groupCode", "GroupCode"));
        eletZ.add(new JavaDatabaseObjectDescriptor("group_name", "String", "groupName", "GroupName"));
        eletZ.add(new JavaDatabaseObjectDescriptor("related_offer_id", "Integer", "relatedOffer", "RelatedOffer"));
        eletZ.add(new JavaDatabaseObjectDescriptor("customer_name", "String", "customerName", "customerName"));
		
        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", eletZ);
		
		return objectDescriptor;
		
	}
	
}
