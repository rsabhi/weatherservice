package com.weatherservice.weatherservice.model;

import java.net.URISyntaxException;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temperature")
@CrossOrigin(origins = "http://localhost:3000")
class WeatherController {

    private WeatherRepository weatherRepository;

    public WeatherController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @GetMapping("/city")
    Collection<Weather> weather() {
        return (Collection<Weather>) weatherRepository.findAll();
    }

    @PostMapping("/city")
    ResponseEntity<Weather> createWeather(@Valid @RequestBody Weather weather) throws URISyntaxException {
        Weather result = weatherRepository.save(weather);
        return ResponseEntity.ok().body(result);
    }
}
