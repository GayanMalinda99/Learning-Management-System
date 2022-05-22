import StudentView from "../Marks/StudentView";
import LecturerView from "../Marks/LecturerView";

const Mark = () => {
  let member = sessionStorage.getItem("roll");
  let comp;

  if (member == "LEC") {
    comp = (
      <div className="row">
        <div className="col-4"></div>
        <div className="col-8">
          <LecturerView />
        </div>
      </div>
    );
  } else {
    comp = <StudentView />;
  }
  return (
    <div className="container-fluid">
      <br />
      {comp}
    </div>
  );
};

export default Mark;
