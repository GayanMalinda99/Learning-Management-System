//const email=sessionStorage.getItem('email');
function findRoll(email) {
  if (email.includes("@lec")) {
    sessionStorage.setItem("roll", "LEC");
  } else if (email.includes("@stu")) {
    sessionStorage.setItem("roll", "STU");
  }
}
export default findRoll;
