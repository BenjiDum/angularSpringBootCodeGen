package com.cgi.asset.objectModelorEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Map;

/**
 * Created by dumasbe on 27/01/2016.
 */
public class ObjectDescriptor {

    String name;

    String packageName;

    boolean audited;

    boolean liquibasePart;

    boolean javaPart;

    boolean angularController;

    boolean springBootPart;

    String angularModuleName;

    List<ObjectAttribute> attributes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public boolean isAudited() {
        return audited;
    }

    public void setAudited(boolean audited) {
        this.audited = audited;
    }

    public String getAngularModuleName() {
        return angularModuleName;
    }

    public void setAngularModuleName(String angularModuleName) {
        this.angularModuleName = angularModuleName;
    }

    public List<ObjectAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ObjectAttribute> attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> convertForFreemarker(){
        return null;
    }

    @JsonIgnore
    public String getUpperCaseName(){
        return getName().toUpperCase();
    }

    @JsonIgnore
    public String getLowerCaseName(){
        return getName().toLowerCase();
    }

    public boolean isLiquibasePart() {
        return liquibasePart;
    }

    public void setLiquibasePart(boolean liquibasePart) {
        this.liquibasePart = liquibasePart;
    }

    public boolean isJavaPart() {
        return javaPart;
    }

    public void setJavaPart(boolean javaPart) {
        this.javaPart = javaPart;
    }

    public boolean isAngularController() {
        return angularController;
    }

    public void setAngularController(boolean angularController) {
        this.angularController = angularController;
    }

    public boolean isSpringBootPart() {
        return springBootPart;
    }

    public void setSpringBootPart(boolean springBootPart) {
        this.springBootPart = springBootPart;
    }

    @JsonIgnore
    public String getIdField(){
        for(ObjectAttribute attr : getAttributes()){
            for(ObjectAnnotation annot : attr.getAnnotations()){
                if (annot.getName().equalsIgnoreCase("id")){
                    return annot.getName();
                }
            }

        }
        return "UNKNOWN";
    }
}
