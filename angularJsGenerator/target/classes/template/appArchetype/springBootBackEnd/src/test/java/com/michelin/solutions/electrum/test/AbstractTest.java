package com.michelin.solutions.electrum.test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Created by <a href="https://github.com/rnicob">Nicolas Roux</a> - <a href="http://www.agaetis.fr">Agaetis</a>  on 12/03/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public abstract class AbstractTest {

    @Configuration
    @ComponentScan(basePackages = {"com.agaetis.spring.jdbc.lightorm","com.michelin.solutions.electrum"})
    static class Config {

        @Bean
        public static PropertySourcesPlaceholderConfigurer properties() throws Exception {
            final PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
            pspc.setLocation(new ClassPathResource("/test.properties"));
            return pspc;
        }
    }

    @Configuration
    class DatasourceConfig {

        @Value("${spring.datasource.url}")
        private String url;

        @Value("${spring.datasource.url}")
        private String login;

        @Value("${spring.datasource.url}")
        private String password;

        @Value("${spring.datasource.driver-class-name}")
        private String driverClassName;

        @Bean
        public DataSource dataSource() throws ClassNotFoundException {
            Class.forName(driverClassName);
            SQLServerDataSource dataSource = new SQLServerDataSource();
            dataSource.setURL(url);
            dataSource.setUser(login);
            dataSource.setPassword(password);
            return dataSource;
        }
    }

}
