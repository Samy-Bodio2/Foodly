CREATE OR REPLACE PROCEDURE sp_users(p_id_user IN INT,
                                    p_username IN VARCHAR,
                                    p_password IN VARCHAR
                                    )
    IS
       l_msg  VARCHAR(100);
   BEGIN
      INSERT INTO Users (id_user,
                         username,
                         password
                        )
      SELECT p_id_user,
             p_username,
             p_password
      FROM DUAL
      WHERE NOT EXISTS
              (SELECT NULL
               FROM Users
               WHERE id_user = p_id_user);
      
	   l_msg :=
              CASE
                 WHEN SQL%ROWCOUNT > 0 THEN 'User registered'
                 ELSE 'User already exists' 
             END;
 
   DBMS_OUTPUT.put_line(l_msg);
   END;
   /

BEGIN
sp_users (p_id_user => id_user_seq.NEXTVAL,
             p_username => '&username',   
             p_password => '&password'                      
             );     
END;
/