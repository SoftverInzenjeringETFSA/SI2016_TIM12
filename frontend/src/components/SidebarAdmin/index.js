import React, { Component } from 'react';
import classNames from 'classnames';
import history from '../../core/history';

class SidebarAdmin extends Component {

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
                <i className="fa fa-trello fa-fw" /> &nbsp;Novosti
              </a>
            </li>

            <li>
              <a href="" onClick={(e) => { e.preventDefault(); history.push('/forms2'); }} >
                <i className="fa fa-plus-circle fa-fw" /> &nbsp;Dodaj predavaca
              </a>
            </li>

            <li>
              <a href="" onClick={(e) => { e.preventDefault(); history.push('/table'); }} >
                <i className="fa fa-user fa-fw" /> &nbsp;Zahtjevi za pristup kursevima
              </a>
            </li>
           
            <li>
              <a href="" onClick={(e) => { e.preventDefault(); history.push('/svikorisnicistudenti'); }} >
                <i className="fa fa-dashboard fa-fw" /> &nbsp;Svi studenti
              </a>
            </li>
              <li>
              <a href="" onClick={(e) => { e.preventDefault(); history.push('/svikorisnicipredavaci'); }} >
                <i className="fa fa-dashboard fa-fw" /> &nbsp;Svi profesori
              </a>
            </li>
             <li>
              <a href="" onClick={(e) => { e.preventDefault(); history.push('/svikorisniciadmini'); }} >
                <i className="fa fa-dashboard fa-fw" /> &nbsp;Svi administratori
              </a>
            </li>
               <li>
              <a href="" onClick={(e) => { e.preventDefault(); history.push('/dodajadmina'); }} >
                <i className="fa fa-dashboard fa-fw" /> &nbsp;DodajAdmina
              </a>
            </li>
              <li>
              <a href="" onClick={(e) => { e.preventDefault(); history.push('/kursevi'); }} >
                <i className="fa fa-dashboard fa-fw" /> &nbsp;Kursevi
              </a>
            </li>
              <li>
              <a href="" onClick={(e) => { e.preventDefault(); history.push('/pomoc1'); }} >
                <i className="fa fa-dashboard fa-fw" /> &nbsp;Pomoć
              </a>
            </li>


           



            
            
           
          </ul>
        </div>
      </div>
    );
  }
}


export default SidebarAdmin;
