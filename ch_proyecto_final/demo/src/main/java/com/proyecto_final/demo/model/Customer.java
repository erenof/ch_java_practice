package com.proyecto_final.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    // Definimos primary key
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int customer_id;
    private String name;
    private String email;
    private String address;
    private int dni;

    //getters setters

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", dni=" + dni +
                '}';
    }
}
