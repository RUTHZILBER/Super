/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import static entities.ShopOrder_.itemsInOrder;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 *
 * @author user1
 */
@Entity
public class ShopOrder implements Serializable {

   private static final long serialVersionUID = 1L;
    @TableGenerator(name = "ShopOrder", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = " ShopOrder ")
    private int id;
     private LocalDate orderDate;
     private List<Item>itemsInOrder; 

    public ShopOrder() {
    }

    public ShopOrder(int id, LocalDate orderDate, List<Item> itemsInOrder) {
        this.id = id;
        this.orderDate = orderDate;
        this.itemsInOrder = itemsInOrder;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<Item> getItemsInOrder() {
        return itemsInOrder;
    }

    public void setItemsInOrder(List<Item> itemsInOrder) {
        this.itemsInOrder = itemsInOrder;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShopOrder)) {
            return false;
        }
        ShopOrder other = (ShopOrder) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ShopOrder[ id=" + id + " ]";
    }
    
}
