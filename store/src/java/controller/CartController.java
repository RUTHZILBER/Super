/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.ShopOrder;
import entities.Item;
import java.time.LocalDate;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import services.LoginServiceBean;
import util.StatefulUtil;

/**
 *
 * @author user1
 */
@Path("/cart")
public class CartController {

   
    @GET
    public List<Item> getCartItems(@Context HttpServletRequest request) throws NamingException{
       return  StatefulUtil.getCartServiceBean(request).getCartItems();
     
    }
    
    @POST
    public Response addToCart(@Context HttpServletRequest request,Item item) throws NamingException{
      StatefulUtil.getCartServiceBean(request).addToCart(item);
       return Response.ok().build();
        
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteFromCart(@Context HttpServletRequest request,@PathParam("id")int id) throws NamingException{
        StatefulUtil.getCartServiceBean(request).deleteFromCart(id);
       return Response.ok().build();
    }  
    
    @POST
    public Response buy(@Context HttpServletRequest request) throws NamingException{
         StatefulUtil.getCartServiceBean(request).buy();
         return Response.ok().build();
    }
}
