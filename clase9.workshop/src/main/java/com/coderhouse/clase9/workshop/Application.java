package com.coderhouse.clase9.workshop;

import com.coderhouse.clase9.workshop.model.Client;
import com.coderhouse.clase9.workshop.model.Invoice;
import com.coderhouse.clase9.workshop.model.Product;
import com.coderhouse.clase9.workshop.repository.iClientRepository;
import com.coderhouse.clase9.workshop.repository.iInvoiceRepository;
import com.coderhouse.clase9.workshop.repository.iProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private iClientRepository clientRepository;

	@Autowired
	private iInvoiceRepository invoiceRepository;

	@Autowired
	private iProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening. Access H2 on: http://localhost:8888/h2-console");

		try {

			// Código nuestro y lo que quiero imprimir por consola
			// Parte 1: creación de clientes
			Client cliente1 = new Client();
			cliente1.setName("Horacio");
			cliente1.setDocnumber("43582992");
			cliente1.setLastname("Guarani");
			this.clientRepository.save(cliente1);

			Client cliente2 = new Client();
			cliente2.setName("Osvaldo");
			cliente2.setDocnumber("344507755");
			cliente2.setLastname("Laport");
			this.clientRepository.save(cliente2);

			Client cliente3 = new Client();
			cliente3.setName("Susana");
			cliente3.setDocnumber("40341129");
			cliente3.setLastname("Gimenez");
			this.clientRepository.save(cliente3);

			Client cliente4 = new Client();
			cliente4.setName("Juan Carlos Poratota");
			cliente4.setDocnumber("31987430");
			cliente4.setLastname("Tarufetti");
			this.clientRepository.save(cliente4);

			//Buscando usando el metodo customizado de iClientRepository
			List<Client> clientes = this.clientRepository.findByNameLike("%ora%");
			System.out.println(clientes.size());
			printClientes(clientes);

			// Buscando usando el metodo en jpql
			List<Client> clientes2 = this.clientRepository.getByNameOrderedByLastNameJPQL("a");
			System.out.println("Usando query jpql: \n");
			System.out.println(clientes2.size());
			printClientes(clientes2);

			// Creacion de productos
			Product remera = new Product();
			remera.setCode("codigo1");
			remera.setDescription("Remera azul");
			remera.setPrice(3000);
			remera.setStock(10);
			this.productRepository.save(remera);

			Product auricularesBT = new Product();
			auricularesBT.setCode("codigo2");
			auricularesBT.setDescription("La bateria dura una banda");
			auricularesBT.setPrice(10000);
			auricularesBT.setStock(20);
			this.productRepository.save(auricularesBT);

			Optional<Product> productoGuardado1 = this.productRepository.findById(1);
			Optional<Product> productoGuardado2 = this.productRepository.findById(2);

			System.out.println(productoGuardado1);
			System.out.println(productoGuardado2);

			// Paso 3: creacion de facturas
			Optional<Client> client1 = this.clientRepository.findById(1);

			Invoice invoice1 = new Invoice();
			client1.ifPresent(invoice1::setClient);
			invoice1.setCreated_at("21-05");
			invoice1.setTotal(700);
			this.invoiceRepository.save(invoice1);

			Invoice invoice2 = new Invoice();
			client1.ifPresent(invoice2::setClient);
			invoice2.setCreated_at("22-05");
			invoice2.setTotal(850);
			this.invoiceRepository.save(invoice2);

			Optional<Client> client2 = this.clientRepository.findById(2);
			Invoice invoice3 = new Invoice();
			client2.ifPresent(invoice3::setClient);
			invoice3.setCreated_at("22-05");
			invoice3.setTotal(2850);
			this.invoiceRepository.save(invoice3);

			// Obtenemos las facturas de client1
			client2 = this.clientRepository.findById(2);
			//Muestro las facturas de client1
			System.out.println("Invoice de client1: \n");
			System.out.println(client2.get().getInvoice());


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	static void printClientes (List<Client> listadoClientes) {
		for (Client cliente: listadoClientes) {
			System.out.println(cliente);
		}
	}

}
