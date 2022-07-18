import React,{Component} from 'react';
import UserService from '../Services/UserService';


export class CreateUserComponent extends Component{
  

    constructor(props){
       
        super(props)
        this.state={
                username:'',
                password:'',
                passwordConfirm:'',
                email:'',
                type:''
         }
         this.changeUserNameHandler=this.changeUserNameHandler.bind(this)
         this.changePasswordHandler=this.changePasswordHandler.bind(this)
         this.changePasswordConfirmHandle=this.changePasswordConfirmHandle.bind(this)
         this.changeEmailHandler=this.changeEmailHandler.bind(this)
         this.changeTypeHandler=this.changeTypeHandler.bind(this)
     }
     saveUser=(e)=>{
        e.preventDefault()
        let user={
            username:this.state.username,
            password:this.state.password,
            passwordConfirm:this.state.passwordConfirm,
            email:this.state.email,
            type:this.state.type
        }
         console.log('user =>'+JSON.stringify(user))
         if(this.state.password !== this.state.passwordConfirm){
             alert('Password mismatch')
            this.props.history.push('/addUser')
         }else{
            UserService.addUser(user).then( (response) =>{
                this.props.history.push('/login')
            })
         }
         
    }
   
   
        changeUserNameHandler(event){
            this.setState({username: event.target.value});
            
        }
        changePasswordHandler(event){
            this.setState({password: event.target.value})
        }
        changePasswordConfirmHandle(event){
            this.setState({passwordConfirm: event.target.value})
            // if(event.changePasswordConfirmHandle !==event.changePasswordHandler){
            //     message.error("password don't match")
            // }
        }
        changeEmailHandler(event){
            this.setState({email: event.target.value})
        }
        changeTypeHandler(event){
            this.setState({type: event.target.value})
        }
        cancel(){
                    this.props.history.push('/login')
                }
     render(){
         return(
           
            <div>
                <h1>Sign up Form</h1>
                <div className='container'>
                    <div className='row' >
                        <div className='card bg-dark text-white'>
                            <h3 className='text-center'>Sign up</h3>
                            <div className='card-body'>
                                <form onSubmit={this.saveUser}>
                                    <div className='form-group'>
                                        <label>User Name</label>
                                        <input placeholder='User Name' name='username' className='form-control' value={this.state.username} onChange={this.changeUserNameHandler} required/>
                                    </div>
                                    <div className='form-group'>
                                        <label>Password</label>
                                        <input type="password"  placeholder='Password' name='password' className='form-control' value={this.state.password} onChange={this.changePasswordHandler} required/>
                                    </div>
                                    <div className='form-group'>
                                        <label>Password Confirm</label>
                                        <input type="password" placeholder='Password Confirm' name='passwordConfirm' className='form-control' value={this.state.passwordConfirm} onChange={this.changePasswordConfirmHandle} required/>
                                    </div>
                                    <div className='form-group'>
                                        <label>Email</label>
                                        <input placeholder='Email' name='email' className='form-control' value={this.state.email} onChange={this.changeEmailHandler} required/>
                                    </div>
                                    <div className='form-group'>
                                        <label>Type</label>
                                        <select name="type" id="" className='form-control' onChange={this.changeTypeHandler} >
                                            <option  value="User" onChange={this.changeTypeHandler }>User</option>
                                            <option value="Admin"onChange={this.changeTypeHandler}>Admin</option>
                                        </select>
                                        {/* <input placeholder='Type' name='email' className='form-control' value={this.state.type} onChange={this.changeTypeHandler}/> */}
                                        
                                    </div><br/>
                                    <input type="submit" value="Submit" className='btn btn-success' />
                                    <button className='btn btn-secondary' onClick={this.cancel.bind(this)}
                                    style={{marginLeft:"10px"}}>Already a user? please sign in!!</button>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
         );
     }


    }

   
    export default CreateUserComponent;