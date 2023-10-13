package com.lmg.models.pojos;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "Product")
public class Product implements Serializable{

    @Id()
    @GeneratedValue(
		strategy = GenerationType.IDENTITY
	)
    private Long id;
    
    private String barcode;
    
    private Long inStock;
    
    private String name;
    
    
    @OneToMany(mappedBy = "product")
    private Set<TransactionProduct> transactionProducts;
    
    public Product() {
    }
    
    @Override
    public String toString() {
        return "Product [barcode=" + barcode + ", id=" + id + ", name=" + name + ", pricePerPiece=" + pricePerPiece
                + "]";
    }
    
    public Product(String barcode, String name, Float pricePerPiece) {
        this.barcode = barcode;
        this.name = name;
        this.pricePerPiece = pricePerPiece;
    }

    public Product(Long id, String barcode, String name, Float pricePerPiece) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.pricePerPiece = pricePerPiece;
    }
    
    private Float pricePerPiece;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getBarcode() {
        return barcode;
    }
    
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
    public Long getStock() {
        return inStock;
    }

    public void setStock(Long inStock) {
        this.inStock = inStock;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Float getPricePerPiece() {
        return pricePerPiece;
    }
    
    public void setPricePerPiece(Float pricePerPiece) {
        this.pricePerPiece = pricePerPiece;
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
            Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    
    

}
