package br.com.edeploy.microservice.cidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("br.com.edeploy.microservice.cidade.interfaces.proxy")
@EnableDiscoveryClient
public class CidadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CidadeApplication.class, args);
    }
}
