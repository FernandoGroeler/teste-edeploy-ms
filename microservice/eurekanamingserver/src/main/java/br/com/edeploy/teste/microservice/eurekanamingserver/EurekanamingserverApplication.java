package br.com.edeploy.teste.microservice.eurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekanamingserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekanamingserverApplication.class, args);
    }
}
