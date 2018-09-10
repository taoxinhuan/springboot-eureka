package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient

public class Consumer {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Consumer.class).web(true).run(args);
	}

	@Bean
	@LoadBalanced
	RestTemplate rest() {
		return new RestTemplate();
	}



	@RestController
	class HelloController {

		@Autowired
		private RestTemplate restTemplate;

		@GetMapping("/hello")
		public String health() {

			return restTemplate.getForEntity("http://taoxinhuan-client/health", String.class).getBody();
		}
	}
}
