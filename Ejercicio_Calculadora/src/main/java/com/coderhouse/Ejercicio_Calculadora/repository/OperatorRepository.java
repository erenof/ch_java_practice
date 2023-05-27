package com.coderhouse.Ejercicio_Calculadora.repository;

import com.coderhouse.Ejercicio_Calculadora.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<Operator, Integer> {
}
