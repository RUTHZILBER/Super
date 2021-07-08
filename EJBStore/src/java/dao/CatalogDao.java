/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entities.Item;
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
public class CatalogDao {
@PersistenceContext
private EntityManager em;
    
    public List<Item> getCatalogItems(){
    
        return em.createQuery("select i from Item i").getResultList();
    
    }
     public void addItemToCatalog(Item item){
     
         em.persist(item);
         
      
    }
       public void editCatalogItem(Item item){
      
          em.merge(item);
       }
        public void deleteItem(int id){
           em.createQuery("delete from Item i where i.id:id ").setParameter(id, id);
  }
     // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
