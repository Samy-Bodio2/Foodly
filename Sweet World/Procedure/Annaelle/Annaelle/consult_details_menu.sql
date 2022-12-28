Select Menu_title,
       Menu_description,
       Menu_price,
       Menu_date,
       Menu_Qty,
       D.Name_dish,
       S.Name_Seculant,
      C.Name_complement
From Menu M
   join Dish D
   on M.id_dish = D.id_dish
   join Complement C
   on C.id_complement = M.id_complement
   join Seculant S
   on S.id_seculant = M.id_seculant
   join Restaurant R
   on R.id_resto = M.id_resto
WHERE M.Menu_title = '&Menu_title';





