SELECT Name_dish, null, null
FROM Dish
UNION 
SELECT null, Name_garnish, null
FROM Garnish
UNION 
SELECT null, null, Name_seculant 
FROM Seculant; 


@Features/Features_admin/MenusAction