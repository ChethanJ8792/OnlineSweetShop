import logo from './logo.svg';
import './App.css';
import HeaderComponent from './Components/HeaderComponent';
import LoginComponent from './Components/LoginComponent';
import Home from './Components/Home';
import AdminHome from './Components/AdminHome';
import AddUsers from './Components/AddUsers';
import ListUserComponent from './Components/ListUserComponent';
import ProductsComponent from './Components/ProductsComponent';
import AdminProduct from './Components/AdminProduct';

function App() {
  {
    return (
      
        <Router>     
          <div className='container'>
            <HeaderComponent/>
            <div className='container'>
              <Switch>
              <Route exact path="/"  component={LoginComponent}></Route>
                <Route path="/home" component={Home}></Route>
                <Route path="/adminhome" component={AdminHome}></Route>
                <Route path="/Register"  component={AddUsers}></Route>
                <Route  path="/list"  component={ListUserComponent}></Route>
                <Route  path="/Products"  component={ProductsComponent}></Route>
                <Route  path="/AdminProducts"  component={AdminProduct}></Route>
                <Route ><LoginComponent/></Route>
              </Switch>
            </div>
            <FooterComponent/>
          </div>
        </Router>
      
    );
  }
}export default App;
