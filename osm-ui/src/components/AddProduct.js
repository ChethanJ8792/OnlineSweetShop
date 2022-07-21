import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddProduct() {

    let navigate=useNavigate();

    const [product,setProduct]=useState({
        id:"",
        productname:"",
        productdesc:"",
        price:"",
        photo_path:""    
    });
    const {id,productname,productdesc,photo_path,price}=product;

    const onInputChange=(e)=>
    {
        setProduct({...product,[e.target.productname]:e.target.value});
    }
//check id again here
    const onSubmit =async (e) =>
    {
        e.preventDefault();
        await axios.post("http://localhost:8087/product-service/addproduct",product);
        navigate("/");
    };
    
  return (
    <div className="container">
     <div className="row">
     <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
        <h2 className="text-center m-4">Add Product</h2>

        <form onSubmit={(e)=>onSubmit(e)}>
            <div className="mb-3">
                <label htmlFor="Name" className="form-label">ProductName</label>
                <input
                type={"text"}
                className="form-control"
                placeholder="Enter Product Name"
                name="productname"
                value={productname}
                onChange={(e)=>onInputChange(e)}
                />
            </div>
            <div className="mb-3">
                <label htmlFor="Desc" className="form-label">ProductDesc</label>
                <input
                type={"text"}
                className="form-control"
                placeholder="Enter Product desc"
                name="productdesc"
                value={productdesc}
                onChange={(e)=>onInputChange(e)}
                />
            </div>
            <div className="mb-3">
                <label htmlFor="Photo_Path" className="form-label">ProductPhotoPath</label>
                <input
                type={"text"}
                className="form-control"
                placeholder="Enter Product Photo_Path"
                name="photo_path"
                value={photo_path}
                onChange={(e)=>onInputChange(e)}
                />
            </div>
            <div className="mb-3">
                <label htmlFor="Price" className="form-label">ProductPrice</label>
                <input
                type={"text"}
                className="form-control"
                placeholder="Enter Product Price"
                name="price"
                value={price}
                onChange={(e)=>onInputChange(e)}
                />
            </div>
            <button type="submit" className="btn btn-outline-primary">
            Submit
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">Cancel</Link>
        </form>
     </div>

    </div>
      
    </div>
  )
}
