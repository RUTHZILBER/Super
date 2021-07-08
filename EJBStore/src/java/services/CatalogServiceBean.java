/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.CatalogDao;
import entities.Item;
//import entities.TempDB;
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
public class CatalogServiceBean {
  @EJB
  CatalogDao catalogDao;
    public List<Item> getCatalogItems(){
       
      return catalogDao.getCatalogItems();
               
    }
    
 
    public void addItemToCatalog(Item item){
     
        catalogDao.addItemToCatalog(item);
    }
    public void editCatalogItem(Item item){
       
        catalogDao.editCatalogItem(item);
    }
    
  
    public void deleteItem(int id){
         catalogDao.deleteItem(id);
 
    }
}

