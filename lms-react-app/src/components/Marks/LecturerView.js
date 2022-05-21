import { useState } from "react";

import MarksService from "../../Services/MarksService";

const LecturerView = () => {
  const [course_code, setCourseCode] = useState("");
  const [marks, setMark] = useState();
  const [student_id, setStudentID] = useState();

  const saveEmployee = (e) => {
    e.preventDefault();
    const marksTable = { course_code, marks, student_id };
    console.log(marksTable);
    MarksService.setMarks(marksTable)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  return (
    <div>
      <br />
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3">
            <h2 className="text-center">Add Marks</h2>
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label">COURSE CODE:</label>
                  <input
                    type="text"
                    placeholder="Enter Course Code"
                    name="firstName"
                    className="form-control"
                    value={course_code}
                    onChange={(e) => setCourseCode(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">STUDENT ID:</label>
                  <input
                    type="text"
                    placeholder="Enter Student Id"
                    name="lastName"
                    className="form-control"
                    value={student_id}
                    onChange={(e) => setStudentID(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">MARKS:</label>
                  <input
                    type="text"
                    placeholder="Enter Marks"
                    name="email"
                    className="form-control"
                    value={marks}
                    onChange={(e) => setMark(e.target.value)}
                  ></input>
                </div>
                <button
                  className="btn btn-primary"
                  onClick={(e) => saveEmployee(e)}
                >
                  Submit
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
export default LecturerView;
