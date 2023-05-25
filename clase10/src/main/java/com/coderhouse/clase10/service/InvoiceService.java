package com.coderhouse.clase10.service;

import com.coderhouse.clase10.model.Client;
import com.coderhouse.clase10.model.Invoice;
import com.coderhouse.clase10.model.InvoiceDTO;
import com.coderhouse.clase10.model.RequestInvoice;
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

    public InvoiceDTO postInvoice (RequestInvoice requestInvoice) throws Exception {

        //Instanciar un objeto invoice
        Invoice invoiceCreated = new Invoice();

        //Seteamos la fecha del invoice
        invoiceCreated.setCreated_at(new Date().toString());

        //Para debugging, obtenemos el clientId por consola
        System.out.println(requestInvoice.getClient_id());

        //Buscamos al cliente atraves de su id
        Optional<Client> clientExist = clientRepository.findById(requestInvoice.getClient_id());
        System.out.println(clientExist.isEmpty());
        if (clientExist.isEmpty()){
            throw new Exception("Client not found.");
        }

        //Seteamos al cliente dentro del invoice
        invoiceCreated.setClient(clientExist.get());

        //Llamamos al repository
        invoiceCreated = invoiceRepository.save(invoiceCreated);

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
