import React, { PropTypes } from 'react';
import {
  Panel,
  Button,
  Col,
  PageHeader,
  ControlLabel,
  FormControl,
  HelpBlock,
  FormGroup,
  Checkbox,
  Form,
  Radio,
  InputGroup,
  Glyphicon } from 'react-bootstrap';

import FormControlFeedback from 'react-bootstrap/lib/FormControlFeedback';
import FormControlStatic from 'react-bootstrap/lib/FormControlStatic';
import InputGroupAddon from 'react-bootstrap/lib/InputGroupAddon';
import axios from 'axios';


const title = 'DodajAdmina';


function submitHandler(e) {
  e.preventDefault();
  //history.push('/');

  var username = document.getElementById("iUsername").value;
  var pass = document.getElementById("iPassword").value;
  var passConfirm = document.getElementById("iPasswordConfirm").value;

  if (pass != passConfirm) {
    alert("Šifra za potvrdu mora biti jednaka orginalnoj šifri.");
  } else {
  .then(function (response) {
        console.log(response);
        if(response.data == "slobodno")
        {
            axios.post('http://localhost:8080/administratori', {
            korisnickoIme: username,
            sifra: pass,
          })
          .then(function (response) {
            console.log("Register response", response.data.isSuccess);
            alert("Uspjesno ste dodali administratora.");   
          })
          .catch(function (error) {
            console.error("Register error", error);
            alert("Došlo je do greške prilikom registrovanja.");         
          });
        }
        else 
        {
          alert("Već postoji borac sa odabranim korisničkim imenom!");
        }
  })
  .catch(function (error) {
    console.log(error);
    alert("Desila se greška! ");
  });
  }
}

function displayForms(props, context) {
  context.setTitle(title);
  return (
    <div>
      <div className="row">
        <div className="col-lg-12">
          <PageHeader>Dodaj administratora</PageHeader>
        </div>
      </div>

      <div className="row">
        <div className="col-lg-12">
          <Panel header={<span>Unesite novog admina</span>} >
            <div className="row">
              <div className="col-lg-6">
                <Form role="form" onSubmit={(e) => { submitHandler(e); }}>
                 <fieldset>
            <div className="form-group">
              <FormControl
                type="text"
                className="form-control"
                placeholder="Korisničko ime"
                name="name"
                id="iUsername"
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

            <div className="form-group">
              <FormControl
                className="form-control"
                placeholder="Potvrdi šifru"
                type="password"
                name="password"
                id="iPasswordConfirm"
              />
            </div>

           

<Button type="submit" bsSize="large" bsStyle="success" block>registruj novog admina</Button>


        
          </fieldset>


                </Form>
              </div>  
              </div>           
          </Panel>
        </div>
      </div>
    </div>
  );
}

displayForms.contextTypes = { setTitle: PropTypes.func.isRequired };

export default displayForms;
