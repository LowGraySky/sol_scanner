package web3.solana.scan.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableWebFlux
@ConfigurationPropertiesScan
public class ApplicationConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .build();
    }
}