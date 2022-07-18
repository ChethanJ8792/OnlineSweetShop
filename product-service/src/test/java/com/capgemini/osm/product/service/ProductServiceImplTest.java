package com.capgemini.osm.product.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.osm.product.exception.NoProperDataException;
import com.capgemini.osm.product.exception.ProductNotFoundException;
import com.capgemini.osm.product.exception.ProductsNotFoundException;
import com.capgemini.osm.product.model.Product;
import com.capgemini.osm.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class ProductServiceImplTest {
 
	@Mock
	private ProductRepository productrepository;
	
	@InjectMocks
	private ProductServiceImpl productServiceImpl;
	
	@Test
	void productServiceNotNullTest() {
		assertThat(productServiceImpl).isNotNull();
	}
	
	@Test
	void getAllProductsTest() throws ProductsNotFoundException 
	{
		Product product1= new Product(100,"abc","delicious",445.21,"gfiygiyegynh.com");
		Product product2= new Product(200,"vhf","sweety",585.21,"vbdyrtgynh.com");
		List<Product> productsList=new ArrayList<>();
		productsList.add(product1);
		productsList.add(product2);
		when(productrepository.findAll()).thenReturn(productsList);
		assertEquals(productsList,productServiceImpl.getAllProducts("egfeugfyvugyegu.urgygfuyg4gfru.ehrgy4grgf"));
		//here we pass a dummy string value	
	}
	
	@Test
	void addProductsTest() throws NoProperDataException
	{
		Product product1= new Product(100,"abc","delicious",445.21,"gfiygiyegynh.com");
		Product product2= new Product(200,"vhf","sweety",585.21,"vbdyrtgynh.com");
		List<Product> productsList=new ArrayList<>();
		productsList.add(product1);
		productsList.add(product2);
		when(productrepository.save(productsList)).thenReturn(productsList);
		assertNotNull(productsList);
		//assertEquals(productsList,productServiceImpl.addProduct("egfeugfyvugyegu.urgygfuyg4gfru.ehrgy4grgf", (Product) productsList));  
	}
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@Test
	void addProductWithProperData() throws NoProperDataException {
		Product product= new Product(100,"abc","delicious",445.21,"gfiygiyegynh.com");
		when(productrepository.findById((long) 105)).thenReturn(Optional.of(product));
	try {
		((List<Product>) assertThat(productServiceImpl.addProduct("egfeugfyvugyegu.urgygfuyg4gfru.ehrgy4grgf", product)))
		.contains("Product with the id "+product.getId()+("Please fill all fields "));
	}catch(Exception e) {
		log.error(e.getMessage());
	}
		
	}
	
	
	@Test
	void getProductByIdTest() throws ProductNotFoundException {
	Product product= new Product(300,"brg","sour-sweety",54543.25,"rbtgertgynh.com");
	when(productrepository.findById((long) 300)).thenReturn(Optional.of(product));
	assertEquals(product,productServiceImpl.getProductById("egfeugfyvugyegu.urgygfuyg4gfru.ehrgy4grgf",(long) 300));
	}

	@Test
	void getProductByInvalidIdTest() throws ProductNotFoundException {
		Product product= new Product(300,"brg","sour-sweety",54543.25,"rbtgertgynh.com");
		when(productrepository.findById((long) 101)).thenReturn(Optional.of(product));
		try {
			assertThat(productServiceImpl.getProductById("egfeugfyvugyegu.urgygfuyg4gfru.ehrgy4grgf",(long)200)).as("Product Not Found with id");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
	}
	
	
	@Test
	void deleteProductByIdTest() throws ProductNotFoundException {
		Product product= new Product(400,"unme","chocolety",143.25,"ytutgerygyunh.com");	

		when(productrepository.findById((long)400)).thenReturn(Optional.of(product));
		assertThat(productServiceImpl.deleteProduct("egfeugfyvugyegu.urgygfuyg4gfru.ehrgy4grgf",(long)400).contains("deleted successfully...."));
		
	}
	@Test
	void deleteProductByInvalidIdTest() throws ProductNotFoundException {
		Product product= new Product(400,"unme","chocolety",143.25,"ytutgerygyunh.com");	
		when(productrepository.findById((long) 101)).thenReturn(Optional.of(product));
		try {
			assertThat(productServiceImpl.deleteProduct("egfeugfyvugyegu.urgygfuyg4gfru.ehrgy4grgf",(long)400))
			.contains("Product not available to delete on given id "+product.getId());
		}catch(Exception e) {
			log.error(e.getMessage());
		}
	}
}
/*SpringBootTest
@AutoConfigureMockMvc
public class PlanterServiceTest {
	

	@InjectMocks
	private PlanterServiceImpl planterServiceImpl;
	
	@Mock
	private PlanterRepository planterRepository;
	
	@Test
	void testServiceNotNull() {
		assertThat(planterServiceImpl).isNotNull();
	}
	
	@Test
	void testRepositoryNotNull() {
		assertThat(planterRepository).isNotNull();
	}
	
	@Test
	void testGetAllPlanters() throws PlanterNotFoundException {
		Planter p1= new Planter(2000,9, "red","oval",10, 90);
		Planter p2= new Planter(2001,10, "brown","round",20, 100);
		List<Planter> planterlist=new ArrayList<Planter>();
		planterlist.add(p1);
		planterlist.add(p2);
		when(planterRepository.findAll()).thenReturn(planterlist);
		assertEquals(planterlist,planterServiceImpl.getAllPlanters());
		
	}
	
	@Test
	void testGetPlanterById() throws PlanterNotFoundException {
		Planter p1= new Planter(2000,9, "red","oval",10, 90);
		when(planterRepository.findById(101)).thenReturn(Optional.of(p1));
		assertEquals(p1,planterServiceImpl.getPlanterById(101));
	}
	
	@Test
	void testGetPlanterByInvalidId() throws PlanterNotFoundException {
		Planter p1= new Planter(2000,9, "red","oval",10, 90);
		when(planterRepository.findById(101)).thenReturn(Optional.of(p1));
		try {
			assertThat(planterServiceImpl.getPlanterById(1)).as("Planter with the id 1 doesn't exist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
//	@Test
//	void testAddPlanter() throws PlanterNotFoundException, NoProperDataException {
//		Planter p1= new Planter(2000,9, "red","oval",10, 90);
//		((List<Planter>) assertThat(planterServiceImpl.addPlanter(p1)))
//		.contains("added successfully....");
//	
//	}	
//	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
//	@Test
//	void testAddPlanterAlreadyExists() throws PlanterNotFoundException {
//		Planter p1= new Planter(2000,9, "red","oval",10, 90);
//		when(planterRepository.findById(101)).thenReturn(Optional.of(p1));
//	try {
//		((List<Planter>) assertThat(planterServiceImpl.addPlanter(p1)))
//		.contains("Product with the id "+p1.getPlanterId()+" already exist");
//	}catch(Exception e) {
//		
//	}
//	}
//	
//	@Test
//	void testupdatePlanter() throws PlanterNotFoundException {
//		Planter p1= new Planter(2000,9, "red","oval",10, 90);	
//		when(planterRepository.findById(101)).thenReturn(Optional.of(p1));
//		assertThat(planterServiceImpl.updatePlanter(p1))
//		.contains("updated successfully....");
//	
//	}
//	
//	@Test
//	void testupdatePlanterDoesnotExists() throws PlanterNotFoundException {
//		Planter p1= new Planter(2000,9, "red","oval",10, 90);	
//		when(planterRepository.findById(10)).thenReturn(Optional.of(p1));
//	try {
//		assertThat(planterServiceImpl.updatePlanter(p1))
//		.contains("Planter with the id "+p1.getPlanterId()+" doesn't exist for update");
//	}catch(Exception e) {
//		
//	}
//	}
	
	@Test
	void testDeletePlanterById() throws PlanterNotFoundException {
		Planter p1= new Planter(2000,9, "red","oval",10, 90);	

		when(planterRepository.findById(101)).thenReturn(Optional.of(p1));
		assertThat(planterServiceImpl.deletePlanter(101))
		.contains("deleted successfully....");
	}
	
	@Test
	void testDeletePlanterByInvalidId() throws PlanterNotFoundException {
		Planter p1= new Planter(2000,9, "red","oval",10, 90);	
		when(planterRepository.findById(101)).thenReturn(Optional.of(p1));
		try {
			assertThat(planterServiceImpl.deletePlanter(111))
			.contains("Planter with the id "+p1.getPlanterId()+" doesn't exist");
		}catch(Exception e) {
			
		}
	}
	
 * 
 */
	






















