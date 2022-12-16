select *from menu;
  
INSERT INTO Menu
  (id_menu, 
  Menu_title, 
  Menu_description, 
  Menu_price, 
  Menu_date, 
  Menu_Qty, 
  dish_id,
  seculant_id,
  garnish_id,
  restaurant_id,
  id_config) 
VALUES 
  (seq_menu.nextval, 
  '&menu_title', 
  '&menu_description', 
  &menu_price, 
      TO_CHAR (SYSDATE,'dd/mm/yyyy'),
  &menu_qte, 
  &dish_id, 
&seculant_id, 
  &garnish_id, 
  &restaurant_id, 
  id_config 
  );


  select  *from menu;
    