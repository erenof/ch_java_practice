package com.coderhouse.clase9.workshop.repository;

import com.coderhouse.clase9.workshop.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iInvoiceRepository extends JpaRepository<Invoice, Integer> {
}
