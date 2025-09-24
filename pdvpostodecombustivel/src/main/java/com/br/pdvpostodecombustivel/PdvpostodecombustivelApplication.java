package com.br.pdvpostodecombustivel;
/*
import com.br.pdvpostocombustivel.api.pessoa.domain.entity.Pessoa;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdvpostocombustivelApplication {

	public static void main(String[] args) {
        //SpringApplication.run(PdvpostocombustivelApplication.class, args);

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNomeCompleto("Pedro");
        pessoa1.setCpfCnpj("24598645877");
        pessoa1.setNumeroCtps(1722L);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNomeCompleto("Jon");
        pessoa2.setCpfCnpj("45698612578");
        pessoa2.setNumeroCtps(2545L);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNomeCompleto("Marcos");
        pessoa3.setCpfCnpj("32674198266");
        pessoa2.setNumeroCtps(4687L);

        System.out.println("Nome Completo:" + pessoa1.getNomeCompleto());
        System.out.println("CPF/CNPJ:" + pessoa1.getCpfCnpj());
        System.out.println("Nuemro CTPs:" + pessoa1.getNumeroCtps());

        System.out.println("----------------------------------");

        System.out.println("Nome Completo:" + pessoa2.getNomeCompleto());
        System.out.println("CPF/CNPJ:" + pessoa2.getCpfCnpj());
        System.out.println("Nuemro CTPs:" + pessoa2.getNumeroCtps());

        System.out.println("----------------------------------");

        System.out.println("Nome Completo:" + pessoa3.getNomeCompleto());
        System.out.println("CPF/CNPJ:" + pessoa3.getCpfCnpj());
        System.out.println("Nuemro CTPs:" + pessoa3.getNumeroCtps());
    }

}
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// OpenAPI / Swagger
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "PDV Posto Combustível API",
                version = "v1",
                description = "API de exemplo com CRUD de Pessoas (Spring Boot 3 / Java 17).",
                contact = @Contact(name = "Prof. Esp. Ednilton Rauh", email = "ednilton@example.com"),
                license = @License(name = "MIT")
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Ambiente Local")
        }
)
public class PdvpostodecombustivelApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdvpostodecombustivelApplication.class, args);

        // Seu bloco de testes antigos pode ficar comentado aqui se quiser.
        // Como estamos usando Swagger, os testes podem ser feitos pela UI:
        // http://localhost:8080/swagger-ui.html
    }
}