package com.coderhouse.Ejercicio_Calculadora.controller;

import com.coderhouse.Ejercicio_Calculadora.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/calculator")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    // Create a sum
    @PostMapping(path = "sum/{num1}{num2}")
    public ResponseEntity<Object> postSum(@RequestParam num1, num2) {
        try{

        }
    }
}
