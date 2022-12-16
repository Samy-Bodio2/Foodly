INSERT INTO restaurants (restaurant_id,
    restaurant_name,
    description,
     restaurant_email,
     restaurant_phone,
    restaurant_address,
    utilisateur_id
)
VALUES(seq_resto.nextval,
'&restaurant_name', 
 '&description',
  '&restaurant_email',
  &restaurant_phone,
  '&restaurant_address',
  &utilisateur_id);
