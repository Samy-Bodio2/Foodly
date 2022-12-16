UPDATE garnish SET 
  garnish_name = '&garnish_name' 
WHERE
  garnish_id = &garnish_id;

UPDATE config SET 
  marge = &marge 
WHERE
  id_config = &id_config;

UPDATE customers SET 
  customer_id=&customer_id,
  customer_firstname='&customer_firstname',
  customer_lastname='&customer_lastname', 
  customer_email='&customer_email', 
  customer_phone= &customer_phone, 
  customer_address= '&customer_address',
  customer_gender='&customer_gender', 
  customer_start_date=TO_CHAR (SYSDATE,'dd/mm/yyyy'),
  utilisateur_id=&utilisateur_id
WHERE
  customer_id=customer_id;
UPDATE Dish SET 
  dish_name ='&ish_name' 
WHERE
  dish_id = &dish_id;
  
UPDATE choix SET 
  quantity = &quantity, 
  WHERE
  panier_id =&panier_id AND menu_id = &menu_id;

UPDATE Menu SET 
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
WHERE
  menu_id = &menu_id;

UPDATE Note SET 
  Valeur = &Valeur, 
  customer_id = &customer_id 
WHERE
  id_note = &id_note;

UPDATE Orders SET 
  order_date = '&order_date', 
  restaurant_id=&restaurant_id, 
  panier_id=&panier_id
WHERE
  order_id = &order_id;

UPDATE Panier SET 
  customer_id = &customer_id 
WHERE
  panier_id = &panier_id;

UPDATE restaurants SET 
 restaurant_name='&rest',
    description,
     restaurant_email,
     restaurant_phone,
    restaurant_address,
    utilisateur_id
WHERE
  restaurant_id = &restaurant_id;

UPDATE Seculant SET 
  seculant_name ='&seculant_name' 
WHERE
  seculant_id = &seculant_id;

UPDATE utilisateur SET 
  utilisateur_email = '&utilisateur_email', 
  password = '&password' 
WHERE
  utilisateur_id = &utilisateur_id;

