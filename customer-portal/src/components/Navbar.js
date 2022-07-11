import { Link } from "react-router-dom";

const Navbar = () => {
    return ( 
      <div className="homie">
      <nav className="navbar">
        <h1 className="head">Portfolio Management System</h1>
        <div className="links">
            <Link to= "/">Home</Link>
            <Link to="/login">Login</Link>
        </div>
      </nav> 
      </div>
    );
}
 
export default Navbar;