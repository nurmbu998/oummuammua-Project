package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OumuamuaObservationRepository repository;

    public DataInitializer(OumuamuaObservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.save(new OumuamuaObservation(LocalDate.of(2017, 10, 19), "Oumuamua discovered by Pan-STARRS."));
            repository.save(new OumuamuaObservation(LocalDate.of(2017, 11, 1), "Non-gravitational acceleration detected."));
        }
    }
}
