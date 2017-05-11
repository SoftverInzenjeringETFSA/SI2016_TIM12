import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import User from './User';
import { Router, Route, Link, IndexLink, IndexRoute, hashHistory, browserHistory } from 'react-router';
import LoginView from './LoginView';

var contacts = [
  {key: 1, name: "James K Nelson", email: "james@jamesknelson.com", description: "Front-end Unicorn"},
  {key: 2, name: "Jim", email: "jim@example.com"},
  {key: 3, name: "Joe"},
]

var newContact = {name: "", email: "", description: ""}

class Login extends Component {
  render() {
    return (
	  React.createElement(LoginView, { contacts: contacts, newContact: newContact})
    );
  }
}
const Nav = () => (
  <div>
        <ul className="menu">
          <li><Link to="/login/stranica1" activeClassName="active">Home</Link></li>
		  <li>Home</li>
		  <li>Home</li>
		  <li>Home</li>
		  <li>Home</li>
         </ul>
  </div>
)
const Container1 = (props) => 
<div>
<div className='side'>
	<User />
	<Nav />
</div>
<div className="UserCont">
	{props.children}
</div>
</div>

module.exports = Login;