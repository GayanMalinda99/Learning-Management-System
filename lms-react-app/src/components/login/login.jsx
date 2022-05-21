import React from "react";
import loginImg from "../../login.svg";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import Alert from '@mui/material/Alert';
import Stack from '@mui/material/Stack';

export class Login extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      email: "",
      userPassword: "",
    };
    this.state = {
      alert: false,
    }
    
  }
  changeHandler = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  submitHandler = (e) => {
    e.preventDefault();
    console.log(this.state);
    axios
    .post('login',this.state)
    .then(response=>{
        console.log(response);
        localStorage.setItem("token",response.data.token);
        // alert("Login Success!!");
        this.setState({alert:!this.state.alert})
    })
    .catch(error=>{
      console.log(error)
    })


  };




  render() {
    const { email, userPassword } = this.state;
    let a = this.state.alert;
    return (
      <div className="base-container" ref={this.props.containerRef}>

        {a&&(<Stack sx={{ width: '100%' }} spacing={2}>
          <Alert severity="success">Login Success!!</Alert>
        </Stack>)}

            <div className="header">Login</div>
        <div className="content">  
          <div className="image"><img src={loginImg} /> </div>
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
