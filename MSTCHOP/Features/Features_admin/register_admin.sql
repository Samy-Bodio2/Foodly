BEGIN
sp_register_admin (p_id_user => id_user_seq.NEXTVAL,
             p_username => '&username',   
             p_password => format1('&password')                      
             );
END;
/
@Features/Features_admin/Menu_admin