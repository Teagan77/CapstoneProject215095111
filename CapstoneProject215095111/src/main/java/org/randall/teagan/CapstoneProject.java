package org.randall.teagan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"org.randall.teagan.Controllers",
                               "org.randall.teagan.Services.ServiceImplementation",
                               "org.randall.teagan.Repositories.Implementation"})
public class CapstoneProject {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(CapstoneProject.class, args);
    }
}
