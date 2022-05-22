import axios from "axios";
const API_BASE_REST_API_URL = "http://localhost:8080/api/v1/announcement";

class AnnouncemrntService {
  getEnroledStudent() {
    return axios.get(API_BASE_REST_API_URL);
  }
  sendAnnouncement(announcement) {
    return axios.post(API_BASE_REST_API_URL, announcement);
  }
  getAnnouncement(student_id) {
    const API_BASE_REST_API_URL_2 =
      "http://localhost:8080/api/v1/announcement/" + student_id;
    return axios.get(API_BASE_REST_API_URL_2);
  }
}
export default new AnnouncemrntService();