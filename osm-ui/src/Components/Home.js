
import React from "react";
import { Nav, Navbar, NavDropdown, Button, Form, Container,FormControl } from 'react-bootstrap';


import IMAGE8 from '../Images/image8.jpg';
import IMAGE9 from '../Images/image9.jpg';
// import './home.css'
import { useLocation } from "react-router-dom";

const Home = () => {
  const userdata = useLocation();

  return (
    <div className="aa">
      <Navbar bg="light" expand="lg">
        <Container fluid>
          <Navbar.Brand href="/home">Customer Home</Navbar.Brand>
          <Navbar.Toggle aria-controls="navbarScroll" />
          <Navbar.Collapse id="navbarScroll">
            <Nav
              className="me-auto my-2 my-lg-0"
              style={{ maxHeight: '100px' }}
              navbarScroll
            >
              <NavDropdown title="Sweet_Products" id="navbarScrollingDropdown">
                <NavDropdown.Item href="/Products">Ghee Sweets</NavDropdown.Item>
                <NavDropdown.Item href="/Products">Jamun</NavDropdown.Item>
                <NavDropdown.Item href="/Products">Milk Sweets</NavDropdown.Item>
                <NavDropdown.Item href="/Products">Halwas</NavDropdown.Item>
                <NavDropdown.Item href="/Products">Ladoos</NavDropdown.Item>
                <NavDropdown.Item href="/Products">Dry Nut Seets</NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action5">
                  Other Sweets
                </NavDropdown.Item>
              </NavDropdown>
              <Nav.Link href="#action2">Offers</Nav.Link>
              <Nav.Link href="#action2">About us</Nav.Link>
              <Nav.Link href="#action2">Go to Cart</Nav.Link>
              <NavDropdown title="Profile" id="navbarScrollingDropdown">
                <NavDropdown.Item href="#action3">Update profile</NavDropdown.Item>
                <NavDropdown.Item href="/">Logout</NavDropdown.Item>
                <NavDropdown.Item href="/">Settings</NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action5">
                  Need help...contact here
                </NavDropdown.Item>
              </NavDropdown>
              
            </Nav>
            <Form className="d-flex">
              <FormControl
                type="search"
                placeholder="Search"
                className="me-2"
                aria-label="Search"
              />
              <Button variant="outline-success">Search</Button>
            </Form>
          </Navbar.Collapse>
        </Container>
      </Navbar><br />
      <h4> Welcome {userdata.nm.username} ...!</h4>

      <img src={IMAGE9} alt="Nature" className="fluid"></img>


      <img src={IMAGE8} alt="Nature" className="fluid"></img>
    </div>

  );
};

export default Home;