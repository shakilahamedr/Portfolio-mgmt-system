import "bootstrap/dist/css/bootstrap.css";
const AssetTables = ({assets}) => {

    return (
        <div className="container col-8">
            <h3 className="text-primary">Stock</h3>
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Stock Id</th>
                            <th>Stock Name</th>
                            <th>Stock Count</th>
                        </tr>
                    </thead>
                    <tbody>
                        { assets.stockDetailList.map((asset) => (
                            <tr key={asset.id}>
                                <td>{asset.id}</td>
                                <td>{asset.name}</td>
                                <td>{asset.units}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>

                <h3 className="text-primary">Mutual Fund</h3>
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>MutualFund Id</th>
                            <th>MutualFund Name</th>
                            <th>MutualFund Units</th>
                        </tr>
                    </thead>
                    <tbody>
                        { assets.mutualFundList.map((asset) => (
                            <tr key={asset.id}>
                                <td>{asset.id}</td>
                                <td>{asset.name}</td>
                                <td>{asset.units}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
        </div>
      );
}
 
export default AssetTables;