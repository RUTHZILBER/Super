/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Role;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import util.StatefulUtil;

/**
 *
 * @author user1
 */
@Path("/login")
public class LoginController {

    @GET
    @Path("/{password}/{name}")
    public Response login(@Context HttpServletRequest request,@PathParam("password") String password,@PathParam("name") String name) throws NamingException {
        System.out.println("in login controller");
       StatefulUtil.getLoginServiceBean(request).login(password, name);
        System.out.println(StatefulUtil.getLoginServiceBean(request).userRole);
       return Response.ok().build();
    }

}
