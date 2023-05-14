package com.coderhouse.clase8;

import com.coderhouse.clase8.model.Product;
import com.coderhouse.clase8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class Clase8Application implements CommandLineRunner {

	// Instanciamos el repository con la anotación @Autowired, le delegamos a spring que se encargue de instanciar
	// todos los objetos que crea necesarios.
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Clase8Application.class, args);
	}

	// Metodo run (de CommandLineRunner) para poder ejecutar código despues de que haya levantado spring boot
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on: http://localhost:8888/h2-console");
		//Creamos un objeto de tipo Producto
		/*
		Product taza = new Product();
		taza.setCode("sarasa");
		taza.setDescription("400 ml");
		taza.setPrice(10);
		taza.setStock(100);
		*/

		// Atraves del repository (nexo con la db) le indicamos que guarde el producto
		// Hay que crear la anotacion @Autowired (linea 15)
		//this.productRepository.save(taza);

		//Para buscar un registro en la base
		//Nos devuelve un wrapper optional, es el producto envuelto en un opcional
		//el findById espera un Optional
		Optional<Product> productoObtenido = this.productRepository.findById(2);

		//Usamos el .get para que me devuelva el producto en si
		if (productoObtenido.isPresent()) {
			System.out.println(productoObtenido.get());
		} else {
			System.out.println("El producto no existe.");
		}

	}
}
