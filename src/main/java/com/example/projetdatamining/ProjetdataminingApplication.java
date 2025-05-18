package com.example.projetdatamining;

import com.example.projetdatamining.service.distance.Levenshtein;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetdataminingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetdataminingApplication.class, args);

		System.out.println(Levenshtein.compute("chat", "chats")); // Devrait afficher 1
		System.out.println(Levenshtein.compute("chien", "chine")); // Devrait afficher 2
	}

}
