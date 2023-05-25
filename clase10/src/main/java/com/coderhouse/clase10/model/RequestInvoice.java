package com.coderhouse.clase10.model;

//Esta clase no tiene el anotation @Entity porque esto no es una tabla, es un objeto oque lo vamos a usar de forma
//eterea para mapear la request
public class RequestInvoice {

    private int client_id;

    //Luego añadiremos los invoice details
    private String otra_prop;

    public RequestInvoice(int client_id, String otra_prop){
        this.client_id = client_id;
        this.otra_prop = otra_prop;
    }

    //getters y setters
    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getOtra_prop() {
        return otra_prop;
    }

    public void setOtra_prop(String otra_prop) {
        this.otra_prop = otra_prop;
    }

    //tostring
    @Override
    public String toString() {
        return "RequestInvoice{" +
                "client_id=" + client_id +
                ", otra_prop='" + otra_prop + '\'' +
                '}';
    }
}
