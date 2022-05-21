import { useState } from "react";
import AnnouncemrntService from "../../Services/AnnouncemrntService";

const AddAnnouncement = () => {
  const [announcement, setAnnouncement] = useState("");
  const date = Date();
  const [course_code, setCourse_code] = useState("");

  const saveAnnouncement = (e) => {
    e.preventDefault();
    const announcementTable = { announcement, date, course_code };
    console.log(announcementTable);
    AnnouncemrntService.sendAnnouncement(announcementTable)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  return (
    <div className="col-8">
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3">
            <h2 className="text-center">Create Announcement</h2>
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
                    onChange={(e) => setCourse_code(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">STUDENT ID:</label>
                  <textarea
                    className="form-control"
                    id="exampleFormControlTextarea1"
                    rows="3"
                    value={announcement}
                    onChange={(e) => setAnnouncement(e.target.value)}
                  ></textarea>
                </div>

                <button
                  className="btn btn-primary"
                  onClick={(e) => {
                    saveAnnouncement(e);
                    alert("Announcement Sent");
                  }}
                >
                  Send
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddAnnouncement;
