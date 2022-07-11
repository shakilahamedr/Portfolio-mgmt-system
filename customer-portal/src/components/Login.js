import "bootstrap/dist/css/bootstrap.css";
import {Button} from "react-bootstrap";
import axios from "axios";
import {useRef, useState} from "react";
import {Redirect} from "react-router-dom";
import { useJwtContext } from "../hooks/useJwtContext";

const Login = (props) => {
  const [submitStatus, setSubmitStatus] = useState(false);
  const [error, setError] = useState(null);

  const usernameInputRef = useRef();
  const passwordInputRef = useRef();

  const {dispatch} = useJwtContext()

  const callViewAsset = async (event) => {
    event.preventDefault();
    
    const user = {
      username : usernameInputRef.current.value,
      password : passwordInputRef.current.value
    };
    let response = await axios.post(
      "http://pod2-lb-800533877.eu-central-1.elb.amazonaws.com:8081/getToken",
      user
    ).catch(err=>{
      console.log(err.message)
      setError("Wrong username/password");
    });
    if(response.status===200) {
    // console.log(response);
    // console.log(user);
    // console.log(response.data.jwttoken);
    setError(null);
    dispatch({type: 'SET_JWT', payload: response.data.jwttoken})
    setSubmitStatus(true);
    }
  };
  if(submitStatus) {
    return <Redirect to ="/viewAsset" />;
  }
  
  return ( 
    <div className="container-fluid">
      <div className="col-md-12">
      <center>
      <h3 className="text-primary">Login</h3>
      <form onSubmit={callViewAsset}>
        <div className="form-group col-3">
          <label className="fw-bold ">UserName</label>
          <input
              type="text"
              name="username"
              required
              className="form-control"
              ref={usernameInputRef}
              />
        </div>
        <br />
        <div className="form-group col-3">
          <label className="fw-bold">Password</label>
          <input
              type="password"
              name="password"
              required
              className="form-control"
              ref={passwordInputRef}
              />
        </div>
        <br />
        <Button type="submit" >Submit</Button>
      </form>
      <br/>
      <div>
        {error &&<p class="alert alert-danger" role="alert">{error}</p>}
      </div>
      </center>
    </div>
    </div>
    );
};
 
export default Login;