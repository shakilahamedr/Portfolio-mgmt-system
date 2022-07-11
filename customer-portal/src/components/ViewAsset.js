import { useEffect, useState } from "react";
import AssetTables from "./AssetTables";
import "bootstrap/dist/css/bootstrap.css";
import {Button} from "react-bootstrap";
import { useJwtContext } from "../hooks/useJwtContext";

const ViewAsset = () => {

    const {jwt} = useJwtContext()

    const [assets, setAssets] = useState(null)
    const [networth, setNetworth] = useState('?');
    const [isLoading, setIsLoading] = useState(true);

     useEffect(()=>{
        fetch("http://pod2-lb-800533877.eu-central-1.elb.amazonaws.com:80/calculateNetworth/viewAsset", {
            method : 'get',
            headers : new Headers({
                'Authorization': 'Bearer '+jwt
            })
            }).then(res => {
                return res.json();
            })
            .then(data => {
                console.log(data);
                setIsLoading(false);
                setAssets(data);
            })
     },[jwt]);

    const handleNetworth = () => {
        fetch('http://pod2-lb-800533877.eu-central-1.elb.amazonaws.com:80/calculateNetworth/', {
            method:'get',
            headers: new Headers({
                'Authorization': 'Bearer '+jwt
            })
        }).then((res)=> {
            return res.json();
        }).then(data=>{
            console.log(data);
            setNetworth(data);
        })
    }

    return (
        <div className="container">
            <div className="col-md-12 text-center">
                { isLoading && <h3>Loading....</h3>}
                { assets && <div> <AssetTables assets={assets}/>
                    <Button className="btn btn-primary" onClick={()=>handleNetworth()}>NetWorth</Button> 
                    <br/><br/>
                    <h3>₹{networth}</h3>
                </div> }
            </div>
        </div>
      );
}
 
export default ViewAsset;