/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Role;
import entities.UserRole;
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

public class LoginDao {

    @PersistenceContext
    private EntityManager em;

    public Role Login(String name, String password) {

        List<UserRole> users = em.createQuery("select u from UserRole u where u.password=:password and u.userName=:name").setParameter("password", password).setParameter("name", name).getResultList();
        if (!users.isEmpty()) {
            return users.get(0).getRole();
        }
        return Role.USER;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
