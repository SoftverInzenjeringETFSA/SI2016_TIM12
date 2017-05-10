import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import User from './User';
import { Router, Route, Link, IndexLink, IndexRoute, hashHistory, browserHistory } from 'react-router';


class Login extends Component {
  render() {
    return (
	  <Container1 />
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