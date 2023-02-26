package si.exampleapi.demo;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import si.exampleapi.client.DataSource;

@Configuration
@EnableCaching
@EnableScheduling
public class AppConfiguration {
    @Bean
    public DataSource getDataSourceBean() {
        return new DataSource();
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("sports", "tournaments");
    }
}
