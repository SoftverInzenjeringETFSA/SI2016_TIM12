
import React, { PropTypes } from 'react';
import Button from 'react-bootstrap/lib/Button';
import Panel from 'react-bootstrap/lib/Panel';
import Pagination from 'react-bootstrap/lib/Pagination';
import PageHeader from 'react-bootstrap/lib/PageHeader';
import Well from 'react-bootstrap/lib/Well';
import axios from 'axios';

const title = 'Table';

function prijavljivanjeNaKurs(studentId)
{
  alert("Ova funkcionalnost jos nije dodana");
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
                 <td><button type="button" onClick ={(event)=>{prijavljivanjeNaKurs(user.id);}}>Prijavi se na ovaj kurs</button></td>
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

function displayTable(props, context) {
  context.setTitle(title);
  return (
    <div>
    <IspisSvihKurseva />
    </div>
  );
}


displayTable.contextTypes = { setTitle: PropTypes.func.isRequired };

export default displayTable;
