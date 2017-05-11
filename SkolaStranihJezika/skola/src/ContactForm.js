import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

var ContactForm = React.createClass({
  propTypes: {
    contact: React.PropTypes.object.isRequired
  },

  render: function() {
    return (
      React.createElement('form', {className: 'ContactForm'},
        React.createElement('input', {
          type: 'text',
          placeholder: 'Ime',
          value: this.props.contact.name,
        }),
		React.createElement('input', {
          type: 'text',
          placeholder: 'Prezime ',
          value: this.props.contact.name,
        }),
		React.createElement('input', {
          type: 'text',
          placeholder: 'Datum rođenja ',
          value: this.props.contact.name,
        }),
		React.createElement('input', {
          type: 'text',
          placeholder: 'Mjesto rođenja ',
          value: this.props.contact.name,
        }),
		React.createElement('input', {
          type: 'text',
          placeholder: 'Adresa ',
          value: this.props.contact.name,
        }),
		React.createElement('input', {
          type: 'text',
          placeholder: 'JMBG ',
          value: this.props.contact.name,
        }),
        React.createElement('input', {
          type: 'email',
          placeholder: 'Email',
          value: this.props.contact.email,
        }),
		React.createElement('input', {
          type: 'text',
          placeholder: 'Šifra ',
          value: this.props.contact.name,
        }),
		React.createElement('input', {
          type: 'text',
          placeholder: 'Ponovite šifru ',
          value: this.props.contact.name,
        }),
        React.createElement('button', {type: 'submit'}, "Potvrdi")
      )
    )
  },
});
module.exports = ContactForm;