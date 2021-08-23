package com.sun.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    //配置swagger2核心配置 docker
    public Docket createRestApi(){

        return new Docket(DocumentationType.SWAGGER_2) //指定api类型为swagger2
        .apiInfo(apiInfo())                                     //用于定义api文档汇总信息
        .select().apis(RequestHandlerSelectors.basePackage("com.sun.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(){

        return new ApiInfoBuilder()
                .title("电商平台接口api") //标题
                .contact(new Contact("sun","","abc@qq.com"))
                .description("swagger2文档")
                .version("")   //版本
                .termsOfServiceUrl("https://www.sun.com")
                .build();
    }
}
