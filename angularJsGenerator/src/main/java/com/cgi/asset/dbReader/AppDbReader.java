package com.cgi.asset.dbReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import java.sql.*;

import com.cgi.asset.angular.AngularObjects;
import com.cgi.asset.springboot.JavaDatabaseObjectDescriptor;
import com.cgi.asset.springboot.SpringBootObjects;

import freemarker.template.Configuration;

public class AppDbReader {

	//Properties applicationProperties = null;
	Connection localConn = null;

	Map<String, Object> databaseDescription = null;
	
	String url;
	
	String dbName;
	
	String driver;
	
	String userName;
	
	String password;
	
	private final static String URLPARAM = "databaseUrl";
	
	private final static String USERNAME = "databaseUserName";
	
	private final static String DBNAME = "databaseDbName";
	
	private final static String DRIVER = "databaseDriver";
	
	private final static String PASSWORD = "databasePassword";
	
	public AppDbReader() {
		super();
		databaseDescription = new HashMap<String, Object>();
	}
	
	public AppDbReader(Properties prop) {
		super();
		databaseDescription = new HashMap<String, Object>();
		setUrl(prop.getProperty(URLPARAM));
		setUserName(prop.getProperty(USERNAME));
		setDbName(prop.getProperty(DBNAME));
		setDriver(prop.getProperty(DRIVER));
		setPassword(prop.getProperty(PASSWORD));
	}

	public Connection getLocalConn() {
		return localConn;
	}

	public void setLocalConn(Connection localConn) {
		this.localConn = localConn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void analyseDatabase() throws Exception{
		if (getLocalConn() == null)
		{
			getInitialisedConnection(getUrl(), getDbName(), getDriver(), getUserName(), getPassword());
		}
		List<String> tableNameList = new ArrayList<String>();
		
		Statement stmt = getLocalConn().createStatement();
		
		String listTableQuery = "show tables";
		
		ResultSet rs = stmt.executeQuery(listTableQuery);
		while (rs.next()) {
			tableNameList.add(rs.getString(1));
		}
		
		for (String tableName : tableNameList) {
			analyseTable(tableName);
		}
		
		//setLocalConn(getInitialisedConnection(prop.getProperty(""), prop.getProperty(""), prop.getProperty(""), prop.getProperty(""), prop.getProperty("")));
		
		
		
	
		//generateMapTestForElectrumTraductionLanguageValues
		
	}
	
	public void analyseTable(String tableName)  throws Exception{
		Statement stmt = getLocalConn().createStatement();
		String listTableQuery = "DESCRIBE "+tableName;
		ResultSet rs = stmt.executeQuery(listTableQuery);
		while (rs.next()) {
			System.out.println(rs.getString(1));
//			tableNameList.add(rs.getString(1));
		}
	}
	
	private void getInitialisedConnection (String url, String dbName, String driver, String userName, String password){
			// String url = "jdbc:mysql://localhost/";
			// String dbName = "bank";
			// String driver = "com.mysql.jdbc.Driver";
			// String userName = "root";
			// String password = "password";
		try {
			Class.forName(driver).newInstance();
			setLocalConn(DriverManager.getConnection(url+dbName,userName,password));
			System.out.println("Connected to the database");
		} catch (Exception e) {
			System.out.println("NO CONNECTION =(");
		}
	}
	
	private static Map<String, Object> generateMapTestForChangeHistory(){
		Map<String, Object> objectDescriptor = new HashMap<String, Object>();
	
		
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
        objectDescriptor.put("listDatabaseElt", eletZ);
		
		return objectDescriptor;
		
	}
	
}
