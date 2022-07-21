import React, { useState, useEffect } from "react";
import {Link} from "react-router-dom"

import UserService from "../services/user.service";

const Home = () => {
  const [content, setContent] = useState("");

  useEffect(() => {
    UserService.getPublicContent().then(
      (response) => {
        setContent(response.data);
      },
      (error) => {
        const _content =
          (error.response && error.response.data) ||
          error.message ||
          error.toString();

        setContent(_content);
      }
    );
  }, []);

  return (
    <div className="container">
      <header className="jumbotron">
        <h3>{content}</h3>
        <Link className="btn btn-outline-light" to="/addproduct">Add Product</Link>
      </header>
    </div>
  );
};

export default Home;