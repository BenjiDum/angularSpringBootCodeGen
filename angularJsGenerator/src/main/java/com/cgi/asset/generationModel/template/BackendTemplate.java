package com.cgi.asset.generationModel.template;



public enum BackendTemplate {
    //Objets directement construits

    Newbiz("Template SpringBoot / lightORM newbiz", "newbiz."),
    EMC2 ("Template SpringBoot / JPA EMC2", "emc2."),
    JPA ("Template JPA natif", "jpa.");

    private String name = "";
    private String templateFilePrefix = "";

    //Constructeur
    BackendTemplate(String name, String templateFilePrefix){
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

