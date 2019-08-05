package com.weatherservice.weatherservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Weather {

    private @Id
    @GeneratedValue
    Long id;
    private String cityName;
    private String temperature;

    public Weather() {
    }

    public Weather(String cityName, String temperature) {
        this.cityName = cityName;
        this.temperature = temperature;
    }
}
