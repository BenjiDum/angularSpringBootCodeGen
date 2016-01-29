package com.cgi.asset.objectModelorEntity;

import java.util.List;

/**
 * Created by dumasbe on 27/01/2016.
 */
public class ObjectAttribute {

    String name;

    String type;

    boolean isList;

    List<ObjectAnnotation> annotations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isList() {
        return isList;
    }

    public void setList(boolean list) {
        isList = list;
    }

    public List<ObjectAnnotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<ObjectAnnotation> annotations) {
        this.annotations = annotations;
    }
}
