SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE Sp_Inscription( p_id_admin,
                                            p_name_admin ,
                                            p_pwd_admin )
   IS
        a_msg VARCHAR2(100);
 BEGIN
             INSERT INTO Customers( id_admin,
                                   name_admin ,
                                  pwd_admin)
            SELECT p_id_admin,
                   p_name_admin ,
                   p_pwd_admin
       FROM DUAL
      WHERE NOT EXISTS
           (SELECT NULL FROM Admin WHERE id_admin = p_id_admin);
    a_msg :=
    CASE 
        WHEN SQL%ROWCOUNT >0 THEN 'administrator registered'
            ELSE ' administrator already exists'
         END;
          DBMS.OUTPUT.put_line(a_msg);
 END;

 BEGIN
Sp_Inscription (p_id_admin => id_admin_seq.NEXTVAL,
             p_name_admin => '&name_admin',   
             p_pwd_admin => format1('&pwd_admin')                      
             );
END;
/