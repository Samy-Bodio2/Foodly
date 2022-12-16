UPDATE Menu SET 
  menu_title ='&menu_title',
  menu_description ='&menu_description',
  menu_price =&menu_price,
  menu_date ='&menu_date',
  menu_qte =&menu_qte,
  dish_id =&dish_id,
  seculant_id =&seculant_id,
  garnish_id =&garnish_id,
  restaurant_id =&restaurant_id,
  id_config = &id_config
WHERE
  menu_id = &menu_id;