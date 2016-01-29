package com.cgi.asset.config;

import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;

/**
 * Created by dumasbe on 28/01/2016.
 */
@Configuration
@ComponentScan
public class ApplicationConfigurator extends WebMvcConfigurerAdapter {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        //resolver.set
        //resolver.setContentType("text/html; charset=UTF-8");
        return resolver;
    }

    /*
    @Bean
    public FreeMarkerProperties freeMarkerProperties()  throws IOException, TemplateException {
        FreeMarkerProperties properties = new FreeMarkerProperties();
        properties.setTemplateLoaderPath("classpath:/template/","classpath:/src/main/resources/template","src/main/resources/template", "src/main/resources/template/angular");
        //properties.
        return properties;
    }*/



    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer()  throws IOException, TemplateException {
        FreeMarkerProperties properties = new FreeMarkerProperties();
        properties.setTemplateLoaderPath("classpath:/template/");
        //properties.

        String toto = applicationContext.getApplicationName();

        FreeMarkerConfigurationFactory factory = new FreeMarkerConfigurationFactory();
        factory.setTemplateLoaderPaths("classpath:/template/angular", "classpath:/template/javaJPA");
        factory.setDefaultEncoding("UTF-8");
       // factory.




        FreeMarkerConfigurer result = new FreeMarkerConfigurer();
        //result.setTemplateLoaderPath("src/main/resources/template");
        result.setConfiguration(factory.createConfiguration());
        //result.set
        //result.
        return result;
        //src\main\resources\template
    }

 /*   @Bean(name ="freemarkerConfig")
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/views/");
        Map<String, Object> map = new HashMap<>();
        map.put("xml_escape", new XmlEscape());
        configurer.setFreemarkerVariables(map);
        return configurer;
    }
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreUnknownPathExtensions(false).defaultContentType(MediaType.TEXT_HTML);
    }
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.freeMarker();
    }
*/
}