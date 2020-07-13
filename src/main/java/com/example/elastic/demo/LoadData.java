package com.example.elastic.demo;

import com.example.elastic.demo.indices.BodyStyle;
import com.example.elastic.demo.indices.Car;
import com.example.elastic.demo.repo.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

import static java.util.Arrays.asList;

@Configuration
@Slf4j
public class LoadData {
    @Bean
    public CommandLineRunner initElasticsearchData(CarRepository carRepository) {
        return args -> {
            carRepository.deleteAll();
            log.info("Pre loading " + carRepository.save(new Car("holden", "commodore", asList(new BodyStyle("2-door"), new BodyStyle("4-door"), new BodyStyle("5-door")))));
            log.info("Pre loading " + carRepository.save(new Car("holden", "astra", asList(new BodyStyle("2-door"), new BodyStyle("4-door")))));
            log.info("Pre loading " + carRepository.save(new Car("nissan", "skyline", asList(new BodyStyle("4-door")))));
            log.info("Pre loading " + carRepository.save(new Car("nissan", "pathfinder", asList(new BodyStyle("5-door")))));
            log.info("Pre loading " + carRepository.save(new Car("ford", "falcon", asList(new BodyStyle("4-door"), new BodyStyle("5-door")))));
            log.info("Pre loading " + carRepository.save(new Car("ford", "territory", asList(new BodyStyle("5-door")))));
            log.info("Pre loading " + carRepository.save(new Car("toyota", "camry", asList(new BodyStyle("4-door"), new BodyStyle("5-door")))));
            log.info("Pre loading " + carRepository.save(new Car("toyota", "corolla", asList(new BodyStyle("2-door"), new BodyStyle("5-door")))));
            log.info("Pre loading " + carRepository.save(new Car("kia", "sorento", asList(new BodyStyle("5-door")))));
            log.info("Pre loading " + carRepository.save(new Car("kia", "sportage", asList(new BodyStyle("4-door")))));
        };
    }
}
