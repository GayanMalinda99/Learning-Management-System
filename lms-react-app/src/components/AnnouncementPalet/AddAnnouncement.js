import { useState } from "react";
import AnnouncemrntService from "../../Services/AnnouncemrntService";

const AddAnnouncement = () => {
  const [announcement, setAnnouncement] = useState("");
  const date = "date";
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
            Create an Announcement
          </button>
        </div>
      </div>

      <div className="collapse" id="collapseExample">
        <div className="card card-body">
          <form>
            <b>Enter Course Code:</b>
            <input
              type="text"
              value={course_code}
              onChange={(e) => setCourse_code(e.target.value)}
            />
            <br />
            <br />
            <textarea
              className="form-control"
              id="exampleFormControlTextarea1"
              rows="3"
              value={announcement}
              onChange={(e) => setAnnouncement(e.target.value)}
            ></textarea>
            <div className="row">
              <button
                className="btn btn-primary"
                onClick={(e) => saveAnnouncement(e)}
              >
                Send
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default AddAnnouncement;
