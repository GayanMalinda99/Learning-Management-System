import React from "react";
import AddAnnouncement from "./AddAnnouncement";
import GetStudent from "./GetStudent";
import StudentView from "./StudentView";

function Panal() {
  let member = "STUDENT";
  let component;

  if (member == "STUDENT") {
    component = (
      <div>
        <StudentView />
      </div>
    );
  } else {
    component = (
      <div className="row">
        <div className="col-4"></div>
        <AddAnnouncement />
      </div>
    );
  }
  return (
    <div className="container-fluid col-12">
      <br />
      <div className="row">
        <div className="p-3 mb-2 bg-primary bg-gradient text-white">
          <h1 className="display-4 text-center">ANNOUNCEMENTS</h1>
        </div>
      </div>
      {component}
    </div>
  );
}
export default Panal;
