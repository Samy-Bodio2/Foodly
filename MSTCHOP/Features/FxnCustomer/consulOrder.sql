select customer_id "cust_id", customer_firstname||' '||customer_lastname "fullname"
 from customers;
select order_id, order_date,restaurant_id
from orders o
join panier p
on o.panier_id=p.panier_id
where customer_id=&customer_id
order by order_date;