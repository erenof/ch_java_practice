package com.coderhouse.clase9.workshop.repository;

import com.coderhouse.clase9.workshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iProductRepository extends JpaRepository<Product, Integer> {
}
