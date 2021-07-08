/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.OrdersDao;
import entities.ShopOrder;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author user1
 */
@Stateless
@LocalBean
public class OrderServiceBean {
@EJB
 OrdersDao ordersDao;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
      public List<ShopOrder> getOrders(){
        return   ordersDao.getOrders();
    }
}
