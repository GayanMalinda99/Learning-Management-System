import React from "react";
import "./App.scss";
import { Login, Register } from "./components/login/index";

import ResponsiveAppBar from "./components/dashboard/ResposiveAppBar";
import ViewCourses from "./components/course/ViewCourses";
import AddCourse from "./components/course/AddCourse";
import { Routes, Route} from "react-router";
import Panel from "./components/AnnouncementPalet/Panel";
import EntryPage from "./components/login/EntryPage";
import Dashboard from "./components/dashboard/DashBoard";

class App extends React.Component {
  

  render() {
   
    return (
      <div className="App">
        <Routes>
          <Route exact path="/" element={<EntryPage/>} />
          <Route exact path="/dashboard" element={<Dashboard/>} />
          <Route exact path="/course" element={<AddCourse />} />
          <Route exact path="/announcement" element={<Panel />} />
        </Routes>
      </div>
    );
  }
}


export default App;