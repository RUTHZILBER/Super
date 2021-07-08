package entities;

import entities.Item;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-17T05:17:57")
@StaticMetamodel(ShopOrder.class)
public class ShopOrder_ { 

    public static volatile ListAttribute<ShopOrder, Item> itemsInOrder;
    public static volatile SingularAttribute<ShopOrder, Integer> id;
    public static volatile SingularAttribute<ShopOrder, LocalDate> orderDate;

}