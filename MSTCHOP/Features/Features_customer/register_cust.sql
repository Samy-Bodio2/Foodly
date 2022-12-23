BEGIN
sp_register_customer (p_personid => &id,
             p_fullname => &name,   
             p_password => &pass,                        
             p_username => &username,
             p_address  => &address,
             p_phoneno  => &phone,
             p_cardno   => &cardno);
END;
/

@Features/Features_customer/Menu_customer