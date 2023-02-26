package si.exampleapi.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import si.exampleapi.client.DataSource;

@Configuration
public class AppConfiguration {
    @Bean
	public DataSource getDataSourceBean() {
		return new DataSource();
	}
}
