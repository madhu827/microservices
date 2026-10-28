package com.example.micro;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class MicroApplication {

	@Autowired
	private RestTemplate restTemplate;

   @CircuitBreaker(name=" ",fallbackMethod = "demomethod")
   @GetMapping("/print")
	public String print(){
		 String result1=restTemplate.getForObject("http://localhost:8082/show",String.class);
		 String result2=restTemplate.getForObject("http://localhost:8081/employee",String.class);
		 return result1+" "+result2;
	}

	public static void main(String[] args) {

		SpringApplication.run(MicroApplication.class, args);





	}
	@Bean
	public RestTemplate getrestTemplate(){
		return new RestTemplate();
	}

	public String demomethod(Throwable ex){
	   return "service is unavailable";
	}





}
