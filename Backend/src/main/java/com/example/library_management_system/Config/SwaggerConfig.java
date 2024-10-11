package com.example.library_management_system.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
//import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Library Management API")
                        .version("1.0")
                        .description("API documentation for the library management system."));
    }

//    @Bean
//    public GroupedOpenApi publicApi(){
//        return GroupedOpenApi.builder()
//                .group("springshop-public")
//                .pathsToMatch("/**")
//                .build();
//    }
}
