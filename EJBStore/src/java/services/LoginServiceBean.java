/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.LoginDao;
import entities.Role;
import entities.UserRole;
import javax.ejb.EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ws.rs.core.Response;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author user1
 */
@Stateful
@LocalBean
public class LoginServiceBean {
    @EJB
    LoginDao loginDao;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     public  Role userRole=Role.USER;
     
    public Role login(String name,String password) {
     
       userRole = loginDao.Login(name, password);
       
        System.out.println("your role is: " +userRole);
        System.out.println("id of instance: " + hashCode());
       return userRole;
   
    }
}
