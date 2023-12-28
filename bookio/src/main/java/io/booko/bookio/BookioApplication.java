package io.booko.bookio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookioApplication.class, args);
	}


	@GetMapping("/root")
	public String apiRoot() {
		return "hello world";
	}
}
