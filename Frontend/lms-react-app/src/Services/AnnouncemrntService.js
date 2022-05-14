import axios from "axios";
const API_BASE_REST_API_URL = "http://localhost:8080/api/v1/announcement";

class AnnouncemrntService {
  /*getAll() {
    return axios.get(API_BASE_REST_API_URL);
  }*/
  sendAnnouncement() {
    return axios.post(API_BASE_REST_API_URL, employee);
  }
}
export default new AnnouncemrntService();
