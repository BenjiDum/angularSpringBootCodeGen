package com.cgi.asset;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;



@SpringBootApplication
public class GeneratorApplication {

    private static final Logger logger = LoggerFactory.getLogger(GeneratorApplication.class);

    private static final String TEMPLATE_FOLDER_LOCATION_PROP_NAME = "templateFolderLocation";


    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream input = null;

        String configFileName = "config/config.properties";

        //input = new FileInputStream("config.properties");
        input = GeneratorApplication.class.getClassLoader().getResourceAsStream(configFileName);

        if (input == null){
            logger.error("Unable to find file : "+configFileName);
        }
        else
        {
            // load a properties file
            try {
                prop.load(input);
                /* ------------------------------------------------------------------------ */
                /* You should do this ONLY ONCE in the whole application life-cycle:        */

                /* Create and adjust the configuration singleton */
                Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
                //cfg.setDirectoryForTemplateLoading(new File("./../../../../resources/template"));
                //cfg.setDirectoryForTemplateLoading(new File("C:\\Work\\MichelinSolutions\\Templating\\workspace\\angularJsGenerator\\src\\main\\resources\\template"));
                cfg.setDirectoryForTemplateLoading(new File(prop.getProperty(TEMPLATE_FOLDER_LOCATION_PROP_NAME)));
                cfg.setDefaultEncoding("UTF-8");
                cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);


                            /* ------------------------------------------------------------------------ */
                /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

    //	        AppDbReader dbReader = new AppDbReader(prop);
    //
    //	        dbReader.analyseDatabase();

                //AppGeneratorCore.generateApplication(prop, cfg);


            }catch (java.io.IOException ioException){
                logger.error("Unable to load properties file : "+configFileName);
            }



            SpringApplication.run(GeneratorApplication.class, args);
        }


    }
}



