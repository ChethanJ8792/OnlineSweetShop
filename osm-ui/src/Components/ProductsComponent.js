import React,{Component} from "react";

import IMAGE17 from '../Images/image17.jpg';
import IMAGE5 from '../Images/image5.jpg';
import IMAGE6 from '../Images/image6.jpg';
import IMAGE14 from '../Images/image14.jpg';
import { Card, Button,Nav,NavDropdown,Form,FormControl,Navbar,Container} from 'react-bootstrap';
import './Products.css'

class ProductsComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {  };
    }
    render() {
        return (
       <div>
            <Navbar bg="light" expand="lg">
        <Container fluid>
          <Navbar.Brand href="#action2">Customer Home</Navbar.Brand>
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
      <h1>Sweet Poducts</h1><br/>

        <div style={{ display: 'flex' }} >
            <div>
          <Card style={{ width: '19rem' }}>
        
  <Card.Img variant="top" src={IMAGE14} />
  <Card.Body>
    <Card.Title>Mysur Pak</Card.Title>
    <Card.Text>
    Mysore pak recipe is a super delicious and a popular sweet from mysore. 
    It is made with just three main ingredients – besan, ghee and sugar. 
    </Card.Text>
    <Button variant="primary">Add to cart</Button>
  </Card.Body>
  
</Card>
</div>

<div>
<Card  style={{ width: '19rem' }}>
        
  <Card.Img  variant="top" src={IMAGE17} />
  <Card.Body>
    <Card.Title>Ghee Ladoo</Card.Title>
    <Card.Text>
    Rava laddus are made from toasted wheat semolina, which imparts a delicious nutty flavor.
     Just like besan laddus.
    </Card.Text>
    <Button variant="primary">Add to cart</Button>
  </Card.Body>
  
</Card>
</div>
<div>
<Card  style={{ width: '19rem' }}>
        
  <Card.Img variant="top" src={IMAGE5} />
  <Card.Body>
    <Card.Title>Rasgula</Card.Title>
    <Card.Text>
    A melt in the mouth soft and spongy cheese balls in light and sweet mild  flavored  syrup. 
    Its a traditional and easy to make Bengali sweet.
    </Card.Text>
    <Button variant="primary">Add to cart</Button>
  </Card.Body>
  
</Card>
</div>
<div>
<Card  style={{ width: '19rem' }}>
        
  <Card.Img variant="top" src={IMAGE6} />
  <Card.Body>
    <Card.Title>Dry Fruit Burfi</Card.Title>
    <Card.Text>
   Barfi or burfi is a basic fudge from
    Indian cuisine that is made using full fat milk(condensing milk for several hours), sugar and ghee and dryfruits.
  
    </Card.Text>
    <Button variant="primary">Add to cart</Button>
  </Card.Body>
  
</Card>
</div>

      </div>
      </div>
        );
    }
}

export default ProductsComponent;