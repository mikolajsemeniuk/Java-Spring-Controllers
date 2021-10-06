package application.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProgramApplication {
	// http://localhost:8080/v2/api-docs/
	// http://localhost:8080/swagger-ui.html
	// remember to use 2.9.2 version instead of 3.0.0
	public static void main(String[] args) {
		SpringApplication.run(ProgramApplication.class, args);
	}

}
