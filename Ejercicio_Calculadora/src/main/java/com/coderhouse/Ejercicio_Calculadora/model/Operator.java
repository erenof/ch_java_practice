package com.coderhouse.Ejercicio_Calculadora.model;

import jakarta.persistence.*;

@Entity
@Table(name = "operator")
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int num1;

    private int num2;

    private String operator;

    private int result;

    // getter and setter
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    // toString method
    @Override
    public String toString() {
        return "Operator{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", operator='" + operator + '\'' +
                ", result=" + result +
                '}';
    }
}
