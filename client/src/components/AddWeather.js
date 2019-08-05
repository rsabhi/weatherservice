import React, { Component } from 'react';

export default class AddWeather extends Component {
    submitWeather(event) {
        event.preventDefault();

        let weather = {
            cityName: this.refs.cityName.value,
            temperature: this.refs.temperature.value,
        }
        fetch("http://localhost:8080/api/weather", {
            method: "POST",
            headers: {
                "content-type": "application/json",
            },
            body: JSON.stringify(weather),
        })
        .then(response => response.json());

        window.location.reload();
    }

}