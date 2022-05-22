import React from "react";
import loginImg from "../../login.svg";
import axios from "axios";
import { Navigate } from "react-router-dom";
import Alert from "@mui/material/Alert";
import Stack from "@mui/material/Stack";
import findRoll from "../../Services/findRoll";

export class Login extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      email: "",
      userPassword: "",
    };
    this.state = {
      alert: false,
    };
    this.state = {
      isStudentLoggedIn: false,
      isLecturerLoggedIn: false,
    };
  }
  changeHandler = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  submitHandler = (e) => {
    e.preventDefault();
    console.log(this.state);
    axios
      .post("login", this.state)
      .then((response) => {
        console.log(response);
        localStorage.setItem("token", response.data.token);
        localStorage.setItem("id", response.data.user.id);
        localStorage.setItem("userName", response.data.user.firstName);
        console.log(response.data.user.firstName);
        // alert("Login Success!!");
        // if(response.data.user.)
        if(response.data.user.appUserRole === 'STUDENT'){
          console.log('stud')
          this.setState({ isStudentLoggedIn: !this.state.isStudentLoggedIn });
        }else{
          this.setState({isLecturerLoggedIn: true})
        }
        this.setState({ alert: !this.state.alert });
      })
      .catch((error) => {
        console.log(error);
      });
  };

  render() {
    const { email, userPassword } = this.state;

    //put email in session storage
    sessionStorage.setItem("email", email);
    const TempEmail = sessionStorage.getItem("email");
    findRoll(TempEmail);

    let a = this.state.alert;
    let isStudentloggedIn = this.state.isStudentLoggedIn;
    let isLecturerLoggedIn = this.state.isLecturerLoggedIn;
    return (
      <div className="base-container" ref={this.props.containerRef}>
        {a && (
          <Stack sx={{ width: "100%" }} spacing={2}>
            <Alert severity="success">Login Success!!</Alert>
          </Stack>
        )}

        <div className="header">Login</div>
        <div className="content">
          <div className="image">
            <img src={loginImg} />{" "}
          </div>
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
        {/* {isStudentloggedIn && navigate('/dashboard')} */}
        {isStudentloggedIn ? <Navigate to="/dashboard" /> : null}
        {isLecturerLoggedIn ? <Navigate to="/lecturer-dashboard" /> : null}
      </div>
    );
  }
}
