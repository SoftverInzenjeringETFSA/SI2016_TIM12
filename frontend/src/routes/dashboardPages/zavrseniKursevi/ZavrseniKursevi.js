
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
        <PageHeader>Tables</PageHeader>
      </div>

    

      <div className="row ng-scope">
        <div className="col-lg-6">
          <Panel header={<span>Moji zavrseni kursevi</span>} >
            <div className="table-responsive">
              <table className="table table-striped table-bordered table-hover">
                <thead>
                  <tr>
                    <th># </th>
                    <th>Naziv Kursa </th>
                    <th>Kategorija </th>
                                
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td></td>
                    <td></td>
                    <td></td>                
                   
                  </tr>
                  
                  
                </tbody>
              </table>
            </div>
          </Panel>
        </div>

        
      </div>

    </div>

  );
}


displayTable.contextTypes = { setTitle: PropTypes.func.isRequired };

export default displayTable;
