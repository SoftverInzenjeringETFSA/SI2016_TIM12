
import ReactDOM from 'react-dom';
import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import './index.css';
import './Contact.css';
import ContactView from './ContactView.js';

var contacts = [
  {key: 1, name: "James K Nelson", email: "james@jamesknelson.com", description: "Front-end Unicorn"},
  {key: 2, name: "Jim", email: "jim@example.com"},
  {key: 3, name: "Joe"},
]

var newContact = {name: "", email: "", description: ""}

class Registration extends Component {
  render() {
    return (
	  React.createElement(ContactView, { contacts: contacts, newContact: newContact})
        
    );
  }
}


module.exports = Registration;
