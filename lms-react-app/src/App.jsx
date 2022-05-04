import React from "react";
import "./App.scss";
import { Login, Register } from "./components/login/index";

import {Login} from './components/login';
import {Register} from './components/login';

class App extends React.Component{


    constructor(props) {
        super(props);
        this.state = {
          isLogginActive: true
        };
      }



      render(){
        const { isLogginActive } = this.state;
        const current = isLogginActive ? "Register" : "Login";
        const currentActive = isLogginActive ? "login" : "register";
        return(

        );
      
    }


}