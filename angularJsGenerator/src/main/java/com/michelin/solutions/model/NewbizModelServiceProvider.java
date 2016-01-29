package com.michelin.solutions.model;

import com.cgi.asset.utils.JavaDatabaseObjectDescriptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String objectNameTable = "SP_HEAD_OFFICE";
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
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
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
        String objectNameTable = "SP_AGENCY";
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
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_head_office", "String", "relatedHeadOffice", "RelatedHeadOffice"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("company_name", "String", "companyName", "CompanyName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("address", "String", "address", "Address"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("zip_code", "String", "zipCode", "ZipCode"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("city", "String", "city", "City"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("country", "String", "country", "Country"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("contact_name", "String", "contactName", "ContactName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("phone_number", "String", "phoneNumber", "PhoneNumber"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("email_address", "String", "emailAddress", "EmailAddress"));

        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
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
        String objectNameTable = "SP_DELIVERY_SITE";
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
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_agency", "String", "relatedAgency", "RelatedAgency"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("company_name", "String", "companyName", "CompanyName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("address", "String", "address", "Address"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("zip_code", "String", "zipCode", "ZipCode"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("city", "String", "city", "City"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("country", "String", "country", "Country"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("contact_name", "String", "contactName", "ContactName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("phone_number", "String", "phoneNumber", "PhoneNumber"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("email_address", "String", "emailAddress", "EmailAddress"));

        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);

        return objectDescriptor;
    }

    public static Map<String, Object> generateMapContacts(){
        Map<String, Object> objectDescriptor = new HashMap<String, Object>();

        List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("relatedAgencyId");
        elet.add("contactFirstName");
        elet.add("contactLastName");
        elet.add("email");
        elet.add("comment");


        String objectName = "spContacts";
        String objectNameUpper = "SpContacts";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "SP_CONTACTS";
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
        databaseElements.add(new JavaDatabaseObjectDescriptor("related_agency_id", "Integer", "relatedAgencyId", "RelatedAgencyId"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("contact_first_name", "String", "contactFirstName", "ContactFirstName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("contact_last_name", "String", "contactLastName", "ContactLastName"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("email", "String", "email", "Email"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("comment", "String", "comment", "Comment"));

        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);

        return objectDescriptor;
    }

    public static Map<String, Object> generateMapStocks(){
        Map<String, Object> objectDescriptor = new HashMap<String, Object>();

        List<String> elet = new ArrayList<String>();
        elet.add("id");
        elet.add("relatedDeliverySite");
        elet.add("materialType");
        elet.add("materialName");
        elet.add("materialId");
        elet.add("quantity");
        elet.add("deliveryDate");
        elet.add("comments");

        String objectName = "spStocks";
        String objectNameUpper = "SpStocks";
        String packageName = "com.michelin.solutions.newbiz";
        String objectNameTable = "SP_STOCKS";
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
        databaseElements.add(new JavaDatabaseObjectDescriptor("material_id", "String", "materialId", "MaterialId"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("quantity", "Integer", "quantity", "Quantity"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("delivery_date", "Date", "deliveryDate", "deliveryDate"));
        databaseElements.add(new JavaDatabaseObjectDescriptor("comments", "String", "comments", "Comments"));

        objectDescriptor.put("packageName", packageName);
        String packageCommonsName = "com.michelin.solutions.newbiz.commons.domain";
        objectDescriptor.put("packageCommonsName", packageCommonsName);
        objectDescriptor.put("listDatabaseElt", databaseElements);

        return objectDescriptor;
    }
}
