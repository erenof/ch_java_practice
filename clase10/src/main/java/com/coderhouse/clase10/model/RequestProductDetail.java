package com.coderhouse.clase10.model;

public class RequestProductDetail {
    private int productId;
    private int quantity;

    public RequestProductDetail(int PorductId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    //getters y setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
