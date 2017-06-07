/**
 * React Starter Kit (https://www.reactstarterkit.com/)
 *
 * Copyright © 2014-2016 Kriasoft, LLC. All rights reserved.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */

import React from 'react';
import App from '../components/App';

// Child routes

import home from './home';
import login from './login';
import register from './register';
import table from './dashboardPages/tables';
import button from './dashboardPages/buttons';
import flotcharts from './dashboardPages/flotCharts';
import forms from './dashboardPages/forms';
import forms2 from './dashboardPages/forms2';
import dodajadmina from './dashboardPages/dodajAdmina';
import kursevi from './dashboardPages/kursevi';

import pomoc1 from './dashboardPages/pomoc1';
import pomoc2 from './dashboardPages/pomoc2';
import pomoc3 from './dashboardPages/pomoc3';

import svikorisnicipredavaci from './dashboardPages/svikorisnicipredavaci';
import svikorisnicistudenti from './dashboardPages/svikorisnicistudenti';
import svikorisniciadmini from './dashboardPages/svikorisniciadmini';


import dashboarducitelj from './dashboardPages/dashboardUcitelj';

import kursstranica from './dashboardPages/kursStranica';


import dodavanjelekcijeforma from './dashboardPages/dodavanjeLekcijeForma';
import dodavanjetestaforma from './dashboardPages/dodavanjeTestaForma';
import dodavanjeterminaforma from './dashboardPages/dodavanjeTerminaForma';
import svikursevi from './dashboardPages/sviKursevi';
import zavrsenikursevi from './dashboardPages/zavrseniKursevi';
import mojikursevi from './dashboardPages/mojiKursevi';

import icons from './dashboardPages/icons';
import morrisjscharts from './dashboardPages/morrisjsCharts';
import notification from './dashboardPages/notification';
import panelwells from './dashboardPages/panelWells';
import typography from './dashboardPages/typography';
import blank from './dashboardPages/blank';
import error from './error';
import naslovna from'./naslovna';
import LoggedUser from '../globals';

import Header from '../components/Header';

export default [

   {
    path: '/naslovna',
    children: [
      naslovna,
      
      
    ],
    async action({ next, render, context }) {
      const component = await next();
      if (component === undefined) return component;
      return render(
        <App context={context}>{component}</App>
      );
    },
  },  


  {
    path: '/login',
    children: [
      login,
      
      
    ],
    async action({ next, render, context }) {
      const component = await next();
      if (component === undefined) return component;
      return render(
        <App context={context}>{component}</App>
      );
    },
  },  




  {
    path: '/register',
    children: [
      register,
      
      
    ],
    async action({ next, render, context }) {
      const component = await next();
      if (component === undefined) return component;
      return render(
        <App context={context}>{component}</App>
      );
    },
  }, 

  {
    path: '/',

  // keep in mind, routes are evaluated in order
    children: [
      home,
      notification,
      dodajadmina,
      kursstranica,
      svikorisnicipredavaci,
      svikorisnicistudenti,
      svikorisniciadmini,
      // contact,
      table,
      mojikursevi,
      zavrsenikursevi,
      svikursevi,
      button,
      flotcharts,
      forms,
      forms2,
   
      pomoc1,
      pomoc2,
      pomoc3,

      //ucitelj frome
      dodavanjelekcijeforma,
      dodavanjetestaforma,
      dodavanjeterminaforma,
      dashboarducitelj,
      kursevi,





      icons,
      morrisjscharts,   
      panelwells,
      typography,
      // register,
      blank,
      // place new routes before...
      // content,
      error,
    ],

    async action({ next, render, context }) {
      // console.log('inside dashboard');
      const component = await next();
      // console.log('inside dasdboard component', component);
      if (component === undefined) return component;
      console.log(LoggedUser.IsLoggedIn() + " -- " + LoggedUser.GetUserType());
      if (!LoggedUser.IsLoggedIn()) {
        window.location.href = "/naslovna";
        return render();
      }

      return render(
        <div>
          <Header />
          <div id="page-wrapper" className="page-wrapper">
            <App context={context}>{component}</App>
          </div>
        </div>
      );
    },
  },
  {
    path: '/error',
    children: [
      error,
    ],
    async action({ next, render, context }) {
      // console.log('inside error');
      const component = await next();
      // console.log('inside error with component', component);
      if (component === undefined) return component;
      return render(
        <App context={context}>{component}</App>
      );
    },
  },
];
