package si.exampleapi.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import si.exampleapi.client.DataSource;

@Configuration
public class AppConfiguration {
    @Bean
    public DataSource getDataSourceBean() {
        return new DataSource();
    }
}
