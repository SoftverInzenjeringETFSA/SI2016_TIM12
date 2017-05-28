
import React from 'react';
import withStyles from 'isomorphic-style-loader/lib/withStyles';
import {
  Nav,
  NavItem,
  NavDropdown,
  MenuItem,
  ProgressBar,
} from 'react-bootstrap';
import Navbar, {Brand} from 'react-bootstrap/lib/Navbar';
import history from '../../core/history';
import $ from "jquery";

import SidebarAdmin from '../SidebarAdmin';
import SidebarUcenik from '../SidebarUcenik';
import SidebarUcitelj from '../SidebarUcitelj';


const logo = require('./logo.png');

function Homepage() {
  const userType = 'KORISNIK'; // Moguce vrijednosti su UCENIK, UCITELJ, ADMIN
  let sb = null;
    if (userType == 'ADMIN') {
      sb = <SidebarAdmin />;
    } 
    else if (userType == 'UCENIK') {
      sb = <SidebarUcenik />;
    }
    else if (userType == 'UCITELJ') {
    sb = <SidebarUcitelj />;}
    else if (userType == 'KORISNIK')
      {
        sb = <Homepage />;
      }
    

  return (
    <div id="wrapper" className="content">
      <Navbar fluid={true}  style={ {margin: 0} }>
          <Brand>
            <span>
              <img src={logo} alt="Start React" title="Start React" />
              <span>&nbsp;Strani Jezici </span>            
                <button type="button" className="navbar-toggle" onClick={() => {toggleMenu();}} style={{position: 'absolute', right: 0, top: 0}}>
                  <span className="sr-only">Toggle navigation</span>
                  <span className="icon-bar"></span>
                  <span className="icon-bar"></span>
                  <span className="icon-bar"></span>
                </button>
            </span>
          </Brand>
          
          <ul className="nav navbar-top-links navbar-right">

             
           <NavDropdown title={<i className="fa fa-user fa-fw"></i> } id = 'navDropdown4'>
                  <MenuItem eventKey="1">
                    <span> <i className="fa fa-user fa-fw"></i> User Profile </span>
                  </MenuItem>
                  <MenuItem eventKey="2">
                    <span><i className="fa fa-gear fa-fw"></i> Settings </span>
                  </MenuItem>
                  
                  <MenuItem divider />
                  <MenuItem eventKey = "4" onClick = {(event) => { history.push('/login');}}>
                    <span> <i className = "fa fa-sign-out fa-fw" /> Logout </span>
                  </MenuItem>
            </NavDropdown>

          </ul>
          {sb}
    </Navbar>
    </div>
  );
}
function toggleMenu(){
    if($(".navbar-collapse").hasClass('collapse')){
      $(".navbar-collapse").removeClass('collapse');
    }
    else{
      $(".navbar-collapse").addClass('collapse');
    }
  }

export default Homepage;
