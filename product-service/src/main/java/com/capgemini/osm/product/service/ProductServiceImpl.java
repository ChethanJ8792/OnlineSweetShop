package com.capgemini.osm.product.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

	//changed in line 30
	@Autowired
	private ProductRepository productrepository;
	
	@Override   //=>user/admin
	public List<Product> getAllProducts(String token) throws ProductsNotFoundException {
		
		List<Product> products;
		products=productrepository.findAll();
		log.debug("the products are {}",products);//log messages should be here only
		try {
			if(products.size()==0)
			{
				throw new ProductsNotFoundException("Products not found....!!");
			}
		}catch(ProductsNotFoundException e)
		{
			log.error(e.getMessage());
		}
		return products;
}


	@Override  //only admin  //make modification on duplicate values
	public Product addProduct(String token, Product product) throws NoProperDataException {
		
		Product bean=productrepository.save(product);
		log.debug("Added Product is  {}",bean);//log messages should be here only after businnes is method
		try {
		if(bean.getProductname().isEmpty()||bean.getProductdesc().isEmpty()||bean.getPhoto_path().isEmpty()) 
		{
			throw new NoProperDataException(" Please fill all fields ");
		}
		}catch(NoProperDataException np)
		{
			log.error(np.getMessage());
		}
		return bean;
	}

	@Override //admin only 
	public Product updateProduct(String token,Product product, Long id) throws ProductNotFoundException {
		Product product1=productrepository.findById(id).orElseThrow(()-> new  ProductNotFoundException("No Product Availble wth this id"));
		log.debug("updated  product is {}",product1);
		product1.setProductname(product.getProductname());
		product1.setProductdesc(product.getProductdesc());
		product1.setPrice(product.getPrice());
		product1.setPhoto_path(product.getPhoto_path());
		return  productrepository.save(product1);
		//return updatedProduct;
		
	}
	
	@Override //only admin
	public String deleteProduct(String token,Long  id) throws ProductNotFoundException {
		Optional<Product> product = productrepository.findById(id);
		log.debug("the product is {}",product);
		if(product.isPresent())
		{
			productrepository.deleteById(id);
			log.debug("deleted succesfully {}",product.get());
		}
		else
		{
			throw new ProductNotFoundException("Product not available to delete on given id");
		}
		log.info("end");
		return "deleted";
				
	}
	@Override
	public Product getProductById(String token,Long id) throws ProductNotFoundException {
		Product product=productrepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product Not Found with id "+id));
		log.debug("the product deleted  is {}",product);
		return product;
		//getById id takes only id has input (it will not take object Product product)
	}
}
















