import axios from "axios";
const API_BASE_REST_API_URL = "http://localhost:8080/api/v1/announcement";

class AnnouncemrntService {
  getEnroledStudent() {
    return axios.get(API_BASE_REST_API_URL);
  }
  sendAnnouncement(announcement) {
    return axios.post(API_BASE_REST_API_URL, announcement);
  }
}
export default new AnnouncemrntService();
