package com.ay.kg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        //扫描控制器中 Swagger2 的注解, .apis 里面的参数表示指定包
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) .select()
                .apis(RequestHandlerSelectors.basePackage("com.ay.kg.controller"))
                .paths(PathSelectors.any()) .build();
    }
    //API 描述信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot 利用 swagger 构建 Neo4j api 文档")
                .description("简单优雅的 restfun 风格")
                .termsOfServiceUrl("http://blog.csdn.net/saytime")
                .version("1.0") .build();
    }
}