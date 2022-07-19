import React,{Component} from "react";

class HeaderComponent extends Component{
    constructor(props) {
        super(props);
        this.state = {  };
    }
    render() {
        return (
            <div className="container">
                   <header>
                   <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                   <div className="container">
                   <a href="https://OnlineSweetShop.com" className="navbar-brand">Online Sweet Shop</a>
                   </div>
                   </nav>
                   </header>
            </div>
 
        );
    }
}

export default HeaderComponent;