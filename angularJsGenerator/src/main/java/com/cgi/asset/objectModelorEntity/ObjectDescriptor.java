package com.cgi.asset.objectModelorEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by dumasbe on 27/01/2016.
 */
public class ObjectDescriptor {

    String name;

    String packageName;

    boolean isAudited;

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
        return isAudited;
    }

    public void setAudited(boolean audited) {
        isAudited = audited;
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
}
