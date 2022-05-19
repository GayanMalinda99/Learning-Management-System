import React from "react";
import "./App.scss";
import { Login, Register } from "./components/login/index";
import AddCourse from "./components/course/AddCourse";
import ResponsiveAppBar from "./components/dashboard/LecturerDashboard";
import ViewCourses from "./components/course/ViewCourses";
import { Routes, Route } from "react-router";
import Panel from "./components/AnnouncementPalet/Panel";

class App extends React.Component {
  

  render() {
   
    return (
      <div className="App">
        {}
        <ResponsiveAppBar />
        <Routes>
          <Route path="/dashboard" element={<ViewCourses />} />
          <Route path="/course" element={<AddCourse />} />
          <Route path="/announcement" element={<Panel />} />
        </Routes>
      </div>
    );
  }
}


export default App;