package com.capgemini.osm.product.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.capgemini.osm.product.exception.NoProperDataException;
import com.capgemini.osm.product.exception.ProductNotFoundException;
import com.capgemini.osm.product.exception.ProductsNotFoundException;
import com.capgemini.osm.product.model.Product;
import com.capgemini.osm.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductRepository productrepository;
	
	@Override   //=>user/admin
	public List<Product> getAllProducts() throws ProductsNotFoundException {
		log.info("get all products  from here");
		if(productrepository.findAll().isEmpty())
		{
			throw new ProductsNotFoundException("No Products Found"); 
		}
		else
		{
		return productrepository.findAll();
		}
		//new  ResponseEntity<>(productrepository.findAll(),HttpStatus.OK);
	}
	/*
	 * @Override //only admin public ResponseEntity<Product>
	 * getProductById(@RequestBody Product product,@PathVariable Long id) throws
	 * ProductNotFoundException{ log.info("get products by id starts from here");
	 * Product po=productrepository.findById(id).orElseThrow(()-> new
	 * ProductNotFoundException("User Not Found with id "+id)); return
	 * ResponseEntity.ok().body(po); }
	 */


	@Override  //only admin  //make modification on duplicate values
	public Product addProduct( Product product) throws NoProperDataException {
		
		Product bean=productrepository.save(product);
		if(bean==null) 
		{
			throw new NoProperDataException("Name can't be duplicate");
		}
		return bean;
		// new ResponseEntity<>(bean,HttpStatus.CREATED);
	}

	@Override //admin only 
	public Product updateProduct(Product product, Long id) throws ProductNotFoundException {
		log.info("update");
		Product pro=productrepository.findById(id).orElseThrow(()-> new  ProductNotFoundException("No Product Availble wth this id"));
		pro.setProductname(product.getProductname());
		pro.setProductdesc(product.getProductdesc());
		pro.setPrice(product.getPrice());
		pro.setPhoto_path(product.getPhoto_path());
		final Product updatedProduct=productrepository.save(pro);
		return updatedProduct;
				//ResponseEntity.ok(updatedProduct);
	}
	
	@Override //only admin
	public String deleteProduct(Long  id) throws ProductNotFoundException {
		log.info("delete By Id");
		var isRemoved = productrepository.findById(id);
		if(isRemoved.isPresent())
		{
			productrepository.deleteById(id);
			log.debug("deleted succesfully {}",isRemoved.get());
		}
		else
		{
			throw new ProductNotFoundException("Product not available to delete on given id");
		}
		log.info("end");
		return "deleted";
				//ResponseEntity.ok(id+" deleted successfully");
	}
	@Override
	public Product getProductById(Long id) throws ProductNotFoundException {
		Product lo=productrepository.findById(id).orElseThrow(()-> new ProductNotFoundException("User Not Found with id "+id));
		return lo;
				//ResponseEntity.ok().body(lo);
		//getById id takes only id has input (it will not take object Product product)
	}
}
















