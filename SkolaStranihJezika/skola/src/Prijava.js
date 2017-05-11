import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

var Prijava = React.createClass({
  propTypes: {
    contact: React.PropTypes.object.isRequired
  },

  render: function() {
    return (
      React.createElement('form', {className: 'ContactForm'},
        React.createElement('input', {
          type: 'text',
          placeholder: 'Username',
          value: this.props.contact.name,
        }),
		
		React.createElement('input', {
          type: 'text',
          placeholder: 'Password ',
          value: this.props.contact.name,
        }),
        React.createElement('button', {type: 'submit'}, "Prijava")
      )
    )
  },
});
module.exports = Prijava;