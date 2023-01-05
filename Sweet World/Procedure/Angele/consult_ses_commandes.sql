select order_date,restaurant_name,menu_title,menu_qte,
(select sum(menu_price*quantity) 
 from choix c
 join menu m on c.menu_id=m.menu_id
 where c.choix_id=p.panier_id
 ) as " total price"
 from orders o
 join panier p on o.panier_id=p.panier_id
 join choix c on c.panier_id=p.panier_id
 join menu m on m.menu_id=c.menu_id
 join restaurants r on r.restaurant_id=o.restaurant_id
 where customer_id=&customer_id
 order by order_date ;
 ---ANGELE
 
  