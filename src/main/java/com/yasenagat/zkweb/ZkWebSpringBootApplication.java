package com.yasenagat.zkweb;
/**
 * 
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Shandy
 *
 */
@SpringBootApplication
@ComponentScan
@ServletComponentScan
public class ZkWebSpringBootApplication extends SpringBootServletInitializer {
    private final static Logger logger                  = LoggerFactory
        .getLogger(ZkWebSpringBootApplication.class);
    public final static String  applicationYamlFileName = "application-zkweb.yaml";
    
    public static void main(String[] args) {
        String file = ZkWebSpringBootApplication.class.getClassLoader()
            .getResource(applicationYamlFileName).getFile();
        logger.info("applicationYamlFileName({})={}", applicationYamlFileName, file);
        new SpringApplicationBuilder(ZkWebSpringBootApplication.class)
            .properties("spring.config.location=classpath:/" + applicationYamlFileName).run(args);
    }
}
