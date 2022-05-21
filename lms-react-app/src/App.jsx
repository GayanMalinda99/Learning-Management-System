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
import EntryPage from "./components/login/EntryPage";
import Dashboard from "./components/dashboard/DashBoard";
import RequiredAuth from "./components/RequireAuth"

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <Routes>
            <Route exact path="/" element={<EntryPage/>} />
            <Route exact path="/dashboard" element={<Dashboard />} />
            <Route element={<RequiredAuth />}> 
              
              <Route exact path="/course" element={<AddCourse />} />
              <Route exact path="/announcement" element={<Panel />} />
            </Route>
        </Routes>
      </div>
    );
  }
}

export default App;
