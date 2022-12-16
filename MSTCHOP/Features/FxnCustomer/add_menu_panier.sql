set linesize 3000;
 select panier_id,
      customer_firstname,
      customer_lastname
       from panier p
       join customers c
       ON(p.customer_id = c.customer_id) ;
 select menu_id,menu_title
  from menu;


INSERT INTO choix(choix_id ,
  panier_id ,
  menu_id,
  quantity)
  VALUES(
      seq_choix.nextval,
      &panier_id,
      &menu_id,
      &quantity
  );

  select * from choix;