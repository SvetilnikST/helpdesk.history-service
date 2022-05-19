package innowise.helpdesk.historyservice.config;

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
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo()).select().build()
                .select()
                .apis(RequestHandlerSelectors.basePackage("innowise.helpdesk.historyservice")).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("History-Service")
                .description("")
                .contact(new Contact("Sviatlana Shishaeva", "https://innowise.by/", "sviatlana.shyshayeva@innowise-group.com"))
                .version("1.0").build();
    }

}