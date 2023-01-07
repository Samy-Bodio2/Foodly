UPDATE PROCEDURE resto_update
(v_id_resto        IN INT     ,
v_name_resto       IN VARCHAR(30) , 
v_Description      IN VARCHAR(40),
v_name_employee    IN VARCHAR(20),
v_phone_number     IN INT ,
v_resto_address    IN VARCHAR(50),
v_Date_res_created IN DATE,  
v_id_user          IN INT)
IS 
v_chaine NVARCHAR(30)='Modifier votre Restaurant'
BEGIN

DBMS_OUTPUT.PUT_LINE(v_chaine);
END;

select id_resto
        into v_id_resto
        from Restaurant r
        join Users u
        on r.id_user=u.id_user
        where u.username='&username'
         and u.password='&passwd';

  IF sql%found THEN

UPDATE Restaurant SET
id_resto            =v_id_resto,
name_resto          =v_name_resto, 
Description         =v_Description,
name_employee       =v_name_employee,
phone_number        =v_phone_number ,
resto_address       =v_resto_address,
Date_res_created    =v_Date_res_created, 
id_user             =v_id_user
WHERE id_resto      =v_id_resto;

DBMS_OUTPUT.PUT_LINE ('Voulez-vous modifier un autre Restaurant ? (y/n)');
    if choix1 = 'y' 
    then DBMS_output.put_line('Modification effectuée');
    elsif choix1 = 'n'
    then
        DBMS_OUTPUT.PUT_LINE ('1. Retour');
        DBMS_OUTPUT.PUT_LINE ('2. Quitter');
    Else
        elsif v_option = '1' then DBMS_output.put_line('Retour');
        elsif v_option = '2' then DBMS_output.put_line('Quitter');
        else DBMS_output.put_line('Vous devez faire un choix valide');
        end if;
    end if;

    else 
    DBMS_OUTPUT.PUT_LINE('votre login et votre mot de passe ne sont pas correctes. Entrez des informations justes');
    end if;

    exception
    when no_data_found then
    DBMS_OUTPUT.PUT_LINE('aucune valeur trouvée');
END ;
/
-------******BY TATSINKOU******-------