package com.cgi.asset.controller;

import com.cgi.asset.objectModelorEntity.ObjectDescriptor;
import com.cgi.asset.services.GenerateCodeService;
import com.cgi.asset.services.TypeService;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by dumasbe on 27/01/2016.
 */
@RestController
@RequestMapping(value="/generatorApi")
public class GeneratorController {

    private static final Logger logger = LoggerFactory.getLogger(GeneratorController.class);

    @Autowired
    private TypeService typeServices;

    @Autowired
    private GenerateCodeService generateCodeService;



    /*@RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }*/

    @RequestMapping(value="/supportedTypes", method= RequestMethod.GET, produces = "application/json")
    @Produces("application/json")
    public List<String> getSupportedAttributesTypes(){
        return typeServices.getAllSupportedTypes();
    }

  /*  @RequestMapping(value="/greeting", method= RequestMethod.GET)
    public String greetingForm() {
        return "greeting";
    }
*/

    @RequestMapping(value="/generateLocal", method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody ObjectDescriptor input) {

        logger.info(input.getAngularModuleName());

        HttpHeaders httpHeaders = new HttpHeaders();

        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);

    }


    @RequestMapping(value = "/generateInZip", method = RequestMethod.POST)
    @Produces("application/zip")
    public void generateZipFileForSelectedFile(@RequestBody ObjectDescriptor input, HttpServletResponse response) {
        logger.info("Zip generator controller");

        generateCodeService.persistObjectInDatabase(input);

        try {
            File masterFile = generateCodeService.buildZipFromObject(input);

            response.setContentType("text/csv;charset=" + StandardCharsets.UTF_8.name());
            response.setHeader("Content-Disposition", "attachment; filename="
                    + "fileFull.zip");
            //response.setContentLength(csv.length);
            IOUtils.copy(new FileInputStream(masterFile), response.getOutputStream());
            response.flushBuffer();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
