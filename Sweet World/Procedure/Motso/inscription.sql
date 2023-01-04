SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE Sp_Inscription( id_admin,
                                            name_admin ,
                                            pwd_admin )
   IS
        a_msg VARCHAR2(100);
 BEGIN
             INSERT INTO Customers( id_admin,
                                   name_admin ,
                                  pwd_admin)
            SELECT id_admin,
                   name_admin ,
                   pwd_admin
       FROM DUAL
      WHERE NOT EXISTS
           (SELECT NULL FROM Admin WHERE id_admin = id_admin);
    a_msg :=
    CASE 
        WHEN SQL%ROWCOUNT >0 THEN 'administrator registered'
            ELSE ' administrator already exists'
         END;
          DBMS.OUTPUT.put_line(a_msg);
 END;