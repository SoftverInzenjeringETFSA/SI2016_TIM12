import React, { Component } from 'react';
import { Router, Route, Link, IndexLink, IndexRoute, hashHistory, browserHistory } from 'react-router';
import Home from './Home';
import Contact from './Contact';
import About from './About';

class App extends Component {
  render () {
    return (
      <Router history={hashHistory}>
        <Route path='/' component={Container}>
          <IndexRoute component={Home} />
			  <Route path='about' component={About} />
			  <Route path='contact' component={Contact} />
			  <Route path='*' component={NotFound} />
        </Route>
      </Router>
    )
  }
}

const Nav = () => (
  <div>
        <ul className="header">
          <li><IndexLink to="/" activeClassName="active">Home</IndexLink></li>
          <li><Link to="/about" activeClassName="active">O nama</Link></li>
          <li><Link to="/contact" activeClassName="active">Kontakt</Link></li>
        </ul>
  </div>
)
const Container = (props) => <div>
  <Nav />
  <div className="content">
  {props.children}
</div></div>
const NotFound = () => (
  <h1>404.. This page is not found!</h1>)
export default App