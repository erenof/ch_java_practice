package com.coderhouse.clase10.controller;

import com.coderhouse.clase10.middleware.ResponseHandler;
import com.coderhouse.clase10.model.Product;
import com.coderhouse.clase10.model.RequestProductDetail;
import com.coderhouse.clase10.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //CRUD Producto
    //Add producto
    @PostMapping
    public ResponseEntity<Object> postProduct (@RequestBody Product product){
        try{
            System.out.println(product);
            Product productSaved = productService.postProduct(product);
            return ResponseHandler.generateResponse(
                    "Product stored successfully",
                    HttpStatus.OK,
                    productSaved
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    // Get product details
    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getProduct (@PathVariable() int id) {
        try {
            System.out.println(id);
            Product productFound = productService.getProduct(id);
            return ResponseHandler.generateResponse(
                    "Product retireved",
                    HttpStatus.OK,
                    productFound
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
