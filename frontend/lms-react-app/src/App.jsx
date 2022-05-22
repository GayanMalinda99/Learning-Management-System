import { Announcement, MarkunreadSharp, Outlet } from "@mui/icons-material";
import React from "react";
//'import { Router } from "react-router";
import "./App.scss";
import { Login, Register } from "./components/login/index";
import AddCourse from "./components/course/AddCourse";
import ResponsiveAppBar from "./components/dashboard/LecturerDashboard";
import ViewCourses from "./components/course/ViewCourses.student";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Panel from "./components/AnnouncementPalet/Panel";
import EntryPage from "./components/login/EntryPage";
import Dashboard from "./components/dashboard/DashBoard";
import RequiredAuth from "./components/RequireAuth";
import Mark from "./components/Marks/Mark";
import findRoll from "./Services/findRoll";
import ViewCourses_lecturer from "./components/course/ViewCourses.lecturer";

class App extends React.Component {
  render() {
    let roll = sessionStorage.getItem("roll");
    let comp;
    if (roll == "LEC") {
      comp = (
        <div>
          <Routes>
            <Route exact path="/" element={<EntryPage />} />

            <Route path="lecturer-dashboard" element={<ResponsiveAppBar />} />
            <Route
              path="add-course"
              element={
                <>
                  <ResponsiveAppBar />
                  <AddCourse />
                </>
              }
            />
            <Route
              path="Course"
              element={
                <>
                  <ResponsiveAppBar /> <ViewCourses_lecturer />
                </>
              }
            />
            <Route
              path="marks"
              element={
                <>
                  <ResponsiveAppBar />
                  <Mark />
                </>
              }
            />
            <Route
              path="announcement"
              element={
                <>
                  <ResponsiveAppBar /> <Panel />
                </>
              }
            />
          </Routes>
        </div>
      );
    } else {
      comp = (
        <div>
          <Routes>
            <Route exact path="/" element={<EntryPage />} />
            <Route path="dashboard" element={<Dashboard />} />

            <Route
              path="Course"
              element={
                <>
                  <Dashboard /> <ViewCourses_lecturer />
                </>
              }
            />
            <Route
              path="marks"
              element={
                <>
                  <Dashboard />
                  <Mark />
                </>
              }
            />
            <Route
              path="announcement"
              element={
                <>
                  <Dashboard /> <Panel />
                </>
              }
            />
          </Routes>
        </div>
      );
    }
    return <div>{comp}</div>;
  }
}

export default App;
