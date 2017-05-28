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

const title = 'Forms';


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
                  <FormGroup
                    controlId="formBasicText"
                  >
                    <ControlLabel>Ime</ControlLabel>
                    <FormControl
                      type="text"
                    />
                    <FormControlFeedback />
                    <ControlLabel>Prezime</ControlLabel>
                    <FormControl
                      type="text"
                    />
                    <FormControlFeedback />
                    <ControlLabel>Telefon</ControlLabel>
                    <FormControl
                      type="text"
                    />
                    <FormControlFeedback />


                    <ControlLabel>E-mail</ControlLabel>
                    <FormControl
                      type="text"
                    />

                      <FormGroup>
                
                    <FormControlStatic>
                      email@example.com
                    </FormControlStatic>
                  </FormGroup>
                    <FormControlFeedback />

                    
                  </FormGroup>

                  <FormGroup controlId="formBasicText2">
                    <ControlLabel>Šifra</ControlLabel>
                    <FormControl
                      type="text"
                      placeholder="Enter Text"
                    />
                    <HelpBlock>Šifra mora biti jedna rijec koja sadrzi slova.</HelpBlock>
                     
                    <FormControlFeedback />
                  </FormGroup>

                

                  <FormGroup
                    controlId="formBasicFile"
                  >
                    <ControlLabel>Slika: </ControlLabel>
                    <FormControl
                      type="file"
                    />
                    <FormControlFeedback />
                  </FormGroup>

                  

               
                  <FormGroup controlId="formControlsSelect">
                    <ControlLabel>Jezik koji predaje</ControlLabel>
                    <FormControl componentClass="select" placeholder="select">
                      <option value="1">Njemacki jezik A1</option>
                      <option value="2">Njemacki jezik A2</option>
                      <option value="3">Njemacki jezik A3</option>
                      <option value="4">Njemacki jezik A4</option>
                      <option value="5">5</option>
                    </FormControl>
                  </FormGroup>

                  
                  <FormGroup>
                    <Button type="submit">Dodaj učitelja!</Button>
                    {'  '}
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
