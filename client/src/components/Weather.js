import React, { Component } from 'react';
import SingleWeather from './SingleWeather';
import AddWeather from './AddWeather';

export default class Weather extends Component {
    constructor(props) {
        super(props);
        this.state = {
            weather: [],
        };
    }

    componentDidMount() {
        fetch('http://localhost:8080/api/weather')
        .then(response => response.json())
        .then(data => this.setState({weather: data}))
    }

    render() {
        return (
            <div>
                <div className="row">
                    { this.state.weather.map((item) => (
                        <SingleWeather key={item.id} item={item} />
                    ))}
                </div>
            </div>
        )
    }
}
