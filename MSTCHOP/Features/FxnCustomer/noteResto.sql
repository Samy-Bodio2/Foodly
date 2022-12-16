
select customer_id "cust_id", customer_firstname||' '||customer_lastname "fullname" from customers;
select restaurant_id,restaurant_name
from restaurants;
insert into Note (id_note,Valeur,customer_id,restaurant_id)
values (seq_note.nextval,&note,&customer_id,&restaurant_id);
select id_note,
Valeur ,  
customer_firstname,
restaurant_name
from Note n
join customers c
ON(c.customer_id = n.customer_id )
join restaurants r
ON (n.restaurant_id = r.restaurant_id);