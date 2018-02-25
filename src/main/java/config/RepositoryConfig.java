package config;

import core.repository.ItemsRepository;
import core.repository.SampleItemsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by User on 26.02.2018.
 */
@Configuration
public class RepositoryConfig {

    @Bean
    public ItemsRepository itemsRepository() {
        return new SampleItemsRepository();
    }
}