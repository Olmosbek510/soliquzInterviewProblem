package uz.soliq.feignclientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaServer
@EnableFeignClients
public class FeignClientServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignClientServiceApplication.class, args);
    }

}
