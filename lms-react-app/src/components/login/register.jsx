import React from "react";
import loginImg from "../../login.svg";

export class Register extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="base-container" ref={this.props.containerRef}>
         <div className="header">_</div>
         <div className="header">_</div>
        <div className="header">Register</div>
        <div className="content">
          <div className="image">
            <img src={loginImg} />
          </div>
          <div className="form">
           
          <div className="form-group">
              <label htmlFor="email">Email</label>
              <input type="text" name="email" placeholder="Student or Lecturer Email" />
            </div>
           
            <div className="form-group">
              <label htmlFor="username">First Name</label>
              <input type="text" name="username" placeholder="First Name" />
            </div>
            

            <div className="form-group">
              <label htmlFor="username">Last Name</label>
              <input type="text" name="username" placeholder="Last Name" />
            </div>
            

            <div className="form-group">
              <label htmlFor="password">Password</label>
              <input type="text" name="password" placeholder="Password" />
            </div>
          </div>
        </div>
        <div className="footer">
          <button type="button" className="btn">
            Register
          </button>
        </div>
      </div>
    );
  }
}