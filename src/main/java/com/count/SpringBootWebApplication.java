package com.count;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2

public class SpringBootWebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }


    @Bean
    public Docket SwaggerConfiguration(){
        //Return a prepared Docket object.
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.count"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Word Count Api",
                "Sample API for finding the word count using SpringBoot and Singleton Design Pattern ",
                "1.0",
                "Free",
                new springfox.documentation.service.Contact("Harish", "http://test.springbootapplication.com", "abc@yahoo.co.in"),
                "API License",
                "http://test.springbootapplication.com",
                Collections.emptyList());
    }
}