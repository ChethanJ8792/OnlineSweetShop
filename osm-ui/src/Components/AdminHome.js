
import React from "react";
import { Nav, Navbar, NavDropdown,  Button, Form, Container, FormControl } from 'react-bootstrap';
import IMAGE8 from '../Images/image8.jpg';
import IMAGE9 from '../Images/image9.jpg';
import { useLocation } from "react-router-dom";
import  bootstrap from 'bootstrap/dist/css/bootstrap.css';



const AdminHome = props => {

  const userdata = useLocation();
  return (
    <div>
      <Navbar bg="light" expand="lg">
        <Container fluid>
          <Navbar.Brand href="/adminhome">Admin Home</Navbar.Brand>
          <Navbar.Toggle aria-controls="navbarScroll" />
          <Navbar.Collapse id="navbarScroll">
            <Nav
              className="me-auto my-2 my-lg-0"
              style={{ maxHeight: '100px' }}
              navbarScroll
            >
              <NavDropdown title="Add Sweet Products" id="navbarScrollingDropdown">
                <NavDropdown.Item href="/AdminProducts">Ghee Sweets</NavDropdown.Item>
                <NavDropdown.Item href="/AdminProducts">Jamun</NavDropdown.Item>
                <NavDropdown.Item href="/AdminProducts">Milk Sweets</NavDropdown.Item>
                <NavDropdown.Item href="/AdminProducts">Halwas</NavDropdown.Item>
                <NavDropdown.Item href="/AdminProducts">Ladoos</NavDropdown.Item>
                <NavDropdown.Item href="/AdminProducts">Dry Nut Seets</NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action5">
                  Other Sweets
                </NavDropdown.Item>
              </NavDropdown>
              <Nav.Link href="#action2">ADD_Offfers</Nav.Link>

              <Nav.Link href="/list"  >
                View Users
              </Nav.Link>
           
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

export default AdminHome;