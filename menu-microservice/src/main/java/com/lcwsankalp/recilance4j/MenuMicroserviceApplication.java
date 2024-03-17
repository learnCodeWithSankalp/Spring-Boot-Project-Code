package com.lcwsankalp.recilance4j;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lcwsankalp.recilance4j.model.Menu;
import com.lcwsankalp.recilance4j.repository.MenuRepository;

@SpringBootApplication
public class MenuMicroserviceApplication {

	@Autowired
	MenuRepository menuRepository;

	@PostConstruct
	public void initMenuTable() {
		menuRepository.saveAll(Stream.of(new Menu(1, "Panner Tikka masala", "indian", 320.50),
				new Menu(2, "Dal Fry", "indian", 120.50), new Menu(3, "Akka masur", "indian", 150.50),
				new Menu(4, "Egg fryed rice", "Chinese", 120.50), new Menu(5, "Chikan Lolli pop", "Chinese", 180.50),
				new Menu(6, "Hakka noodles", "Chinese", 220.50), new Menu(1, "Masala Dosa", "South indian", 50.50),
				new Menu(1, "Idli", "South indian", 10.50), new Menu(1, "Medu vada", "South indian", 60.00))
				.collect(Collectors.toList()));

	}

	public static void main(String[] args) {
		SpringApplication.run(MenuMicroserviceApplication.class, args);
	}

}
