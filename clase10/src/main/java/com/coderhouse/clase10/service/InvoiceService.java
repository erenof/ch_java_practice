package com.coderhouse.clase10.service;

import com.coderhouse.clase10.model.*;
import com.coderhouse.clase10.repository.ClientRepository;
import com.coderhouse.clase10.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @Autowired
    private ClientService clientService;


    // Guardamos Invoice, hay que buscar el cliente y los productos relacionados
    public InvoiceDTO postInvoice (RequestInvoice requestInvoice) throws Exception {

        //Buscamos al cliente atraves de su id usando clientService
        Client clientExist = clientService.getClient(requestInvoice.getClient_id());

        //Buscamos los productos
        List<Product> productList = productService.getProductsById(requestInvoice.getProduct_list());

        //Calculo del total
        double total = 0;
        int i = 0;
        for (Product product:
            productList) {
            total += product.getPrice() * requestInvoice.getProduct_list().get(i).getQuantity();
            i++;
        }

        //Con lo de arriba tenemos lo necesario para crear el invoice, abajo instanciamos un nuevo objeto
        //de tipo invoice y le damos "formato" con los valores que necesita
        //Instanciamos un objeto invoice
        Invoice invoiceCreated = new Invoice();

        //Seteamos la fecha del invoice
        invoiceCreated.setCreated_at(new Date().toString());

        //Seteamos al cliente dentro del invoice
        invoiceCreated.setClient(clientExist);

        //Seteamos el total
        invoiceCreated.setTotal(total);

        //Guardamos el invoice antes de guardar el detalle, llamamos al repository
        //Hasta aca tenemos la factura creada, falta crear todos los detalles
        invoiceCreated = invoiceRepository.save(invoiceCreated);

        //Seteamos los invoice_details y los guardamos
        //Con el listado de productos, hacemos un bucle, por cada producto vamos a guardar el detalle
        //instanciamos un InvoiceDetail
        i = 0;
        for (Product productForDetail:
            productList) {
            InvoiceDetail newInvoice = new InvoiceDetail();
            //Seteamos el precio final de la factura
            newInvoice.setPrice(productForDetail.getPrice());
            //Seteamos las dos foreing keys
            newInvoice.setInvoice(invoiceCreated);
            newInvoice.setProduct(productForDetail);
            //Seteamos la cantidad, el "i" es para obtener la linea de la factura
            newInvoice.setQuantity(requestInvoice.getProduct_list().get(i).getQuantity());
            invoiceDetailService.saveInvoiceDetail(newInvoice);
            i++;
        }

        //Por último retornamos el DTO
        return new InvoiceDTO(
                invoiceCreated.getId(),
                invoiceCreated.getCreated_at(),
                invoiceCreated.getTotal()
        );
    }

    // Traer invoice por id de cliente
    public List<InvoiceDTO> getInvoicesByClientId (int clientId) throws Exception {
        System.out.println(clientId);
        return invoiceRepository.getInvoicesByClientById(clientId);
    }

    // Traer invoice por invoice id
    public InvoiceDTO getInvoiceById (int invoiceId) throws Exception {
        Optional<Invoice> invoiceFound = invoiceRepository.findById(invoiceId);
        if (invoiceFound.isEmpty()) {
            throw new Exception("Invoice not found");
        }
        return new InvoiceDTO(
                invoiceFound.get().getId(),
                invoiceFound.get().getCreated_at(),
                invoiceFound.get().getTotal()
        );
    }
}
