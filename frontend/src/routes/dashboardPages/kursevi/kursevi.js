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


const title = 'Kursevi';

function submitHandler(e) {
  e.preventDefault();
  //history.push('/');

  var nazivKursa = document.getElementById("iNaziv").value;
  var stepenKursa = document.getElementById("iStepenKursa").value;
  //console.log(nazivKursa + " -- " + stepenKursa);
  
  axios.post('http://localhost:8080//dodajKurs', {
  naziv: nazivKursa,
  stepen: stepenKursa,
  })
  .then(function (response) {
    console.log("Register response", response.data.isSuccess);
    alert("Uspjesno dodan novi kurs!");   
  })
  .catch(function (error) {
    console.error("Register error", error);
    alert("Došlo je do greške prilikom registrovanja.");         
  });
  
}

function brisanjeKursa(idKursa)
{
  alert("Trenutno nije moguce obrisati kurs. Backend tim nije napravio kontroler za to a meni je sad mrsko to radti!");
}

class UnosKursa extends React.Component {
  render() {
      return(

      
       <div>
      <div className="row">
        <div className="col-lg-12">
          <PageHeader>Dodaj kurs</PageHeader>
        </div>
      </div>

      <div className="row">
        <div className="col-lg-12">
          <Panel header={<span>Unesite novi kurs</span>} >
            <div className="row">
              <div className="col-lg-6">
                <Form role="form" onSubmit={(e) => { submitHandler(e); }}>
                 <fieldset>

            <div className="form-group">
            <label for="sel1">Odaberite stepen kursa</label>
            <select className="form-control" id="iNaziv">
              <option>Engleski</option>
              <option>Njemacki</option>
              <option>Spanski</option>
              <option>Turski</option>
            </select>
            </div>

            <div className="form-group">
            <label for="sel1">Odaberite stepen kursa</label>
            <select className="form-control" id="iStepenKursa">
              <option>A1</option>
              <option>A2</option>
              <option>B1</option>
              <option>B2</option>
              <option>C1</option>
              <option>C2</option>
            </select>
            </div>
           

<Button type="submit" bsSize="large" bsStyle="success" block>Dodajte novi kurs</Button>
       
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
}

var IspisSvihKurseva = React.createClass({

  getInitialState: function() {
      return {
        users: []
      }
    },

    componentDidMount: function() {
      var _this = this;
      axios
        .get("http://localhost:8080/kursevi")
        .then(function(result) {   
          _this.setState({
            users: result.data
          });
        });
    },
  
  render: function() {
    return (
            <div>
      <div className="col-lg-12">
        <PageHeader>Svi kursevi</PageHeader>
      </div>    
        <div className="col-lg-6">
          <Panel header={<span>Kursevi</span>} >
            <div className="table-responsive">
              <table className="table table-striped table-bordered table-hover">
                <thead>
                  <tr>                 
                    <th>Jezik</th>
                    <th>Stepen </th>                 
                    <th>Izbrisi kurs</th>
                  </tr>
                </thead>
                <tbody>                 

                  {
                    this.state.users.map(function(user) {
                  return (
                    <tr key={user.id}>             
                    <td>{user.naziv}</td>
                    <td>{user.stepen}</td>                              
                 <td><button type="button" onClick ={(event)=>{brisanjeKursa(user.id);}}>Izbrisi</button></td>
                       </tr>
                  );
                })
                
                 
                }
                </tbody>
              </table>
            </div>
          </Panel>             
      </div>
    </div>
    );
  }
});

function displayForms(props, context) {
  context.setTitle(title);
  return (
      <div>
      <UnosKursa />
      <IspisSvihKurseva />
      </div>
      
  );
}



displayForms.contextTypes = { setTitle: PropTypes.func.isRequired };

export default displayForms;