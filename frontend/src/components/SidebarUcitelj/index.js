import React, { Component } from 'react';
import classNames from 'classnames';
import history from '../../core/history';

class SidebarUcitelj extends Component {

  constructor(props) {
    super(props);
    this.state = {
      uiElementsCollapsed: true,
      chartsElementsCollapsed: true,
      multiLevelDropdownCollapsed: true,
      thirdLevelDropdownCollapsed: true,
      samplePagesCollapsed: true,
    };
  }

  render() {
    return (
      <div className="navbar-default sidebar" style={{ marginLeft: '-20px' }} role="navigation">
        <div className="sidebar-nav navbar-collapse collapse">
          <ul className="nav in" id="side-menu">
            

            <li>
              <a href="" onClick={(e) => { e.preventDefault(); history.push('/notification'); }} >
                <i className="fa fa-dashboard fa-fw" /> &nbsp;Novosti
              </a>
            </li>

            
                <li>
                  <a href="" onClick={(e) => { e.preventDefault(); history.push('/dashboarducitelj'); }} >
                   Moje lekcije, termini i testovi 
                  </a>
                </li>
                <li>
                  <a
                    href=""
                    onClick={(e) => { e.preventDefault(); history.push('/dodavanjeterminaforma'); }}
                  > Dodaj termin predavanja kursa
                    
                  </a>
                </li>
                 <li>
                  <a
                    href=""
                    onClick={(e) => { e.preventDefault(); history.push('/dodavanjetestaforma'); }}
                  > Dodaj test za kurs
                    
                  </a>
                </li>
                <li>
                  <a
                    href=""
                    onClick={(e) => { e.preventDefault(); history.push('/dodavanjelekcijeforma'); }}
                  > Dodaj novu lekciju za kurs
                    
                  </a>
                </li>
              
    



            
            
           
          </ul>
        </div>
      </div>
    );
  }
}


export default SidebarUcitelj;
