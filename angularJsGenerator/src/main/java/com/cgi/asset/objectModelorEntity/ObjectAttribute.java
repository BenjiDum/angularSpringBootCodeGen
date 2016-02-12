package com.cgi.asset.objectModelorEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * Created by dumasbe on 27/01/2016.
 */
public class ObjectAttribute {

    String name;

    String type;

    boolean listObject;

    boolean tabView;

    boolean previewView;

    boolean editView;

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

    public boolean isListObject() {
        return listObject;
    }

    public void setListObject(boolean listObject) {
        listObject = listObject;
    }

    public boolean isTabView() {
        return tabView;
    }

    public void setTabView(boolean tabView) {
        this.tabView = tabView;
    }

    public boolean isPreviewView() {
        return previewView;
    }

    public void setPreviewView(boolean previewView) {
        this.previewView = previewView;
    }

    public boolean isEditView() {
        return editView;
    }

    public void setEditView(boolean editView) {
        this.editView = editView;
    }

    public List<ObjectAnnotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<ObjectAnnotation> annotations) {
        this.annotations = annotations;
    }

    @JsonIgnore
    public String getUpperLetterName(){
        return (name.substring(0,1)).toUpperCase()+name.substring(1);
    }
}
