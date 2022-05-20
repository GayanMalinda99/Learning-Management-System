import React from "react";
import loginImg from "../../login.svg";
import axios from "axios";
import {Navigate} from "react-router-dom";

export class Login extends React.Component {
  constructor(props) {
    super(props);



    this.state = {
      email: "",
      userPassword: "",
    };
  }

  state = { user: null, error: null };



  changeHandler = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  submitHandler = (e) => {
    e.preventDefault();
    console.log(this.state);
    axios
    .post('login',this.state)
    .then(response=>{
        console.log(response)
        alert("Login Success!!");
        this.setState({user:response.data.user})
        
    })
    .catch(error=>{
      console.log(error)
    })


  };




  render() {
    const { email, userPassword } = this.state;
    let { user, error } = this.state;
    return (
      
      <div className="base-container" ref={this.props.containerRef}>
            <div className="header">Login</div>
        <div className="content">
          
              <div className="image"><img src={loginImg} /> </div>

        {error && <p>{error.message}</p>}
        {user && (
          <Navigate to="/dashboard" replace={true} />
        )}
          <form onSubmit={this.submitHandler} action="/login" method="post">
            <div className="form">

              <div className="form-group">
                <label htmlFor="username">Email</label>
                <input
                  type="text"
                  name="email"
                  placeholder="Email"
                  value={email}
                  onChange={this.changeHandler}
                />
              </div>

              <div className="form-group">
                <label htmlFor="password">Password</label>
                <input
                  type="password"
                  name="userPassword"
                  placeholder="Password"
                  value={userPassword}
                  onChange={this.changeHandler}
                />
              </div>

              <div className="footer">
                <button type="submit" className="btn">
                  Login
                </button>
              </div>

            </div>
          </form>
        </div>
      </div>
    );
  }
}
