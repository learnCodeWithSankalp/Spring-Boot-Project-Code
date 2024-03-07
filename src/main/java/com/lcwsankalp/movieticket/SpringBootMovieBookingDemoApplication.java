package com.lcwsankalp.movieticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement 
public class SpringBootMovieBookingDemoApplication { 

	public static void main(String[] args) { 
		SpringApplication.run(SpringBootMovieBookingDemoApplication.class, args);
	}

}
