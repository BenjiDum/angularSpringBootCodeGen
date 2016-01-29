package com.cgi.asset.objectModelorEntity;

import java.util.List;

/**
 * Created by dumasbe on 27/01/2016.
 */
public class ObjectAnnotation {

    String name;

    List<ObjectAnnotationParam> parameters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ObjectAnnotationParam> getParameters() {
        return parameters;
    }

    public void setParameters(List<ObjectAnnotationParam> parameters) {
        this.parameters = parameters;
    }
}
