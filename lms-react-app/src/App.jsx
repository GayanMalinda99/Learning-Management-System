import { Announcement } from "@mui/icons-material";
import React from "react";
//'import { Router } from "react-router";
import "./App.scss";
import { Login, Register } from "./components/login/index";
import AddCourse from "./components/course/AddCourse";
import ResponsiveAppBar from "./components/dashboard/LecturerDashboard";
import ViewCourses from "./components/course/ViewCourses";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Panel from "./components/AnnouncementPalet/Panel";
import Mailer from "./components/AnnouncementPalet/SendEmail/Mailer";

class App extends React.Component {
  render() {
    return (
      <div className="App">
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
