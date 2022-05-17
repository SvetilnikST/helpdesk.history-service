package innowise.zuevsky.helpdesk.historyservice.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@EnableOpenApi
@Configuration
public class SwaggerUIConfig {

    Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo()).select().build()
                .select()
                .apis(RequestHandlerSelectors.basePackage("innowise.zuevsky.helpdesk.histotyservice")).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("HelpDesk")
                .description("")
                .contact(new Contact("Aliaksei Zuyeuski", "https://innowise.by/", "aliaksei.zuyeuski@innowise-group.com"))
                .version("1.0").build();
    }

}