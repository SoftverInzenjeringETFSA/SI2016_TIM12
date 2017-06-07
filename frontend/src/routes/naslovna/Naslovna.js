

import React, { PropTypes } from 'react';
// import { Panel, Input, Button } from 'react-bootstrap';
import Button from 'react-bootstrap/lib/Button';
import Panel from 'react-bootstrap/lib/Panel';
import { FormControl, Checkbox } from 'react-bootstrap';
import Alert from 'react-bootstrap/lib/Alert';
import withStyles from 'isomorphic-style-loader/lib/withStyles';
import s from './Naslovna.css';
import history from '../../core/history';
import LoggedUser from '../../globals';
import axios from 'axios';

const title = 'Naslovna';


function submitHandler(e) {
  e.preventDefault();
  history.push('/');
}

console.log(LoggedUser.IsLoggedIn() + " - " + LoggedUser.GetUserType());

function Naslovna(props, context) {
  context.setTitle(title);
  return (
<div>
 <div className="col-md-3 col-md-offset-3">
      <Panel header={<h3>Dobrodošli u školu stranih jezika! OVO JE NASLOVNA STRANA.</h3>} className="login-panel">
        <Button type="submit" bsSize="large" bsStyle="success" onClick = {(event) => { history.push('/login');}} block>Prijavi se</Button>
        <Button type="submit" bsSize="large" bsStyle="success" onClick = {(event) => { history.push('/register');}} block>Napravi novi račun</Button>

      </Panel>

    </div>
</div>
    
  );
}


Naslovna.contextTypes = { setTitle: PropTypes.func.isRequired };

export default withStyles(s)(Naslovna);
