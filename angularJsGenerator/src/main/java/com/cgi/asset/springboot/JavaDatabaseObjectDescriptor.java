package com.cgi.asset.springboot;

public class JavaDatabaseObjectDescriptor {
	String dbColumnName;
	
	String javaType;
	
	String liquibaseColumnType;
	
	String name;
	
	String upperName;
	
	private final static String JAVA_STRING = "String";
	
	private final static String JAVA_FLOAT = "float";
	
	private final static String JAVA_INTEGER = "Integer";
	
	private final static String JAVA_BOOLEAN = "boolean";
	
	private final static String JAVA_DATE = "Date";
	
	private final static String LIQUIBASE_STRING = "varchar(255)";
	
	private final static String LIQUIBASE_FLOAT = "float";
	
	private final static String LIQUIBASE_INTEGER = "numeric(19,0)";
	
	private final static String LIQUIBASE_BOOLEAN = "tinyint";
	
	private final static String LIQUIBASE_DATE = "datetime";
	
	private final static String LIQUIBASE_UNKNOWN = "LIQUIBASE_UNKNOWN";
	

	public String getDbColumnName() {
		return dbColumnName;
	}

	public void setDbColumnName(String dbColumnName) {
		this.dbColumnName = dbColumnName;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	
	public String getLiquibaseColumnType() {
		return liquibaseColumnType;
	}

	public void setLiquibaseColumnType(String liquibaseColumnType) {
		this.liquibaseColumnType = liquibaseColumnType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpperName() {
		return upperName;
	}

	public void setUpperName(String upperName) {
		this.upperName = upperName;
	}
	
	public JavaDatabaseObjectDescriptor(String dbColumnName, String javaType,
			String name, String upperName) {
		super();
		this.dbColumnName = dbColumnName;
		this.javaType = javaType;
		this.name = name;
		this.upperName = upperName;
		this.liquibaseColumnType = buildLiquibaseColumnMatching(javaType);
	}
	
	private String buildLiquibaseColumnMatching(String javaType){
		if (javaType.equalsIgnoreCase(JAVA_STRING)) {
			return LIQUIBASE_STRING;
		}
		if (javaType.equalsIgnoreCase(JAVA_FLOAT)) {
			return LIQUIBASE_FLOAT;
		}
		if (javaType.equalsIgnoreCase(JAVA_INTEGER)) {
			return LIQUIBASE_INTEGER;
		}
		if (javaType.equalsIgnoreCase(JAVA_BOOLEAN)) {
			return LIQUIBASE_BOOLEAN;
		}
		if (javaType.equalsIgnoreCase(JAVA_DATE)) {
			return LIQUIBASE_DATE;
		}		
		return LIQUIBASE_UNKNOWN;
	}

	
}
