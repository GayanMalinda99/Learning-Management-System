import { useState } from "react";

const AddAnnouncement = () => {
  const [announcement, setAnnouncement] = useState("");

  const saveAnnouncement = (e) => {
    e.preventDefault();
    console.log(announcement);
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
