package top.wisely.functionalprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

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

	@Bean
	CommandLineRunner testOptional(){
		return p -> {
			Person person = new Person();

			Optional<String> firstName = person.getFirstName();
			firstName.ifPresent(name -> {
											String firstNameGreetings = firstName.get().toUpperCase();
											log.info("hello " + firstNameGreetings);
			   						      });


			Optional<String> middleName = person.getMiddleName();
			String middleNameGreetings = middleName
					.map(name ->  name.toUpperCase())
					.orElse("no middle name");
			log.info("hello " + middleNameGreetings);


			Optional<String> lastName = person.getLastName();
			String lastNameGreetings = lastName
											.map(name ->  name.toUpperCase())
											.orElse("no last name");
			log.info("hello " + lastNameGreetings);



		};
	}
}

