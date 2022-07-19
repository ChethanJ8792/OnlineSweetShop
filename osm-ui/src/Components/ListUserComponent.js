import React,{useEffect, useState} from 'react';
import {Nav, Navbar, NavDropdown, Button, Form, Container, FormControl} from 'react-bootstrap';
import UserService from '../Services/UserService';

const ListUserComponent= ()=> {
    const [users, setUsers] = useState([])        //to state into functional component
    //To fetch data
 useEffect (()=>{ 
     UserService.getUsers().then((response)=>{
         setUsers(response.data)
     }).catch(error => {
         console.log(error)
     })
 },[])


return (
    <div>
        <Navbar bg="light" expand="lg">
  <Container fluid>
    <Navbar.Brand href="#action4">Admin Home</Navbar.Brand>
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
</Navbar><br/>
              <div className='conatiner'>
                  <h2 className='text-center'>User List</h2>
                  <table className="table table-bordered tabel-striped ">
                  <thead>
                    <th>User Id</th>
                    <th>User Name</th>
                    <th>Password</th>
                    <th>Password confirm</th>
                    <th>Email</th>
                    <th>Type</th>
                    
                    </thead>
                    <tbody>

                        { 
                        users.map (

                                  user => 
                                  <tr key={user.userId}>
                                  <td>{user.userId}</td>
                                  <td>{user.username}</td>
                                  <td>{user.password}</td>
                                  <td>{user.passwordConfirm}</td>
                                  <td>{user.email}</td>
                                  <td>{user.type}</td>
                                  </tr>
                                  )
                              }
                      
                         </tbody>
                     </table>
                      
           </div>
      </div>
);
};
export default ListUserComponent
