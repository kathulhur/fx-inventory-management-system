package com.lmg.models.pojos;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

public class TransactionProduct implements Serializable {
    
    public TransactionProduct() {
        // TODO: Consider adding the price here because price of product may change
    }

    public TransactionProduct(Transaction transaction, Product product, int quantity) {
        this.transaction = transaction;
        this.product = product;
        this.quantity = quantity;
        this.priceSold = product.getPricePerPiece();
        this.id = new TransactionProductKey(transaction.getId(), product.getId());
    }
    
    @EmbeddedId
    private TransactionProductKey id;

    public TransactionProductKey getId() {
        return id;
    }

    public void setId(TransactionProductKey id) {
        this.id = id;
    }



    @ManyToOne
    @MapsId("transactionId")
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;
    
    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }



    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Float priceSold;

    public Float getPriceSold() {
        return priceSold;
    }

    public void setPriceSold(Float priceSold) {
        this.priceSold = priceSold;
    }

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        TransactionProduct other = (TransactionProduct) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    
    
}
