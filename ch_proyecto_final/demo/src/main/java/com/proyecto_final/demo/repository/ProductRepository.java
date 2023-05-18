package com.proyecto_final.demo.repository;

import com.proyecto_final.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
