package com.michelin.solutions.model;

import com.cgi.asset.springboot.JavaDatabaseObjectDescriptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dumasbe on 09/09/2015.
 */
public class NewbizModelServiceProvider {


    public static Map<String, Object> generateMapHeadOffice(){
        Map<String, Object> objectDescriptor = new HashMap<String, Object>();

        List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("companyName");
        elet.add("address");
        elet.add("zipCode");
        elet.add("city");
        elet.add("country");
        elet.add("contactName");
        elet.add("phoneNumber");
        elet.add("emailAddress");

        String objectName = "spHeadOffice";
        String objectNameUpper = "SpHeadOffice";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "sp_head_office";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        String moduleBaseUrlParamName = "CServerUrl";

        objectDescriptor.put("moduleBaseUrlParamName", moduleBaseUrlParamName);
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("objectNameFullUpper", objectNameUpper.toUpperCase());
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);

        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();

        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("company_name", "String", "companyName", "CompanyName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("address", "String", "address", "Address"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("zip_code", "String", "zipCode", "ZipCode"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("city", "String", "city", "City"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("country", "String", "country", "Country"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("contact_name", "String", "contactName", "ContactName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("phone_number", "String", "phoneNumber", "PhoneNumber"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("email_address", "String", "emailAddress", "EmailAddress"));


        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);

        return objectDescriptor;
    }

    public static Map<String, Object> generateMapAgency(){
        Map<String, Object> objectDescriptor = new HashMap<String, Object>();

        List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("relatedHeadOffice");
        elet.add("companyName");
        elet.add("address");
        elet.add("zipCode");
        elet.add("city");
        elet.add("country");
        elet.add("contactName");
        elet.add("phoneNumber");
        elet.add("emailAddress");

        String objectName = "spAgency";
        String objectNameUpper = "SpAgency";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "sp_agency";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        String moduleBaseUrlParamName = "CServerUrl";

        objectDescriptor.put("moduleBaseUrlParamName", moduleBaseUrlParamName);
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("objectNameFullUpper", objectNameUpper.toUpperCase());
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);

        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();

        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("company_name", "String", "companyName", "CompanyName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("address", "String", "address", "Address"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("zip_code", "String", "zipCode", "ZipCode"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("city", "String", "city", "City"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("country", "String", "country", "Country"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("contact_name", "String", "contactName", "ContactName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("phone_number", "String", "phoneNumber", "PhoneNumber"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("email_address", "String", "emailAddress", "EmailAddress"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_head_office", "String", "relatedHeadOffice", "RelatedHeadOffice"));


        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);

        return objectDescriptor;
    }

    public static Map<String, Object> generateMapDeliverySite(){
        Map<String, Object> objectDescriptor = new HashMap<String, Object>();

        List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("relatedAgency");
        elet.add("companyName");
        elet.add("address");
        elet.add("zipCode");
        elet.add("city");
        elet.add("country");
        elet.add("contactName");
        elet.add("phoneNumber");
        elet.add("emailAddress");

        String objectName = "spDeliverySite";
        String objectNameUpper = "SpDeliverySite";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "sp_delivery_site";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        String moduleBaseUrlParamName = "CServerUrl";

        objectDescriptor.put("moduleBaseUrlParamName", moduleBaseUrlParamName);
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("objectNameFullUpper", objectNameUpper.toUpperCase());
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);

        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();

        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("company_name", "String", "companyName", "CompanyName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("address", "String", "address", "Address"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("zip_code", "String", "zipCode", "ZipCode"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("city", "String", "city", "City"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("country", "String", "country", "Country"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("contact_name", "String", "contactName", "ContactName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("phone_number", "String", "phoneNumber", "PhoneNumber"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("email_address", "String", "emailAddress", "EmailAddress"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_agency", "String", "relatedAgency", "RelatedAgency"));


        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);

        return objectDescriptor;
    }

    public static Map<String, Object> generateMapForContacts(){
        Map<String, Object> objectDescriptor = new HashMap<String, Object>();

        List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("relatedAgency");
        elet.add("contactFirstName");
        elet.add("contactLastName");
        elet.add("email");
        elet.add("agencyId");
        elet.add("comment");


        String objectName = "spContact";
        String objectNameUpper = "SpContact";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "sp_contact";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        String moduleBaseUrlParamName = "CServerUrl";

        objectDescriptor.put("moduleBaseUrlParamName", moduleBaseUrlParamName);
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("objectNameFullUpper", objectNameUpper.toUpperCase());
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);

        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();

        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("contact_first_name", "String", "contactFirstName", "ContactFirstName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("contact_last_name", "String", "contactLastName", "ContactLastName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("email", "String", "email", "Email"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("agency_id", "Integer", "agencyId", "AgencyId"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("comment", "String", "comment", "Comment"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_agency", "Integer", "relatedAgency", "RelatedAgency"));

        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);

        return objectDescriptor;
    }

    public static Map<String, Object> generateMapForStocks(){
        Map<String, Object> objectDescriptor = new HashMap<String, Object>();

        List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("relatedDeliverySite");
        elet.add("materialType");
        elet.add("materialName");
        elet.add("materialId");
        elet.add("quantity");
        elet.add("deliveryDate");
        elet.add("installationDate");
        elet.add("relatedPlateNumber");
        elet.add("relatedCustomer");
        elet.add("disassemblyDate");
        elet.add("returnDateToExpertise");
        elet.add("equipmentStatus");

        String objectName = "spStock";
        String objectNameUpper = "SpStock";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "sp_stock";
        String springDataRestBaseUri = "${spring.data.rest.base-uri}";
        String moduleBaseUrlParamName = "CServerUrl";

        objectDescriptor.put("moduleBaseUrlParamName", moduleBaseUrlParamName);
        objectDescriptor.put("springDataRestBaseUri", springDataRestBaseUri);
        objectDescriptor.put("objectName", objectName);
        objectDescriptor.put("objectNameUpper", objectNameUpper);
        objectDescriptor.put("objectNameFullUpper", objectNameUpper.toUpperCase());
        objectDescriptor.put("listElement", elet);
        objectDescriptor.put("objectNameTable", objectNameTable);

        List<JavaDatabaseObjectDescriptor> databaseElements = new ArrayList<JavaDatabaseObjectDescriptor>();

        /* Don't put the id item in the database column List*/
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_delivery_site", "Integer", "relatedDeliverySite", "RelatedDeliverySite"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("material_type", "String", "materialType", "MaterialType"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("material_name", "String", "materialName", "MaterialName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("material_id", "Integer", "materialId", "MaterialId"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("quantity", "Integer", "quantity", "Quantity"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("delivery_date", "Date", "deliveryDate", "deliveryDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("installation_date", "Date", "installationDate", "InstallationDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_plate_number", "String", "relatedPlateNumber", "RelatedPlateNumber"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_customer", "Integer", "relatedCustomer", "RelatedCustomer"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("disassembly_date", "Date", "disassemblyDate", "DisassemblyDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("return_date_to_expertise", "Date", "returnDateToExpertise", "ReturnDateToExpertise"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("equipment_status", "Date", "equipmentStatus", "EquipmentStatus"));

        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);

        return objectDescriptor;
    }


}
