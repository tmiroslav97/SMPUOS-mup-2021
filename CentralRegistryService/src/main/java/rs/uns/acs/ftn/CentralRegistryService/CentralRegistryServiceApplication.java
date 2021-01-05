package rs.uns.acs.ftn.CentralRegistryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CentralRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralRegistryServiceApplication.class, args);
	}

}
