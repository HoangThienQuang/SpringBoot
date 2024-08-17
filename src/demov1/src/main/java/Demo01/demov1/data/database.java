package Demo01.demov1.data;

import Demo01.demov1.Models.Product;
import Demo01.demov1.Repositories.productRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class database {
    private static final Logger logger = LoggerFactory.getLogger(database.class);
    @Bean
    CommandLineRunner initDatabase(productRepo productRepository)
    {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product("Mac01",1000.0,2024,"");
                Product productB = new Product("IPod01",10.0,2023,"");
                logger.info("Successful insert data" + productRepository.save(productA));
                logger.info("Successful insert data" + productRepository.save(productB));
            }
        };
    }
}
