import React from 'react';

const SingleWeather = ({item}) => (
    <div className="row">
    <div className="col s12 m6">
      <div className="card blue-grey darken-1">
        <div className="card-content white-text">
          <span className="card-title">{item.cityName} {item.temperature}</span>
        </div>
      </div>
    </div>
  </div>
);

export default SingleWeather;