UPDATE PROCEDURE menu_update
(v_id_menu          IN INT     ,
v_ Menu_title       IN VARCHAR(25) , 
v_Menu_description  IN VARCHAR(80),
v_Menu_price        IN NUMBER ,
v_Menu_date         IN DATE  ,
v_Menu_Qty          IN VARCHAR(50),
v_id_dish           IN INT,  
v_id_seculant       IN INT,
v_ id_complement    IN INT,
v_id_resto          IN INT,
v_id_config         IN INT)
IS 
v_chaine            VARCHAR(30)='Modifier votre Menu '
BEGIN
DBMS_OUTPUT.PUT_LINE(v_chaine);
END ;
select id_resto
        into v_id_resto
        from Restaurant r
        join Users u
        on r.id_user=u.id_user
        where u.username='&username'
         and u.password='&passwd';

  IF sql%found THEN

    select id_dish
    into v_dish_id
    from Dish
    where Name_dish = '&dish_name';

    select id_seculant
    into v_seculant_id
    from Seculant
    where Name_Seculant = '&seculant_name';

    select id_complement
    into v_id_garnish
    from Complement
    where Name_complement = '&Name_garnish';

    IF sql%found THEN

UPDATE Menu SET
 Menu_title          = v_ Menu_title ,      
    Menu_description = v_Menu_description ,
    Menu_price       = v_Menu_price,          
    Menu_date        = v_Menu_date ,
    Menu_Qty         =v_Menu_Qty,
    id_dish          =v_id_dish,
    id_seculant      = v_id_seculant,
    id_complement    = v_ id_complement ,
    id_resto         = v_id_resto,
    id_config        = v_id_config
WHERE id_menu        =v_id_menu;

 DBMS_OUTPUT.PUT_LINE ('Voulez-vous modifier un autre menu ? (y/n)');
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