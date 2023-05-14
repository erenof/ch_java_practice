package com.coderhouse.clase8.repository;

import com.coderhouse.clase8.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
