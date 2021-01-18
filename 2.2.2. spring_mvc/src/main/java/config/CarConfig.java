package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.ServiceCar;

@Configuration
@ComponentScan("java")
public class CarConfig {
    @Bean
    public ServiceCar serviceCar() {
        return new ServiceCar();
    }


}
