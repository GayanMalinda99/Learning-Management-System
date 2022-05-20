import React from "react";
import "./App.scss";/*
import { Login, Register } from "./components/login/index";
import AddCourse from "./components/course/AddCourse";
import ResponsiveAppBar from "./components/dashboard/LecturerDashboard";
import ViewCourses from "./components/course/ViewCourses";
import { Routes, Route } from "react-router";
import Panel from "./components/AnnouncementPalet/Panel";*/
import Mailer from "./components/AnnouncementPalet/SendEmail/Mailer";


class App extends React.Component {
  

  render() {
   
    return (
      <div className="App">
          <Mailer/>
        


        
      </div>
    );
  }
}


export default App;