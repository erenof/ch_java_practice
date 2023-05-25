package com.coderhouse.clase10.controller;

import com.coderhouse.clase10.middleware.ResponseHandler;
import com.coderhouse.clase10.model.Invoice;
import com.coderhouse.clase10.model.InvoiceDTO;
import com.coderhouse.clase10.model.RequestInvoice;
import com.coderhouse.clase10.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<Object> postInvoice (@RequestBody RequestInvoice reqInvoice) {
        try {
            System.out.println(reqInvoice);
            InvoiceDTO data = invoiceService.postInvoice(reqInvoice);
            return ResponseHandler.generateResponse(
                    "Invoice created successfully",
                    HttpStatus.OK,
                    data
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    // Funcionalidad para traer un invoice por id
    @GetMapping(path = "{invoiceId}")
    public ResponseEntity<Object> getInvoiceById (@PathVariable int invoiceId){
        try {
            System.out.println(invoiceId);
            InvoiceDTO data = invoiceService.getInvoiceById(invoiceId);
            return ResponseHandler.generateResponse(
                    "Get invoice by id successful.",
                    HttpStatus.OK,
                    data
            );
        } catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    // Funcionalidad para  traer todas las invoice de un cliente
    @GetMapping(path = "/getInvoicesByClientId/{clientId}")
    public ResponseEntity<Object> getInvoicesByClientId (@PathVariable int clientId){
        try {
            List<InvoiceDTO> data = invoiceService.getInvoicesByClientId(clientId);
            return ResponseHandler.generateResponse(
                    "Get invoices by client id successful",
                    HttpStatus.OK,
                    data
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
}
