import { useEffect } from "react";
import { useState } from "react";
import AnnouncemrntService from "../../Services/AnnouncemrntService";

const GetStudent = () => {
  const [student, setStudent] = useState([]);

  useEffect(() => {
    AnnouncemrntService.getEnroledStudent()
      .then((response) => {
        setStudent(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);
  return (
    <table className="table table-hover">
      <tr>
        <th>Student ID</th>
      </tr>
      {student.map((student) => (
        <tr>
          <td>{student.enrolled_students_id}</td>
        </tr>
      ))}
    </table>
  );
};
export default GetStudent;
