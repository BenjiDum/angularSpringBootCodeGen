package com.cgi.asset.generationModel.template;



public enum DatabaseTemplate {
    //Objets directement construits

    LIQUIBASE ("Template Liquibase", "liquibase.");

    private String name = "";
    private String templateFilePrefix = "";

    //Constructeur
    DatabaseTemplate(String name, String templateFilePrefix){
        this.name = name;
        this.templateFilePrefix = templateFilePrefix;
    }

    public String getTemplateFilePrefix(){
        return templateFilePrefix;
    }

    public String toString(){
        return name;
    }

}

