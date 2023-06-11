package com.coderhouse.clase10.model;

import java.util.List;

//Esta clase no tiene el anotation @Entity porque esto no es una tabla, es un objeto oque lo vamos a usar de forma
//eterea para mapear la request
public class RequestInvoice {

    private int client_id;

    //Listado de detalles (id producto y su cantidad)
    private List<RequestProductDetail> product_list;


    public RequestInvoice(int client_id, List<RequestProductDetail> product_list){
        this.client_id = client_id;
        this.product_list = product_list;
    }

    //getters y setters


    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public List<RequestProductDetail> getProduct_list() {
        return product_list;
    }

    public void setProduct_list(List<RequestProductDetail> product_list) {
        this.product_list = product_list;
    }

    //tostring

    @Override
    public String toString() {
        return "RequestInvoice{" +
                "client_id=" + client_id +
                ", product_list=" + product_list +
                '}';
    }
}
