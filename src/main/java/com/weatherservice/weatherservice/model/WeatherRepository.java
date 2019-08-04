package com.weatherservice.weatherservice.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WeatherRepository extends CrudRepository<Weather, Long> {

}
