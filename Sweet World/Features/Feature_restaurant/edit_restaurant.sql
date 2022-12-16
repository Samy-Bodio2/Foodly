UPDATE Restaurant
SET 
id_resto=&id_resto,
name_resto='&name_resto', 
Description='&Description',
name_employee='&name_employee',
phone_number=&phone_number ,
resto_address='&resto_address',
Date_res_created='&Date_res_created', 
id_note=&id_note, 
id_user=&id_user
WHERE id_resto=&id_resto;