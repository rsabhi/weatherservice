package com.weatherservice.weatherservice.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Weather {
    public @Id @GeneratedValue Long id;
    public String cityName;
    public String temperature;
 
    public Weather() {}

    public Weather(String cityName, String temperature) {
        this.cityName = cityName;
        this.temperature = temperature;
     }
}
