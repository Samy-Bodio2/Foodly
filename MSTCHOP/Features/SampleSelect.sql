SELECT garnish_id, 
  garnish_name 
  FROM garnish;

SELECT id_config, 
  marge 
  FROM config;

SELECT customer_id, 
  customer_firstname, 
  customer_lastname, 
  customer_email, 
  customer_phone, 
  customer_address,
  customer_gender, 
  customer_start_date,
  utilisateur_id
  FROM customers;

SELECT dish_id, 
  dish_name
  FROM dish;

SELECT choix_id, 
  panier_id, 
  menu_id, 
  quantity 
  FROM choix;

SELECT menu_id, 
  menu_title, 
  menu_description, 
  menu_price, 
  menu_qte,
  menu_date, 
  dish_id, 
  seculant_id, 
  garnish_id, 
  restaurant_id, 
  id_config
  FROM menu;

SELECT id_note, 
  Valeur, 
  customer_id,
  restaurant_id
  FROM note;

SELECT order_id, 
  order_date, 
  restaurant_id, 
  panier_id 
  FROM orders;

SELECT panier_id, 
  customer_id
  FROM panier;

SELECT restaurant_id,
    restaurant_name,
    description,
     restaurant_email,
     restaurant_phone,
    restaurant_address,
    utilisateur_id
  FROM restaurant;
SELECT seculant_id, 
  seculant_name
  FROM seculant;
  
SELECT utilisateur_id, 
  utilisateur_email, 
  password
  FROM utilisateur;

