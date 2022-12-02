--BEGIN
--sp_users (p_id_user => id_user_seq.NEXTVAL,
--             p_username => '&username',   
--             p_password => '&password'                      
--             );
--END;
--/

INSERT INTO USERS(id_user,username,password)
VALUES(id_user_seq.nextval,'&username','&password');

SELECT * FROM USERS WHERE id_user = &id_user;