import axios from "axios";
const API_BASE_REST_API_URL_3 = "http://localhost:8080/api/v1/marks";
class MarksService {
  setMarks(marks) {
    return axios.post(API_BASE_REST_API_URL_3, marks);
  }
  getMarks(id) {
    const API_BASE_REST_API_URL_4 = "http://localhost:8080/api/v1/marks/" + id;
    return axios.get(API_BASE_REST_API_URL_4);
  }
}
export default new MarksService();
