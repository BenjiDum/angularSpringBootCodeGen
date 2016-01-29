package com.cgi.asset.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dumasbe on 27/01/2016.
 */
@Service
public class TypeService {

    private final static String STRING = "String";

    private final static String BOOLEAN = "Boolean";

    private final static String FLOAT = "float";

    private final static String INTEGER = "Integer";

    public List<String> getAllSupportedTypes(){
        List<String> results = new ArrayList<String>();
        results.add(STRING);
        results.add(BOOLEAN);
        results.add(FLOAT);
        results.add(INTEGER);
        return results;
    }


}
