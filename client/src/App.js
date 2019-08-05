import React from 'react';
import Weather from './components/Weather';
import './App.css';

function App() {
  return (
    <div className="container-fluid">
      <nav>
        <div className="nav-wrapper center-align">
          <a href="/" className="brand-logo">Weather</a>
        </div>
      </nav>
      <div className="row">
        <Weather />
      </div>
    </div>
  );
}

export default App;
