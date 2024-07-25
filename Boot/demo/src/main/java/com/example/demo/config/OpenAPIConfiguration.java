package com.example.demo.config;

import io.swagger.v3.oas.annotations.Parameter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class OpenAPIConfiguration {

    private static final String API_NAME = "Programmers Spring Boot Application";
    private static final String API_VERSION = "1.0.0";
    private static final String API_DESCRIPTION = "프로그래머스 스프링 부트 애플리케이션입니다.";

    // 접속 경로 : http://localhost:8080/swagger-ui/
    @Bean
    public Docket api() {
        Parameter parameter = (Parameter) new ParameterBuilder()
            .name(HttpHeaders.AUTHORIZATION)
            .description("Access Tocken")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(false)
            .build();

        List<Parameter> globalParameters = new ArrayList<>();
        globalParameters.add(parameter);

        return new Docket(DocumentationType.SWAGGER_2)
                // .globalOperationParameters(globalParameters)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_NAME)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .build();
    }
}
