package main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Client {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Client.class).web(true).run(args);
	}

	@GetMapping("/health")
	public String health() {
		return "health";
	}
}
