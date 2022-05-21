import StudentView from "../Marks/StudentView";
import LecturerView from "../Marks/LecturerView";

const Mark = () => {
  let member = "LEC";
  let comp;

  if (member == "LEC") {
    comp = <LecturerView />;
  } else {
    comp = <StudentView />;
  }
  return (
    <div className="container-fluid">
      <br />
      <div className="row">
        <div className="col-4"></div>
        <div className="col-8">{comp}</div>
      </div>
    </div>
  );
};

export default Mark;
