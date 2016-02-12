package com.cgi.asset.generationModel.template;



public enum FrontendTemplate {
    //Objets directement construits

    Newbiz("Template Angular Newbiz", "newbiz.front."),
    EMC2 ("Template Angular EMC2", "emc2.front."),
    ANGULAR ("Template Angular natif", "angular.front.");

    private String name = "";
    private String templateFilePrefix = "";

    //Constructeur
    FrontendTemplate(String name, String templateFilePrefix){
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

