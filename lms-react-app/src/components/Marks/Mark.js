import StudentView from "../Marks/StudentView";
import LecturerView from "../Marks/LecturerView";

const Mark = () => {
  let member = "LE";
  let comp;

  if (member == "LEC") {
    comp = <LecturerView />;
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
