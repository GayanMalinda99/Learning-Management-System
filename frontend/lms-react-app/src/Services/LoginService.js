import axios from "axios";
class LoginService {
  getLoginInfo(id) {
    const API_BASE_REST_API_URL_4 = "http://localhost:8080/api/v1/marks/" + id;
    return axios.get(API_BASE_REST_API_URL_4);
  }
}
export default new LoginService();
