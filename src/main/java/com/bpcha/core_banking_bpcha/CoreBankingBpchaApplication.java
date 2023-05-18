package com.bpcha.core_banking_bpcha;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@OpenAPIDefinition(info = @Info(title = "Swagger Core Banking Pcha", version = "1.0", description = "Documentation APIs v1.0"))
public class CoreBankingBpchaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreBankingBpchaApplication.class, args);
    }

}
