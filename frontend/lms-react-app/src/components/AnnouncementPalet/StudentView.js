import { useEffect, useState } from "react";
import AnnouncemrntService from "../../Services/AnnouncemrntService";
import LoginService from "../../Services/LoginService";
import GetLoginInfo from "../login/GetLoginInfo";

const StudentView = () => {
  GetLoginInfo.getLoginInfo();

  //console.log(sessionStorage.getItem("appUser"));

  const student_id = sessionStorage.getItem("appUser");
  const [announcements, setAnnouncements] = useState([]);
  useEffect(() => {
    AnnouncemrntService.getAnnouncement(student_id)
      .then((respons) => {
        setAnnouncements(respons.data);
        console.log(respons.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);
  return (
    <div className="container">
      <h2 className="text-center">Announcement History</h2>
      <table className="table table-bordered table-striped">
        <thead>
          <th>Announcement</th>
          <th>Date</th>
          <th>Course Code</th>
        </thead>
        <tbody>
          {announcements.map((announcements) => (
            <tr>
              <td>{announcements.announcement}</td>
              <td>{announcements.date}</td>
              <td>{announcements.course_code}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default StudentView;
