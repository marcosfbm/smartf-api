package br.com.intechsistemas.autenticador.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI openAPI(){
    return new OpenAPI()
    .info(new Info().title("ICommerce").description("API da Intech para o projeto ICommerce").version("1.0"))
    .schemaRequirement("jwt_auth", creaSecurityScheme());
    // se trocar o schemaRequirement por estas duas comentadas, todas as rotas a api vao precisar de auteticacao automaticamente
    //.addSecurityItem(new SecurityRequirement().addList("Bearer Authtication"))
    //.components(new Components().addSecuritySchemes("Bearer Authtication", creaSecurityScheme()));
  }

  private SecurityScheme creaSecurityScheme() {
    return new SecurityScheme().name("jwt_auth").scheme("bearer").bearerFormat("JWT").type(SecurityScheme.Type.HTTP).in(SecurityScheme.In.HEADER);
  }
}
