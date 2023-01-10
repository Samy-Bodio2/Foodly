
DECLARE
r_id_user Users.id_user%type;
  PROCEDURE add_restaurant 
  AS
  BEGIN
   SELECT 
      id_user 
    INTO 
       r_id_user
    FROM 
       Restaurant r
    JOIN 
       Users u
    ON  
       (r.id_user=u.id_user)
    WHERE
        username='&Enter_your_username'
    AND 
        password='&Enter_your_password'

    INSERT INTO
    (
        id_resto,   
      name_resto ,  
      Description,  
      email ,         
      phone_number,  
      resto_address,   
      id_user            
    )
    VALUES
    (
      
        id_resto_seq.nextval,'&name_resto',
                             '&description', 
                            '&email',
                            '&phone_number',
                            '&resto_address',
                              r_id_user
    )

END;
BEGIN
add_restaurant;
END;
/


