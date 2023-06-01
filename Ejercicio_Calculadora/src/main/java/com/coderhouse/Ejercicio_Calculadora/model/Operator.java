package com.coderhouse.Ejercicio_Calculadora.model;

import jakarta.persistence.*;

@Entity
@Table(name = "operator")
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int firstNumber;

    private int secondNumber;
    private String operatorType;

    private int result;

    // getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
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
