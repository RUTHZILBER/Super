/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import services.CartServiceBean;
import services.LoginServiceBean;

/**
 *
 * @author user1
 */
public class StatefulUtil {

    public static CartServiceBean getCartServiceBean(HttpServletRequest request) {
        CartServiceBean serviceBean = null;
        try {

            if (request.getSession().getAttribute("CartServiceBean") == null) {
                InitialContext ctx = null;

                ctx = new InitialContext();

                serviceBean = (CartServiceBean) ctx.lookupLink("java:global/store/CartServiceBean");
                request.getSession().setAttribute("CartServiceBean", serviceBean);
            } else {
                serviceBean = (CartServiceBean) request.getSession().getAttribute("CartServiceBean");
            }
        } catch (NamingException ex) {
            Logger.getLogger(StatefulUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serviceBean;

    }

    public static LoginServiceBean getLoginServiceBean(HttpServletRequest request) {
        LoginServiceBean serviceBean = null;
        try {

            if (request.getSession().getAttribute("LoginServiceBean") == null) {
                InitialContext ctx = new InitialContext();
                serviceBean = (LoginServiceBean) ctx.lookupLink("java:global/store/LoginServiceBean");
                System.out.println("put login service in session");
                System.out.println(serviceBean.hashCode());
                request.getSession().setAttribute("LoginServiceBean", serviceBean);
            } else {
                serviceBean = (LoginServiceBean) request.getSession().getAttribute("LoginServiceBean");
                System.out.println(serviceBean.userRole);
            }
        } catch (NamingException ex) {
            Logger.getLogger(StatefulUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serviceBean;
    }
}
