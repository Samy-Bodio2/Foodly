DECLARE
v_resto VARCHAR(100);
BEGIN
sp_users (p_id_user => id_user_seq.NEXTVAL,
             p_username => '&username',   
             p_password => '&password'                      
             );
SELECT  name_resto "Nom du restaurant" INTO v_resto
FROM Restaurant WHERE id_resto=&id_resto;
END;
/
SELECT * FROM USERS WHERE id_user = &id_user;