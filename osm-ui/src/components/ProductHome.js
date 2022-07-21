import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams,Link } from 'react-router-dom';

export default function ProductHome() {

    const [products,setProducts]=useState([]);

    const {id} =useParams();

    useEffect(()=>
    {
        loadProducts();
    },[]);
    const loadProducts =async ()=>
    {
        const result =await axios.get("http://localhost:8087/product-service/allproducts");
        setProducts(result.data);
    }

    const deleteProduct =async ()=>
    {
        await axios.delete("http://localhost:8087/product-service/deleteproduct/{$id}");
        loadProducts();
    }
  return (
    <div>
      <div className='container'>
        <div className='py-4'>
            <table className='table border shadow'>
                <thead>
                <tr>
                    <th scope='col'>I.D</th>
                    <th scope='col'>ProductName</th>
                    <th scope='col'>ProductDesc</th>
                    <th scope='col'>Price</th>
                    <th scope='col'>Photo</th>
                </tr>
                </thead>
                <tbody>
                    {products.map((product,index)=>
                    
                        <tr>
                            <th scope='row' key={index}>{index+1}</th>
                            <td>{product.productname}</td>
                            <td>{product.productdesc}</td>
                            <td>{product.price}</td>
                            <td>{product.photo_path}</td>
                            <td>
                                <Link className="btn btn-primary mx-2" to={'/getproduct/${product.id}'}>View Product </Link>
                                <Link className="btn btn-primary mx-2" to={'/updateproduct/${product.id}'}>Edit Product</Link>
                                <button className="btn btn-primary mx-2" onClick={()=>deleteProduct(product.id)}>Delete Product</button> 
                            </td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>

      </div>
    </div>
  )
}
