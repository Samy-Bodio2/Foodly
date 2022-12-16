DELETE FROM garnish 
  WHERE garnish_id =&garnish_id ;
DELETE FROM config 
  WHERE id_config = &id_config;
DELETE FROM customers 
  WHERE customer_id = &customer_id;
DELETE FROM dish 
  WHERE dish_id =&dish_id ;
DELETE FROM choix 
  WHERE choix_id = &choix_id AND panier_id =&panier_id AND menu_id=&menu_id;
DELETE FROM menu 
  WHERE menu_id = &menu_id;
DELETE FROM note 
  WHERE note_id = &note_id;
DELETE FROM orders 
  WHERE order_id =&order_id;
DELETE FROM panier 
  WHERE panier_id = &panier_id;
DELETE FROM restaurant 
  WHERE restaurant_id =&restaurant_id;
DELETE FROM seculant 
  WHERE seculant_id = &seculant_id;
DELETE FROM utilisateur 
  WHERE utilisateur_email = &utilisateur_id;

