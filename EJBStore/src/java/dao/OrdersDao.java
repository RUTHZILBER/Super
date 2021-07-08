/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.ShopOrder;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user1
 */

@Stateless
@LocalBean
public class OrdersDao {
  @PersistenceContext 
  private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     public List<ShopOrder> getOrders(){
      return em.createQuery("select s from ShopOrder s").getResultList();
    }
    public void addOrder(ShopOrder shopOrder){
           em.persist(shopOrder);
           
    }
}
