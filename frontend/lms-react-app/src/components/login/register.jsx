import React from "react";
import loginImg from "../../login.svg";
import axios from "axios";
import Alert from '@mui/material/Alert';
import Stack from '@mui/material/Stack';

export class Register extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      firstName: "",
      lastName: "",
      email: "",
      password: "",
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
    .post(`registration/`,this.state)
    .then(response=>{
        console.log(response);
        // alert("Registration Success!!");
        this.setState({alert:!this.state.alert})
    })
    .catch(error=>{
      console.log(error)
    })


  };

  render() {
    const { firstName, lastName, email, password } = this.state;
    let a = this.state.alert;
    return (
      <div className="base-container" ref={this.props.containerRef}>
        {a&&(<Stack sx={{ width: '100%' }} spacing={2}>
          <Alert severity="success">Registration Success!!</Alert>
        </Stack>)}
        <div className="header">Register</div>
        <div className="content">
          <div className="image">
            <img src={loginImg} />
          </div>
          <form onSubmit={this.submitHandler} action="" method="post">
            <div className="form">
              <div className="form-group">
                <label htmlFor="username">First Name</label>
                <input
                  type="text"
                  name="firstName"
                  placeholder="First Name"
                  value={firstName}
                  onChange={this.changeHandler}
                />
              </div>

              <div className="form-group">
                <label htmlFor="username">Last Name</label>
                <input
                  type="text"
                  name="lastName"
                  placeholder="Last Name"
                  value={lastName}
                  onChange={this.changeHandler}
                />
              </div>

              <div className="form-group">
                <label htmlFor="email">Email</label>
                <input
                  type="text"
                  name="email"
                  placeholder="Student or Lecturer Email"
                  value={email}
                  onChange={this.changeHandler}
                />
              </div>

              <div className="form-group">
                <label htmlFor="password">Password</label>
                <input
                  type="password"
                  name="password"
                  placeholder="Password"
                  value={password}
                  onChange={this.changeHandler}
                />
              </div>
            </div>
            <div className="footer">
              <button type="submit" className="btn">
                Register
              </button>
            </div>
          </form>
        </div>
      </div>
    );
  }
}