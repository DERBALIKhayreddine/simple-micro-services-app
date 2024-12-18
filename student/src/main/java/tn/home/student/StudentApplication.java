package tn.home.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
/*
* Try with @EnableDiscoveryClient instead of @EnableEurekaClient.
* However @EnableEurekaClient annotation is not required anymore.
* Simply adding spring-cloud-starter-netflix-eureka-client to dependencies will enable the client.
*  https://github.com/spring-cloud/spring-cloud-netflix/issues/4022#issuecomment-915991198
* */