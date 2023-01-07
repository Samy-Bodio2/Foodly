BEGIN
Sp_Inscription (p_id_admin => id_admin_seq.NEXTVAL,
             p_name_admin => '&name_admin',   
             p_pwd_admin => format1('&pwd_admin')                      
             );
END;
/
@Features/Features_admin/Menu_admin