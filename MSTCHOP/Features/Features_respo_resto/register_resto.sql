INSERT INTO Restaurant(id_resto,name_resto,Description,email,phone_number,resto_address,id_user)
VALUES
(id_resto_seq.nextval,
'&Entrer_le_nom_du_restau',
'&Description',
'&email',
'&Numero',
'&Adresse_du_restaurant'
,id_user('&Enter_your_Username'));

@Features/Features_respo_resto/Menu_respo_resto_con