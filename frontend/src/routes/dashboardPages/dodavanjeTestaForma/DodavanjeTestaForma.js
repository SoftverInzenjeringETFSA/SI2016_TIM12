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

const title = 'DodavanjeTestaForma';


function displayForms(props, context) {
  context.setTitle(title);
  return (
    <div>
      <div className="row">
        <div className="col-lg-12">
          <PageHeader>Dodaj novi test</PageHeader>
        </div>
      </div>

      <div className="row">
        <div className="col-lg-12">
          <Panel header={<span>Unesite novi test</span>} >
            <div className="row">
              <div className="col-lg-6">
                <Form>
                  
                 
                  <FormGroup controlId="formBasicText2">
                    <ControlLabel>Naziv testa</ControlLabel>
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
                    <ControlLabel>Uploaduj test</ControlLabel>
                    <FormControl
                      type="file"
                    />
                    <FormControlFeedback />
                  </FormGroup>                           
                  <FormGroup>
                    <Button type="submit">Dodaj test</Button>
                   
                  
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
