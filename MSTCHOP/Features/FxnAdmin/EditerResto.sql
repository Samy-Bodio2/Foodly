 update restaurants
    set restaurant_name = '&restaurant_name',
     description = '&description',
      restaurant_email = '&restaurant_email',
       restaurant_phone = &restaurant_phone,
       restaurant_address = '&restaurant_address'
  where restaurant_id = &restaurant_id;  
  
  SELECT * 
  FROM restaurants
  WHERE restaurant_id = &restaurant_id;
