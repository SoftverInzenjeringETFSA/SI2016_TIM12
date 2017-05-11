import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class News extends Component {
  render() {
    return (
      <div className="obavijest">
          <h3>Naslov</h3>
          <p>Ovo je tekst obavijesti</p>
        </div>
    );
  }
}
module.exports = News;
