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


const title = 'Pomoc2';

function displayForms(props, context) {
  context.setTitle(title);
  return (
      
       <div>
      <div className="row">
        <div className="col-lg-12">
          <PageHeader>POMOC Administratoru DA SE KORISTI STRANICOM:</PageHeader>
        </div>
      </div>

      <div className="row">
        <div className="col-lg-12"> 
      <h>  Lorem ipsum dolor sit amet, his sumo probo maiorum te. Ei vel nulla laudem aperiam, meis oportere voluptatum an pri.  </h>
    
        </div>
      </div>
    </div>
    );
  }



export default displayForms;
