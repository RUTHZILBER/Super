/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entities.Role;
import entities.Item;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import services.CatalogServiceBean;
import services.LoginServiceBean;
import util.StatefulUtil;


/**
 *
 * @author user1
 */
@Path("/catalog")

public class CatalogController {
      
  @EJB 
  CatalogServiceBean catalogServiceBean;
  
  
    
    @GET

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> getCatalogItems(){
        
       return catalogServiceBean.getCatalogItems();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addItemToCatalog(@Context HttpServletRequest request,Item item){
    
        LoginServiceBean bean = StatefulUtil.getLoginServiceBean(request);
        System.out.println(bean.hashCode());
            if(bean.userRole==Role.MANAGER)   
            { 
                catalogServiceBean.addItemToCatalog(item); 
                return Response.ok().build();  
                
            }
         
             return Response.status(Response.Status.FORBIDDEN).build();
   }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editCatalogItem(@PathParam("id") int id,@Context HttpServletRequest request ,Item item){
        
            if(StatefulUtil.getLoginServiceBean(request).userRole==Role.MANAGER)   
            {  
                catalogServiceBean.editCatalogItem(item);
                
          
                 return Response.ok().build();  
                
            }
        return Response.status(Response.Status.FORBIDDEN).build();
    }
    
    @DELETE
    @Path("/{id}")
       @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteItem(@PathParam("id") int id,@Context HttpServletRequest request ,Item item){
            if(StatefulUtil.getLoginServiceBean(request).userRole==Role.MANAGER)   
            {  
                 catalogServiceBean.deleteItem(id); 
                 return Response.ok().build();
            }
           return Response.status(Response.Status.FORBIDDEN).build();
    }
    
    
}
