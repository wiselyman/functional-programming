package top.wisely.functionalprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class FunctionalProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionalProgrammingApplication.class, args);
	}

	@Bean
	CommandLineRunner testLambdas(){
		return p -> {
			log.info(DemoLambdas.computeOne(a -> -a, 5).toString());
			log.info(DemoLambdas.computeOne(a -> a - 1, 5).toString());
			log.info(DemoLambdas.computeTwo((a, b) -> a + b,10,5).toString());
			log.info(DemoLambdas.computeTwo((a, b) -> { Integer c = a - b;
														return c + a + b; } ,10,5).toString());
		};
	}
}

