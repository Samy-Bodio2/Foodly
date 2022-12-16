select p.customer_id "cust_id",customer_firstname||' '||customer_lastname "fullname", panier_id
 from panier p
 join customers c
 on c.customer_id=p.customer_id;
select restaurant_id,restaurant_name
from restaurants;
 insert into orders (order_id,order_date,restaurant_id,panier_id)
 values (seq_order.nextval,to_char(sysdate,'dd/mm/yyy'),&restaurant_id,&panier_id);
select * from orders;