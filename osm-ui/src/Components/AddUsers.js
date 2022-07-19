// import react from "react";
import React, { useState, useEffect } from "react";
import { useHistory } from 'react-router-dom';
import UserService from "../Services/UserService";
import {  Link } from "react-router-dom";

const AddUsers = () => {
    //to add state into functional component
    const [username, setUserName] = useState('')
    const [password, setPassword] = useState('')
   // const [passwordConfirm, setPasswordConfirm] = useState('')
    const [email, setEmail] = useState('')
    const [role, setRole] = useState("User","Admin")
    const history = useHistory();
    const [database, setDatabase] = useState([]);

 //to fetch data
    useEffect (()=>{
        UserService.getUsers().then((res)=>{
            setDatabase(res.data)
        }).catch(error => {
            console.log(error)
        })
    },[])
 
    //  to prevent default action
    const saveUser = (e) => {
        e.preventDefault();

        let validuser = database.find((user) => user.username === username);

        if (validuser) {
            alert('User Name already Available')
            history.push('/Register')
        } else if (password == null) {
            alert("Password  is null ")
            history.push('/Register')
        } else {
            const user = { username, password, email,role }
            UserService.addUser(user).then((response) => {
                console.log(response.data)
                history.push('/login')
            }).catch(error => {
                console.log(error)
            })
        }
    }
    
    return (
        //code to Register form 
        <div className="container">
            <h1>Create Account</h1>
            <div className="row">
                <div className="card bg-dark text-green">
                    <h2 className="text-center text-light">Sign Up</h2>
                    <div className="card-body">
                        <form onSubmit={(e) => saveUser(e)}>
                            <div className="form-group mb-2">
                                <label className="form-label text-light">User Name :</label>
                                <input
                                    type="text"
                                    placeholder="enter the username"
                                    name="username"
                                    className='form-control'
                                    value={username}
                                    onChange={(e) => setUserName(e.target.value)}
                                    required
                                />
                                <label className="form-label text-light">Password :</label>
                                <input
                                    type="password"
                                    placeholder="enter the password"
                                    name="password"
                                    className='form-control'
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}
                                    required
                                />
                                {/* <label className="form-label">Password Confirm:</label>
                                <input
                                    type="password"
                                    placeholder="Re-enter the password"
                                    name="passwordConfirm"
                                    className='form-control'
                                    value={passwordConfirm}
                                    onChange={(e) => setPasswordConfirm(e.target.value)}
                                    required
                                /> */}
                                <label className="form-label text-light">Email :</label>
                                <input
                                    type="email"
                                    placeholder="enter the email"
                                    name="email"
                                    className='form-control'
                                    value={email}
                                    onChange={(e) => setEmail(e.target.value)}
                                    required
                                />
                                <label className="form-label text-light">Type of User:</label>
                                <select name="type" id="" className='form-control' onChange={(e) => setRole(e.target.value)} >
                                    <option  value="User"  >Customer</option>
                                    <option value="Admin" >Admin</option>
                                </select>
                             
                            </div>
                            <button type="submit" value="Submit" className="btn btn-success"  >Submit</button>
                            <Link to="/login"> !..Already a User ? please click to sign in...!</Link>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    )
}
export default AddUsers;