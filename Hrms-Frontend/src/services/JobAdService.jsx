
import axios from "axios";

export default class JobAdService {
    getActiveJobAds() {
        return axios.get("http://localhost:8080/api/jobadvertisement/getActiveJobAdvertisement");
    }


}