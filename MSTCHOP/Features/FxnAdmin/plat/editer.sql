select * from dish;

UPDATE dish
SET dish_name = '&dish_name'
WHERE dish_id = &dish_id;

select * from dish;