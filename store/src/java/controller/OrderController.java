/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entities.Role;
import entities.ShopOrder;
import java.util.List;
import javax.ejb.EJB;
import static javax.enterprise.deploy.shared.ModuleType.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import services.LoginServiceBean;
import services.OrderServiceBean;
import util.StatefulUtil;
 
/**
 *
 * @author user1
 */
@Path("/order")
public class OrderController {
  @EJB 
    OrderServiceBean orderServiceBean;
    @GET
    public Response getOrders(@Context HttpServletRequest request){
          
            if(StatefulUtil.getLoginServiceBean(request).userRole==Role.MANAGER)   
            { 
              GenericEntity<List<ShopOrder>> list = new GenericEntity<List<ShopOrder>>(orderServiceBean.getOrders()){};
              return Response.ok(list).build();

                
            }
         
             return Response.status(Response.Status.FORBIDDEN).build();
  
    }
}
