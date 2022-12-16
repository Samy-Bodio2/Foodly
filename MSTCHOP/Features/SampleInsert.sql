INSERT INTO utilisateur
  (utilisateur_id, 
  utilisateur_email, 
  password) 
VALUES 
  (seq_user.nextval, 
   '&utilisateur_email', 
  '&password');
  
   INSERT INTO garnish
  (garnish_id, 
  garnish_name) 
VALUES 
  (seq_garnish.nextval, 
  '&garnish_name');

INSERT INTO config
  (id_config, 
  marge) 
VALUES 
  (seq_config.nextval, 
  &marge);

INSERT INTO customers
  (customer_id, 
  customer_firstname, 
  customer_lastname, 
  customer_email, 
  customer_phone, 
  customer_address,
  customer_gender, 
  customer_start_date,
  utilisateur_id) 
VALUES 
  (seq_cust.nextval, 
  '&customer_firstname', 
  '&customer_lastname', 
  '&customer_email', 
  &customer_phone, 
  '&customer_address',
  '&customer_gender', 
  TO_CHAR (SYSDATE,'dd/mm/yyyy'),
  &utilisateur_id);

INSERT INTO dish
  (dish_id, 
  dish_name) 
VALUES 
  (seq_dish.nextval, 
  '&dish_name');

  INSERT INTO panier
  (panier_id, 
  customer_id) 
VALUES 
  (seq_panier.nextval, 
  &customer_id);

INSERT INTO seculant
  (seculant_id, 
  seculant_name) 
VALUES 
  (seq_seculant.nextval, 
  '&seculant_name');

  INSERT INTO restaurants
  (restaurant_id,
    restaurant_name,
    description,
     restaurant_email,
     restaurant_phone,
    restaurant_address,
    utilisateur_id
) 
VALUES 
  (seq_resto.nextval, 
  '&restaurant_name',
    '&description',
     '&restaurant_email',
     &restaurant_phone,
    '&restaurant_address',
    &utilisateur_id);

INSERT INTO menu
  (menu_id, 
  menu_title, 
  menu_description, 
  menu_price, 
  menu_qte,
  menu_date, 
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
  &menu_qte,
 TO_CHAR (SYSDATE,'dd/mm/yyyy'), 
  &dish_id, 
  &seculant_id, 
  &garnish_id, 
  &restaurant_id, 
  &id_config);

INSERT INTO Note
  (id_note, 
  Valeur, 
  customer_id,
  restaurant_id) 
VALUES 
  (seq_note.nextval,
   &Valeur, 
  &customer_id,
  &restaurant_id
  );

INSERT INTO orders
  (order_id, 
  order_date, 
  restaurant_id, 
  panier_id) 
VALUES 
  (seq_order.nextval,
  TO_CHAR (SYSDATE,'dd/mm/yyyy'),
  &restaurant_id, 
  &panier_id
  );


INSERT INTO choix
  (choix_id, 
  panier_id, 
  menu_id, 
  quantity) 
VALUES 
  (seq_choix.nextval, 
  &panier_id, 
  &menu_id, 
  &quantity);