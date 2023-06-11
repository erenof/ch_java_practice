package com.coderhouse.clase10.repository;

import com.coderhouse.clase10.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
