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


const title = 'Forms';



function submitHandler(e) {
  e.preventDefault();
  //history.push('/');

  var username = document.getElementById("iUsername").value;
  var email = document.getElementById("iEmail").value;
  var pass = document.getElementById("iPassword").value;
  var passConfirm = document.getElementById("iPasswordConfirm").value;
  var kursDodavanje = {
    id: document.getElementById("iStepenKursa").value
  }
  if (pass != passConfirm) {
    alert("Šifra za potvrdu mora biti jednaka orginalnoj šifri.");
  } else {
    axios.post('http://localhost:8080/dodajPredavaca', {
    korisnickoIme: username,
    sifra: pass,
    email: email,
    brojTelefona: document.getElementById("ibrojTelefona").value,
    ime: document.getElementById("iIme").value,
    prezime: document.getElementById("iPrezime").value,
    kurs:kursDodavanje, 

  })
  .then(function (response) {
    console.log("Register response", response.data.isSuccess);
    alert("Uspjesno ste dodali novog ucitelja/predavaca/profesora ili kako god ga nazvali!");   
  })
  .catch(function (error) {
    console.error("Register error", error);
    alert("Došlo je do greške prilikom registrovanja.");         
  });
  }
}

var DodavanjePredavaca = React.createClass({
  getInitialState: function() {
      return {
        kursevi: []
      }
    },

    componentDidMount: function() {
      var _this = this;
      axios
        .get("http://localhost:8080/kursevi")
        .then(function(result) {   
          _this.setState({
            kursevi: result.data
          });
        });
    },
  
  render: function() {
    return (
       <div>
      <div className="row">
        <div className="col-lg-12">
          <PageHeader>Dodaj predavaca</PageHeader>
        </div>
      </div>

      <div className="row">
        <div className="col-lg-12">
          <Panel header={<span>Unesite novog predavaca</span>} >
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


            <div className="form-group">
              <FormControl
                type="date"
                className="form-control"
                placeholder="Broj telefona"
                name="brojTelefona"
                id="ibrojTelefona"
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
                placeholder="Prezime"
                name="prezime"
                id="iPrezime"
              />
            </div>

            <div className="form-group">
            <label for="sel1">Odaberite kursa</label>
            <select className="form-control" id="iStepenKursa">
            {
                  this.state.kursevi.map(function(kurs) {
                  return (
                    <option key={kurs.id} value={kurs.id}>             
                      {kurs.naziv} - {kurs.stepen}
                       </option>
                  );
                })
              }
            </select>
            </div>



<Button type="submit" bsSize="large" bsStyle="success" block>Registruj predavaca</Button>


        
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
});

function displayForms(props, context) {


  context.setTitle(title);
  return (
    <div>
    <p>radiii123</p>
    <DodavanjePredavaca />
    </div>
  );
}

displayForms.contextTypes = { setTitle: PropTypes.func.isRequired };

export default displayForms;
