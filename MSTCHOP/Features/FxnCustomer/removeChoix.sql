select customer_id "cust_id", customer_firstname||' '||customer_lastname "fullname" from customers;

select customer_id, panier_id 
from panier where customer_id=&cust_id;

select choix_id "choix_id", menu_title,menu_price, quantity
from choix c
join menu m
on m.menu_id=c.menu_id
join panier p 
on p.panier_id=c.panier_id
where p.panier_id= &panier_id;

delete from choix
where choix_id=&choix_id;

select choix_id "choix_id", menu_title,menu_price, quantity
from choix c
join menu m
on m.menu_id=c.menu_id
join panier p 
on p.panier_id=c.panier_id
where p.panier_id= &&panier_id;