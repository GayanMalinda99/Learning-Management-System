import { useState, useEffect } from "react";
import MarksService from "../../Services/MarksService";
import GetLoginInfo from "../login/GetLoginInfo";

const StudentView = () => {
  GetLoginInfo.getLoginInfo();

  //console.log(sessionStorage.getItem("appUser"));

  const student_id = sessionStorage.getItem("appUser");
  const [marks, setMarks] = useState([]);
  useEffect(() => {
    MarksService.getMarks(student_id)
      .then((respons) => {
        setMarks(respons.data);
        console.log(respons.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);
  return (
    <div className="container">
      <h2 className="text-center">MARK SHEET</h2>
      <table className="table table-bordered table-striped">
        <thead>
          <th>COURSE CODE</th>
          <th>MARKS</th>
        </thead>
        <tbody>
          {marks.map((marks) => (
            <tr>
              <td>{marks.course_code}</td>
              <td>{marks.marks}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
export default StudentView;
