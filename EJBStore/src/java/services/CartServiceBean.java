/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.OrdersDao;
import entities.Item;
import entities.ShopOrder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ws.rs.core.Response;

/**
 *
 * @author user1
 */
@Stateful
@LocalBean
public class CartServiceBean {
@EJB 
 OrdersDao orderDao;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   List<Item> cartItems = new ArrayList();

     public List<Item> getCartItems(){
       return cartItems;
    }
    
    public void addToCart(Item item){
        cartItems.add(item);
   
    }
    
    public void deleteFromCart( int id){
     
         cartItems.removeIf(p->p.getId()==id);
  }  

    public void buy(){
       orderDao.addOrder(new ShopOrder(0,LocalDate.now(),cartItems));
        
    }
    
    
}
