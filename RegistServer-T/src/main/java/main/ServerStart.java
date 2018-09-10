package main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerStart {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ServerStart.class).web(true).run(args);
	}
}
