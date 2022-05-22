import { Announcement, MarkunreadSharp, Outlet } from "@mui/icons-material";
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
import RequiredAuth from "./components/RequireAuth";
import Mark from "./components/Marks/Mark";
import findRoll from "./Services/findRoll";

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <Routes>
          <Route exact path="/" element={<EntryPage />} />
          <Route path="dashboard" element={<Dashboard />} />
          <Route path="lecturer-dashboard" element={<ResponsiveAppBar />} />
          <Route path="course" element={<AddCourse />} />
          <Route path="marks" element={<Mark />} />
          <Route path="announcement" element={<Panel />} />
        </Routes>
      </div>
    );
  }
}

export default App;
