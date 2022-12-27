SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE Sp_Inscription(c_id_cust IN	INT	,	
                                           c_first_name IN	VARCHAR2(25),		
                                           c_last_name	IN VARCHAR2(25)	,			
                                           c_phone_number	IN NUMBER		,		
                                           c_Email	 IN VARCHAR2(30)	,
                                           c_Datecd_cust	IN DATE	,
                                           c_Cust_address	IN VARCHAR2(40),	
                                            c_id_user	IN INT)
   IS
        l_msg VARCHAR2(100);
    BEGIN
             INSERT INTO Customers( id_cust,
                                   first_name,
                                   last_name,
                                   phone_number,
                                   Email,
                                   Datecd_cust,
                                   Cust_address,
                                   id_user)
            SELECT c_id_cust,
                c_first_name,
                 c_last_name,
                c_phone_number,
                c_Email,
                c_Datecd_cust,
                c_Cust_address,
                 c_id_user
       FROM DUAL
      WHERE NOT EXISTS
           (SELECT NULL FROM Customers WHERE id_cust = c_id_cust);
    l_msg :=
    CASE 
        WHEN SQL%ROWCOUNT >0 THEN 'customers registered'
            ELSE ' customers already exists'
         END;
          DBMS.OUTPUT.put_line(l_msg);
 END;