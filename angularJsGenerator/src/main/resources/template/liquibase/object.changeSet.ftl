<?xml version="1.0" encoding="UTF-8"?>

<databaseChangeLog
  xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
         http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.1.xsd">

    <changeSet id="changelog-${objectName}" author="CodeGenerator">
		
		<createTable
            schemaName="DBO"
            tableName="${objectNameTable}">
				<column name="id" type="numeric(19,0)" autoIncrement="true">
					<constraints primaryKey="true" primaryKeyName="${objectName}PK" nullable="false"/>
				</column>
				
				<#assign attributes = listDatabaseElt>
				<#list attributes as attribut>
				<column name="${attribut.dbColumnName}" type="${attribut.liquibaseColumnType}"/>
				</#list>
				
		</createTable>
	
    </changeSet>
</databaseChangeLog>

