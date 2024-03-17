package com.lcwsankalp.recilance4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@SpringBootApplication
@RestController
@RequestMapping("/customerService")
public class CustomerMicroserviceApplication {
	
	@Autowired
	@Lazy
	RestTemplate restemplate;
	
	public static final String customer_service="customerService";
	
	private static final String Base_URL="http://localhost:8080/menu";
	
	
	@GetMapping("/displayMenu")
	@CircuitBreaker(name=customer_service,fallbackMethod="TempData")
	@Retry(name=customer_service,fallbackMethod = "TempData")
	public List<MenuDto> displayMenu(@RequestParam("category") String category){
		String url= category == null ? Base_URL : Base_URL+"/"+ category;
		return restemplate.getForObject(url, ArrayList.class);
	}
	
	
	public List<MenuDto> TempData(Exception e) {
		return Stream.of(new MenuDto(1, "Dal rice", "indian", 320.50),
				new MenuDto(3, "Chapati", "indian", 150.50),
				new MenuDto(5, "Veg Thali", "Chinese", 180.50))
				.collect(Collectors.toList());

	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerMicroserviceApplication.class, args);
	}
	
	  @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }

}
