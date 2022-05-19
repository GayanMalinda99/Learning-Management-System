import React from "react";
import AddAnnouncement from "./AddAnnouncement";
import GetStudent from "./GetStudent";

function Panal() {
  return (
    <div className="container-fluid col-12">
      <br />
      <div className="row">
        <div className="p-3 mb-2 bg-primary bg-gradient text-white">
          <h1 className="display-4">SENG 12345</h1>
        </div>
      </div>
      <div className="row">
        <AddAnnouncement />
        <div className="col-3">
          <GetStudent />
        </div>
      </div>
    </div>
  );
}
export default Panal;
