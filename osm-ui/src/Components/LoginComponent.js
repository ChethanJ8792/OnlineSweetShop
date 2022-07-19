
import React, { useState, useEffect } from "react";

import "./LoginComponents.css";
import { useHistory } from 'react-router-dom';
import { Link } from "react-router-dom";
import UserService from "../Services/UserService";

export function LoginComponent() {

 // to add state to functional component
  const [errorMessages, setErrorMessages] = useState({});
  const [isSubmitted, setIsSubmitted] = useState(false);
  const [database, setDatabase] = useState([]);
  //to fetch data 
  useEffect(() => {
    UserService.getUsers().then((response) => {
      console.log(response)
      setDatabase(response.data)
    }).catch(error => {
      console.log(error)
    })
  }, [])

    const errors = {
    uname: "invalid username ",
    pass: "invalid  password"

  };
  const handleSubmit = (event) => {
    //Prevent page reload
    event.preventDefault();

    var { uname, pass } = document.forms[0];



    // Find user login info
    const userData = database.find((user) => user.username === uname.value);

  
    var userData1 = '';

    if (userData) {
      if (userData.password == pass.value) {
        setErrorMessages({ name: "pass", message: errors.pass });
      } else {
        if (userData.role == 'Admin') {
          setIsSubmitted(true);
          userData1 = history.push({
            pathname: '/adminhome',     // to push data to admin
            nm: userData,
          });
        } else {

          setIsSubmitted(true);
          userData1 = history.push({     // to push data to Home page
            pathname: '/home',
            nm: userData,
          });
        }
      }
    }
    else {
      setErrorMessages({ name: "uname", message: errors.uname });
    }
  };


  // Generate  code for error message
  const renderErrorMessage = (name) =>
    name === errorMessages.name && (
      <div className="error">{errorMessages.message}</div>
    );

  const history = useHistory();
  //code for login form
  const renderForm = (
    <div className="form container">
      <form onSubmit={handleSubmit}>
        <div className="input-container">
          <label>Username </label>
          <input type="text" name="uname" required />
          {renderErrorMessage("uname")}
        </div>
        <div className="input-container">
          <label>Password </label>
          <input type="password" name="pass" required />
          {renderErrorMessage("pass")}
        </div>
        <div className="button-container">
          <input type="submit" />
        </div>
      </form>
    </div>
  );

  return (

    <div className="app">
      <div className="login-form">
        <div className="title">Sign In</div>
        {
          isSubmitted ? this.userData1 : renderForm
        }
        <Link to="/Register">!...New User ? please click to sign up...!</Link>
      </div>
    </div>
  );
}
export default LoginComponent;