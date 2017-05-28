/**
 * React Starter Kit (https://www.reactstarterkit.com/)
 *
 * Copyright © 2014-2016 Kriasoft, LLC. All rights reserved.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */

import React, { PropTypes } from 'react';
// import { Panel, Input, Button } from 'react-bootstrap';
import Button from 'react-bootstrap/lib/Button';
import Panel from 'react-bootstrap/lib/Panel';
import { FormControl, Checkbox } from 'react-bootstrap';
import withStyles from 'isomorphic-style-loader/lib/withStyles';
import s from './Register.css';
import history from '../../core/history';
import axios from 'axios';


const title = 'Register';


function submitHandler(e) {
  e.preventDefault();
  //history.push('/');

  var username = document.getElementById("iUsername").value;
  var email = document.getElementById("iEmail").value;
  var pass = document.getElementById("iPassword").value;
  var passConfirm = document.getElementById("iPasswordConfirm").value;

  if (pass != passConfirm) {
    alert("Šifra za potvrdu mora biti jednaka orginalnoj šifri.");
  } else {
    axios.post('http://localhost:8080/studenti', {
    korisnickoIme: username,
    sifra: pass,
    email: email,
    adresaBoravista: document.getElementById("iAdresaBoravista").value,
    datumRodjenja: document.getElementById("iDatumRodjenja").value,
    ime: document.getElementById("iIme").value,
    jmbg: document.getElementById("iJmbg").value,
    mjestoRodjenja: document.getElementById("iMjestoRodjenja").value,
    prezime: document.getElementById("iPrezime").value

  })
  .then(function (response) {
    console.log("Register response", response.data.isSuccess);
    alert("Uspješno ste se registrovali. Sada se možete logovati sa registrovanim podacima.");   
  })
  .catch(function (error) {
    console.error("Register error", error);
    alert("Došlo je do greške prilikom registrovanja.");         
  });
  }
}

function Register(props, context) {
  context.setTitle(title);
  return (





    <div className="col-md-4 col-md-offset-4">
    
      <Panel header={<h3>Please Sign In</h3>} className="login-panel">

        <form role="form" onSubmit={(e) => { submitHandler(e); }}>
          <fieldset>
            <div className="form-group">
              <FormControl
                type="text"
                className="form-control"
                placeholder="Username"
                name="name"
                id="iUsername"
              />
            </div>

            <div className="form-group">
              <FormControl
                type="text"
                className="form-control"
                placeholder="E-mail"
                name="email"
                id="iEmail"
              />
            </div>


            <div className="form-group">
              <FormControl
                className="form-control"
                placeholder="Password"
                type="password"
                name="password"
                id="iPassword"
              />
            </div>

            <div className="form-group">
              <FormControl
                className="form-control"
                placeholder="Confirm Password"
                type="password"
                name="password"
                id="iPasswordConfirm"
              />
            </div>

            <div className="form-group">
              <FormControl
                type="text"
                className="form-control"
                placeholder="Adresa boravista"
                name="adresaBoravista"
                id="iAdresaBoravista"
              />
            </div>

            <div className="form-group">
              <FormControl
                type="date"
                className="form-control"
                placeholder="Datum rođenja"
                name="datumRodjenja"
                id="iDatumRodjenja"
              />
            </div>

            <div className="form-group">
              <FormControl
                type="text"
                className="form-control"
                placeholder="Ime"
                name="ime"
                id="iIme"
              />
            </div>

            <div className="form-group">
              <FormControl
                type="text"
                className="form-control"
                placeholder="JMBG"
                name="jmbg"
                id="iJmbg"
              />
            </div>

            <div className="form-group">
              <FormControl
                type="text"
                className="form-control"
                placeholder="Mjesto rođenja"
                name="mjestoRodjenja"
                id="iMjestoRodjenja"
              />
            </div>

            <div className="form-group">
              <FormControl
                type="text"
                className="form-control"
                placeholder="Prezime"
                name="prezime"
                id="iPrezime"
              />
            </div>



            <Button type="submit" bsSize="large" bsStyle="success" block>Register</Button>

          </fieldset>
        </form>

      </Panel>

      <Button type="submit" bsStyle="info" block
      onClick = {(event) => { history.push('/naslovna');}}>Nazad na početnu</Button>

    </div>

  );
}


Register.contextTypes = { setTitle: PropTypes.func.isRequired };

export default withStyles(s)(Register);
