INSERT INTO Restaurant(id_resto,name_resto,Description,name_employee,phone_number,resto_address,Date_res_created,id_user)
VALUES
(id_resto_seq.nextval,
'&Entrer_le_nom_du_restau',
'&Description',
'&Responsable_du_restaurant',
&Numero_du_restaurant,
'&Adresse_du_restaurant',
TO_DATE('&Date', 'DD/MM/YYYY'),id_user('&Enter_your_Username'));


@Features/Features_admin/Menu_admin