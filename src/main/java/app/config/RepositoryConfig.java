package app.config;

import app.core.repository.DatabaseItemsRepository;
import app.core.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;

/**
 * Created by User on 26.02.2018.
 */
@Configuration
public class RepositoryConfig {

    @Bean
    public ItemsRepository itemsRepository(@Qualifier("itemsJdbcOperations")JdbcOperations jdbcOperations) {
        return new DatabaseItemsRepository(jdbcOperations);
    }
}