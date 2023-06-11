package com.coderhouse.clase10.service;

import com.coderhouse.clase10.model.Product;
import com.coderhouse.clase10.model.RequestProductDetail;
import com.coderhouse.clase10.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //Guardar producto
    public Product postProduct(Product product) throws Exception {
        return productRepository.save(product);
    }

    //Listar un producto por id
    public Product getProduct(int id) throws Exception {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new Exception("Product with id: "+ id + ", not found");
        } else {
            return product.get();
        }
    }

    // Mostrar lista de productos, para poder armar el invoice
    public List<Product> getProductsById(List<RequestProductDetail> productListId) throws Exception {
        List<Product> productList = new ArrayList<>();
        for (RequestProductDetail requestProduct:
                productListId) {
            Optional<Product> productFound = productRepository.findById(requestProduct.getProductId());
            if (productFound.isEmpty()){
                throw new Exception("Product with id: " + requestProduct.getProductId() + " not found.");
            }
            productList.add(productFound.get());
        }
        return productList;
    }
}