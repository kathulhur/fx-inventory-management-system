package com.lmg.models.pojos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name = "Transaction")
public class Transaction implements Serializable {
    public Transaction() {
    }


    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    private LocalDateTime date = LocalDateTime.now();

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }



    @ManyToMany
    @JoinTable(
        name = "transaction_product",
        joinColumns = @JoinColumn(name = "transaction_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    Set<TransactionProduct> transactionProducts;

    public Set<TransactionProduct> getTransactionProducts() {
        return transactionProducts;
    }

    public void setTransactionProducts(Set<TransactionProduct> transactionProducts) {
        this.transactionProducts = transactionProducts;
    }



    public Float getTotalPrice() {
        Float totalPrice = 0f;
        for (TransactionProduct transactionProduct : transactionProducts) {
            totalPrice += transactionProduct.getProduct().getPricePerPiece() * transactionProduct.getQuantity();
        }
        return totalPrice;
    }

    public Float getTotalSales() {
        Float totalSales = 0f;
        for (TransactionProduct tp : transactionProducts) {
            totalSales += tp.getProduct().getPricePerPiece() * tp.getQuantity();
        }

        return totalSales;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction other = (Transaction) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

    
}
