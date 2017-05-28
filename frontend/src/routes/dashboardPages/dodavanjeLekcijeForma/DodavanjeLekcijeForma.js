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

const title = 'DodavanjeLekcijeForma';




function submitHandler(e) {
  e.preventDefault();
  //history.push('/');

  var username = document.getElementById("iUsername").value;
  var email = document.getElementById("iEmail").value;
  
    axios.post('http://localhost:8080/studenti', {
    korisnickoIme: username,
   
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


function displayForms(props, context) {
  context.setTitle(title);
  return (
    <div>
      <div className="row">
        <div className="col-lg-12">
          <PageHeader>Dodaj učitelja</PageHeader>
        </div>
      </div>

      <div className="row">
        <div className="col-lg-12">
          <Panel header={<span>Unesite novog ucitelja</span>} >
            <div className="row">
              <div className="col-lg-6">
                <Form>
                  
                 
                  <FormGroup controlId="formBasicText2">
                    <ControlLabel>Naziv lekcije</ControlLabel>
                    <FormControl
                      type="text"
                      placeholder="Enter Text"
                    />
                    <HelpBlock></HelpBlock>
                     
                    <FormControlFeedback />
                  </FormGroup>

                

                  <FormGroup
                    controlId="formBasicFile"
                  >
                    <ControlLabel>Uploaduj lekciju</ControlLabel>
                    <FormControl
                      type="file"
                    />
                    <FormControlFeedback />
                  </FormGroup>                           
                  <FormGroup>
                    <Button type="submit">Dodaj lekciju</Button>
                   
                    <Button type="reset">Resetuj: </Button>
                  </FormGroup>
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
