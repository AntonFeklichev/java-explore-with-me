package ru.practicum.ewm.main.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.practicum.ewm.main.server.event.repository.CustomEventRepositoryImpl;

@SpringBootApplication
@ComponentScan(
        basePackageClasses = {
                ru.practicum.ewm.main.server.ExploreWithMeMainServerApplication.class,
                ru.practicum.ewm.stats.client.endpointhit.EndPointHitClient.class
        }
)
@EnableJpaRepositories(repositoryBaseClass = CustomEventRepositoryImpl.class)
public class ExploreWithMeMainServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExploreWithMeMainServerApplication.class, args);
    }
}
