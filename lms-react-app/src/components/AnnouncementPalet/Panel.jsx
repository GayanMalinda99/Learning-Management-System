import React from "react";
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
        <div className="col-9">
          <div className="row">
            <div className="col-1">
              <button
                className="btn btn-primary align-start"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#collapseExample"
                aria-expanded="false"
                aria-controls="collapseExample"
              >
                Announcement
              </button>
            </div>
          </div>

          <div className="collapse" id="collapseExample">
            <div className="card card-body">
              <form>
                <textarea
                  className="form-control"
                  id="exampleFormControlTextarea1"
                  rows="3"
                ></textarea>
                <div className="row">
                  <input
                    className="btn btn-primary"
                    type="submit"
                    value="Send"
                  />
                </div>
              </form>
            </div>
          </div>
        </div>
        <div className="col-3">
          <GetStudent />
        </div>
      </div>
    </div>
  );
}
export default Panal;
