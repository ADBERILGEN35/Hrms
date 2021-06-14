import axios from "axios";

export default class EmployerService {
    getEmployers() {
        return axios.get("http://localhost:8080/api/employer/getall");
    }


    getEmployerById(id) {
        return axios.get("http://localhost:8080/api/employer/getById?id=" + id)
    }



}
