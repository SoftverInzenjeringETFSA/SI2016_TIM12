
import React, { PropTypes } from 'react';
// import { Panel, Input, Button } from 'react-bootstrap';
import Button from 'react-bootstrap/lib/Button';
import Panel from 'react-bootstrap/lib/Panel';
import { FormControl, Checkbox } from 'react-bootstrap';
import Alert from 'react-bootstrap/lib/Alert';
import withStyles from 'isomorphic-style-loader/lib/withStyles';
import s from './Login.css';
import history from '../../core/history';
import LoggedUser from '../../globals';
import axios from 'axios';

const title = 'Log In';


function submitHandler(e) {
  e.preventDefault();
  //history.push('/');

  var username = document.getElementById("iName").value;
  var password = document.getElementById("iPassword").value;



  axios.post('http://localhost:8080/logIn', {
    korisnickoIme: username,
    sifra: password
  })
  .then(function (response) {
    console.log(response);
   /* console.log("Login response", response.data.isSuccess);
    LoggedUser.SetLoggedIn(true, response.data.userType)
    history.push('/');    */
    if(response.data == "greska")
    {
      alert("Unijeli ste pogresne podatke");
    }
    else
    {
      console.log(response.data);
      if(response.data == "student")
      {
          LoggedUser.SetLoggedIn(true, "student");
          localStorage.setItem('tipKorisnika', "student");
      }
       
      else if(response.data == "administrator")
      {
        LoggedUser.SetLoggedIn(true, "administrator");
        localStorage.setItem('tipKorisnika', "administrator");
        var retrievedObject = localStorage.getItem('tipKorisnika');
        console.log('retrievedObject: ', retrievedObject);
    }
      else if(response.data == "predavac")
      {
        LoggedUser.SetLoggedIn(true, "predavac");
          localStorage.setItem('tipKorisnika', "predavac");
        
      }

      history.push('/');
    }
  })
  .catch(function (error) {
    console.error("Login error", error);
    alert("Došlo je do greške prilikom logovanja.");         
  });
}

function Login(props, context) {
  context.setTitle(title);
  console.log(LoggedUser.type);
  return (


    <div className="col-md-4 col-md-offset-4">  
      <Panel header={<h3>Prijavi se na svoj račun</h3>} className="login-panel">

        <form role="form" onSubmit={(e) => { submitHandler(e); }}>
          <fieldset>
            <div className="form-group">
              <FormControl
                type="text"
                className="form-control"
                placeholder="Korisnicko ime"
                name="name"
                id="iName"
              />
            </div>

            <div className="form-group">
              <FormControl
                className="form-control"
                placeholder="Šifra"
                type="password"
                name="password"
                id="iPassword"
              />
            </div>            
            <Button type="submit" bsSize="large" bsStyle="success" block>Login</Button>
            

          
          </fieldset>
        </form>

        <div>
         <a
                  href=""
                  onClick = {(event) => { history.push('/register');}}
                  className="alert-link"
                 >

                 Nemate korisnicki racun? REGISTRUJ SE OVDJE!!!
                 </a> 
        
        </div>

      </Panel>

    </div>

  );
}


Login.contextTypes = { setTitle: PropTypes.func.isRequired };

export default withStyles(s)(Login);
