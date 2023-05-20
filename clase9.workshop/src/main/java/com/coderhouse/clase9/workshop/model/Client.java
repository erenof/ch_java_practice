package com.coderhouse.clase9.workshop.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    private String docnumber;

    //Relacion un cliente muchas facturas, usamos OnetoMany
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Invoice> invoice;

    //Getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }

    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", docnumber='" + docnumber + '\'' +
                ", invoice=" + invoice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;

        if (getId() != client.getId()) return false;
        if (getName() != null ? !getName().equals(client.getName()) : client.getName() != null) return false;
        if (getLastname() != null ? !getLastname().equals(client.getLastname()) : client.getLastname() != null)
            return false;
        if (getDocnumber() != null ? !getDocnumber().equals(client.getDocnumber()) : client.getDocnumber() != null)
            return false;
        return getInvoice() != null ? getInvoice().equals(client.getInvoice()) : client.getInvoice() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLastname() != null ? getLastname().hashCode() : 0);
        result = 31 * result + (getDocnumber() != null ? getDocnumber().hashCode() : 0);
        result = 31 * result + (getInvoice() != null ? getInvoice().hashCode() : 0);
        return result;
    }
}
