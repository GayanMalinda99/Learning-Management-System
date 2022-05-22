import LoginService from "../../Services/LoginService";

class GetLoginInfo {
  getLoginInfo() {
    const email = sessionStorage.getItem("email");

    LoginService.getLoginInfo(email)
      .then((respons) => {
        let appUser = respons.data.id;
        sessionStorage.setItem("appUser", appUser);
      })
      .catch((error) => {
        console.log(error);
      });
  }
}
export default new GetLoginInfo();
