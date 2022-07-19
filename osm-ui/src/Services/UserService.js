import axios from "axios";

const USERS_API_BASE_URL="http://localhost:8084/api/auth/signup"
const USERSS_API_BASE_URL="http://localhost:8084/users/allusers"

class UserService{
    addUser(user){
        return axios.post( USERS_API_BASE_URL,user);
    }
    getUsers(user){
        return axios.get( USERSS_API_BASE_URL,user);
    }
}
export default new UserService();