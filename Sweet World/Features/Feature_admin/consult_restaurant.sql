SELECT name_resto "Nom du restaurant", 
       name_employee "Nom du responsable", 
       Description , 
       phone_number "Telephone", 
       resto_address "Adresse", 
       Date_res_created "Date de creation" 
FROM Restaurant WHERE id_resto=&id_resto;