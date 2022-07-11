import Login from './components/Login';
import Navbar from './components/Navbar';
import Home from './Home';
import ViewAsset from './components/ViewAsset';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

function App() {
  return (
    <Router>
    <div className="App">
     <Navbar />
     <div className='content'>
      <Switch>
        <Route exact  path='/'>
             <Home /> 
        </Route>
        <Route path='/login'>
          <Login />
        </Route>
        <Route path='/viewAsset'>
             <ViewAsset />
        </Route>
       </Switch>
     </div> 
    </div>
    </Router>
  );
}

export default App;
