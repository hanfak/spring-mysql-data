package versionthree;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseDataProviderConfiguration {

    @Bean
    public UserDatabaseDataProvider userDatabaseDataProvider(JdbcTemplate jdbcTemplate) {
        return new UserDatabaseDataProvider(jdbcTemplate);
    }
}
