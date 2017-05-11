import React, { Component } from 'react';
class LectorRegistration extends Component {

    loginValidation(){
      //ovdje validirati unos što će spriječiti submit ako je neko od polja neispravno
      return true;
    }

  render() {
    return (
      <div>
        <form name="LectorRegistrationForm" onSubmit={() => {return this.loginValidation}}>
          <label>Ime:&nbsp;&nbsp;</label>
          <input type="text" ref="predavacIme"/>
          <br />
          <label>Prezime:&nbsp;&nbsp;</label>
          <input type="text" ref="predavacPrezime"/>
          <br />
          <label>Broj Telefona:&nbsp;&nbsp;</label>
          <input type="text" ref="brojTelefona"/>
          <br />
          <label>E-mail:&nbsp;&nbsp;</label>
          <input type="text" placeholder="example@example.com" ref="email"/>
          <br />
          <label>Korisničko Ime:&nbsp;&nbsp;</label>
          <input type="text" ref="korisnickoIme"/>
          <br />
          <label>Šifra:&nbsp;&nbsp;</label>
          <input type="text" ref="sifra"/>
          <br />
          <label>Ponovite šifru:&nbsp;&nbsp;</label>
          <input type="text" ref="ponoviSifru"/>
          <br />
          <label>Jezik i stepen:&nbsp;&nbsp;</label>
          <select ref="jezikSelect">
            <option value="njemackiA1">Njemački A1</option>
            <option value="njemackiA2">Njemački A2</option>
            <option value="njemackiB1">Njemački B1</option>
            <option value="njemackiB2">Njemački B2</option>
            <option value="njemackiC1">Njemački C1</option>
            <option value="njemackiC2">Njemački C2</option>
            <option value="engleskiA1">Engleski A1</option>
            <option value="engleskiA2">Engleski A2</option>
            <option value="engleskiB1">Engleski B1</option>
            <option value="engleskiB2">Engleski B2</option>
            <option value="engleskiC1">Engleski C1</option>
            <option value="engleskiC2">Engleski C2</option>
            <option value="spanskiA1">Španski A1</option>
            <option value="spanskiA2">Španski A2</option>
            <option value="spanskiB1">Španski B1</option>
            <option value="spanskiB2">Španski B2</option>
            <option value="spanskiC1">Španski C1</option>
            <option value="spanskiC2">Španski C2</option>
          </select>
          <br />
          <button type="submit">Registruj</button>
        </form>
      </div>
    );
  }
}

module.exports = LectorRegistration;
