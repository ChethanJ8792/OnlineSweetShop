import axios from "axios";

const USERS_API_BASE_URL="http://localhost:8096/onlinesweetmart-user/adduser"
const USERSS_API_BASE_URL="http://localhost:8096/onlinesweetmart-user/getusers/all"

class UserService{
    addUser(user){
        return axios.post( USERS_API_BASE_URL,user);
    }
    getUsers(user){
        return axios.get( USERSS_API_BASE_URL,user);
    }
  
    
}
export default new UserService();