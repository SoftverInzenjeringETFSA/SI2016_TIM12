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

  var naziv = document.getElementById("inaziv").value;
  var stepen = document.getElementById("istepen").value;
  var  opis =document.getElementById('iopis').value;
    axios.post('http://localhost:8080/objaviTermin', {
    nazivKursa: naziv,
    stepenKursa: stepen,
    opisPredavanja: opis

  })
  .then(function (response) {
    console.log("Register response", response.data.isSuccess);
    alert("Uspješno ste dodali termin.");   
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
          <PageHeader>dodaj termin predavanja</PageHeader>
        </div>
      </div>

      <div className="row">
        <div className="col-lg-12">
          <Panel header={<span>unesi</span>} >
            <div className="row">
              <div className="col-lg-6">


                <Form role="form" onSubmit={(e) => { submitHandler(e); }}>
                  
                 
                   <fieldset>
            <div className="form-group">
              <FormControl
                type="text"
                className="form-control"
                placeholder="Naziv"
                name="naziv"
                id="inaziv"
              />
            </div>

            <div className="form-group">
              <FormControl
                type="text"
                className="form-control"
                placeholder="Stepen kursa"
                name="stepen"
                id="istepen"
              />
            </div>


            <div className="form-group">
              <FormControl
                type="text"
                className="form-control"
                placeholder="opis termina "
                name="opis"
                id="iopis"
              />
            </div>

            <Button type="submit" bsSize="large" bsStyle="success" block>Register</Button>

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
