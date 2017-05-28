
import React, { PropTypes } from 'react';
import Button from 'react-bootstrap/lib/Button';
import Panel from 'react-bootstrap/lib/Panel';
import Pagination from 'react-bootstrap/lib/Pagination';
import PageHeader from 'react-bootstrap/lib/PageHeader';
import Well from 'react-bootstrap/lib/Well';


const title = 'Table';

function displayTable(props, context) {
  context.setTitle(title);
  return (
    <div>
      <div className="col-lg-12">
        <PageHeader>Svi korisnici</PageHeader>
      </div>    
        <div className="col-lg-6">
          <Panel header={<span>Učenici </span>} >
            <div className="table-responsive">
              <table className="table table-striped table-bordered table-hover">
                <thead>
                  <tr>                 
                    <th>Ime</th>
                    <th>Prezime </th>                 
                    <th>Izbrisi korisnika</th>

                  </tr>
                </thead>
                <tbody>
                  <tr>                
                    <td>Ajla</td>
                    <td>Sukrija </td>                              
                    <td><button type="button">Izbrisi</button></td>
                  </tr>
                  <tr>                
                    <td>Ajlica </td>
                    <td> Sukrijcia</td>                        
                    <td><button type="button">Izbrisi</button></td>
                  </tr>
                  
                </tbody>
              </table>
            </div>
          </Panel>
              
      </div>



   
        <div className="col-lg-6">
          <Panel header={<span>Profesori: </span>} >
            <div className="table-responsive">
              <table className="table table-striped table-bordered table-hover">
                <thead>
                  <tr>                 
                    <th>Ime</th>
                    <th>Prezime </th>                 
                    <th>Izbrisi korisnika</th>

                  </tr>
                </thead>
                <tbody>
                  <tr>                
                    <td>Ajla</td>
                    <td>Sukrija </td>                              
                    <td><button type="button">Izbrisi</button></td>
                  </tr>
                  <tr>                
                    <td>Ajlica </td>
                    <td> Sukrijcia</td>                        
                    <td><button type="button">Izbrisi</button></td>
                  </tr>
                  
                </tbody>
              </table>
            </div>
          </Panel>
        </div>      
      
    </div>

  );
}


displayTable.contextTypes = { setTitle: PropTypes.func.isRequired };

export default displayTable;
