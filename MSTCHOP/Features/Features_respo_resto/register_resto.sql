SET LINESIZE 6000
BEGIN
sp_register_admin (p_id_user => id_user_seq.NEXTVAL,
             p_username => '&username',   
             p_password => format1('&password')                      
             );
END;
/

INSERT INTO Restaurant(id_resto,name_resto,Description,email,phone_number,resto_address,id_user)
VALUES
(id_resto_seq.nextval,
'&Entrer_le_nom_du_restau',
'&Description',
'&email',
'&Numero',
'&Adresse_du_restaurant'
,idutil('&Enter_your_Username'));


SELECT * FROM Restaurant c JOIN Users u ON (c.id_user = u.id_user);

@Features/Features_respo_resto/Menu_respo_resto_con