package com.proyecto_final.demo;

import com.proyecto_final.demo.model.Customer;
import com.proyecto_final.demo.model.Product;
import com.proyecto_final.demo.repository.CustomerRepository;
import com.proyecto_final.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on: http://localhost:8888/h2-console");

		//Creamos un Customer
		Customer customer1 = new Customer();
		customer1.setName("Juan Caraballi");
		customer1.setEmail("caraballij@yahoo.com.ar");
		customer1.setAddress("Cochabamba 1614");
		customer1.setDni(10563431);

		//Creamos un Product
		Product jean = new Product();
		jean.setProduct_name("Jean Pampero");
		jean.setProduct_description("Jean chupín full facha");
		jean.setPrice(16000);
		jean.setStock(100);

		//Creamos un Product
		Product camisa = new Product();
		camisa.setProduct_name("Camisa Narrow");
		camisa.setProduct_description("Camisa manga corta puro algodón");
		camisa.setPrice(5990);
		camisa.setStock(230);

		//Persistimos los objetos creados anteriormente en la base de datos por medio del repository
		//Guardamos el customer1 en la base
		this.customerRepository.save(customer1);
		//Guardamos el jean en la base
		this.productRepository.save(jean);
		//Guardamos la camisa en la base
		this.productRepository.save(camisa);

		//Listamos todos los productos
		List<Product> productList = this.productRepository.findAll();

		System.out.println("Mi lista de productos:" + productList);



	}

}
