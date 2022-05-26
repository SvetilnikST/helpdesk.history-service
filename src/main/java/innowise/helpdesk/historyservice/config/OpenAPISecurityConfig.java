package innowise.helpdesk.historyservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuth2SchemeBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@PropertySource("classpath:application.yml")
public class OpenAPISecurityConfig {

    @Value("${keycloak.auth-server-url}")
    String authServerUrl;

    @Value("${keycloak.realm}")
    String realm;

    @Value("${keycloak.resource}")
    private String clientId;

    @Value("${keycloak.credentials.secret}")
    private String clientSecret;

    void addSecurity(Docket docket) {
        docket
                .securitySchemes(Collections.singletonList(authenticationScheme()))
                .securityContexts(Collections.singletonList(securityContext()));
    }

    private SecurityScheme authenticationScheme() {
        return new OAuth2SchemeBuilder("implicit")
                .name("histories_oAuth_security_schema")
                .authorizationUrl(authServerUrl + "/realms/" + realm)
                .scopes(authorizationScopes())
                .build();
    }

    private List<AuthorizationScope> authorizationScopes() {
        return Arrays.asList(
                new AuthorizationScope("read_access", "read data"),
                new AuthorizationScope("write_access", "modify data")
        );
    }

    private SecurityContext securityContext() {
        return SecurityContext.
                builder().
                securityReferences(readAccessAuth())
                .operationSelector(operationContext -> HttpMethod.GET.equals(operationContext.httpMethod()))
                .build();
    }

    private List<SecurityReference> readAccessAuth() {
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[] { authorizationScopes().get(0) };
        return Collections.singletonList(
                new SecurityReference("histories_oAuth_security_schema", authorizationScopes)
        );
    }

    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .realm(realm)
                .appName(clientId)
                .scopeSeparator(",")
                .additionalQueryStringParams(null)
                .useBasicAuthenticationWithAccessCodeGrant(false)
                .build();
    }

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
                .version("1.0").build();
    }
}