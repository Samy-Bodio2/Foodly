BEGIN
sp_register (p_personid => &id,
             p_fullname => &name,   
             p_password => &pass,                        
             p_username => &username,
             p_address  => &address,
             p_phoneno  => &phone,
             p_cardno   => &cardno);
END;
/
@Features/Features_respo_resto/Menu_respo_resto_con