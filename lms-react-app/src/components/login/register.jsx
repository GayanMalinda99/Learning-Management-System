import React from "react";
import loginImg from "../../login.svg";
import axios from "axios";


export class Register extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      firstName: "",
      lastName: "",
      email: "",
      password: "",
    };
  }

  changeHandler = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  submitHandler = (e) => {
    e.preventDefault();
    console.log(this.state);
    axios
    .post('http://localhost:8080/api/v1/registration',this.state)
    .then(response=>{
        console.log(response)
        alert("Registration Successful! Verify Your Email To Login ");
       
        
    })
    .catch(error=>{
      console.log(error)
    })


  };

  render() {
    const { firstName, lastName, email, password } = this.state;

    return (
      <div className="base-container" ref={this.props.containerRef}>
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
                  type="text"
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
