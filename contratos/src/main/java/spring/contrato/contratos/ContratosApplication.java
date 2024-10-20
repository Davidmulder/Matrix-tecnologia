package spring.contrato.contratos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "spring.contrato.contratos.repositorio")
public class ContratosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContratosApplication.class, args);
	}

}
