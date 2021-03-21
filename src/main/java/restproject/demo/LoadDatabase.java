package restproject.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import restproject.demo.product.Product;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository){
        return args -> {
            repository.save(new Product("apple", 45, "kg"));
            repository.save(new Product("banana", 60, "kg"));
            repository.save(new Product("milk", 40,     "litres"));
            repository.save(new Product("juice", 90, "litres"));

        };
    }
}
