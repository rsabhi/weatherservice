import React, { Component } from 'react';


export default class Weather extends Component {
    constructor(props) {
        super(props);
        this.state = {
            weather: [],
        };
    }

    componentDidMount() {
        fetch('http://localhost:8080/temperature/city')
                .then(response => response.json())
                .then(data => this.setState({weather: data}))
    }

    render() {
        return (
                <div>
                    <table>
                        <thead>
                            <tr>
                                <th>City Name</th>
                                <th>Temperature</th>
                            </tr>
                        </thead><tbody>
                            {
                                this.state.weather.map((item) => (
                                        <tr>
                                            <td>{item.cityName}</td>
                                            <td>{item.temperature}°C</td>
                                        </tr>
                                            ))}
                        </tbody>
                    </table>
                </div>
                )
    }
}
