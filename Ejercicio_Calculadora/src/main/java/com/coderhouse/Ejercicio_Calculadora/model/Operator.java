package com.coderhouse.Ejercicio_Calculadora.model;

import jakarta.persistence.*;

@Entity
@Table(name = "operator")
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double firstNumber;

    private double secondNumber;
    private String operatorType;

    private double result;

    // getter y setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }


    // tostring

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                ", operatorType='" + operatorType + '\'' +
                ", result=" + result +
                '}';
    }
}
