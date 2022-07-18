import React,{Component} from "react";

class HeaderComponent extends Component{
    constructor(props) {
        super(props);
        this.state = {  };
    }
    render() {
        return (
            <div>
                   <header>
                   <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                   <div>
                   <a href="https://Techmasters.com" className="navbar-brand">Online Sweet Shop
                   
                   </a>
                   
                   </div>
                   </nav>
                   
                   </header>
            </div>
            
        );
    }
}

export default HeaderComponent;