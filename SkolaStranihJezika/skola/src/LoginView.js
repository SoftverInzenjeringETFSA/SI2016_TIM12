import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import ContactItem from './ContactItem';
import Prijava from './Prijava';

var LoginView = React.createClass({
  propTypes: {
    contacts: React.PropTypes.array.isRequired,
    newContact: React.PropTypes.object.isRequired,
  },

  render: function() {
    var contactItemElements = this.props.contacts
      .filter(function(contact) { return contact.email })
      .map(function(contact) { return React.createElement(ContactItem, contact) })

    return (
      React.createElement('div', {className: 'ContactView'},
        React.createElement('h1', {className: 'ContactView-title'}, "Prijava"),
        React.createElement(Prijava, {
          contact: this.props.newContact,
        })
      )
    )
  },
});

module.exports = LoginView;
