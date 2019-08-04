package com.weatherservice.weatherservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoLoader implements CommandLineRunner {

    private final WeatherRepository repository;

    @Autowired
    public DemoLoader(WeatherRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Weather("Melbourne", "15"));
    }
}
