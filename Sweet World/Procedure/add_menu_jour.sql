declare

    v_dish_id Dish.id_dish%type;
    v_seculant_id Seculant.id_seculant%type;
    v_id_complement Complement.id_complement%type;
    v_option varchar(50);
    choix char ;

    cursor v_menu is
    select id_menu, Menu_title, Menu_description,
        Menu_price, Menu_date, Menu_Qty, id_dish,
        id_seculant, id_complement
    from Menu ;
    
    cursor c_cursor is
    select username, password from Users 
    where username = '&username'
        and password = '&password';

begin

    open v_menu;
    open c_cursor;

    select id_dish
    into v_dish_id
    from Dish
    where Name_dish = '&dish_name';

    select id_seculant
    into v_seculant_id
    from Seculant
    where Name_Seculant = '&seculant_name';

    select id_complement
    into v_id_complement
    from Complement
    where Name_complement = '&complement_name';

  IF c_cursor%found THEN

    insert into v_menu 
    (
        id_menu, Menu_title, Menu_description,
        Menu_price, Menu_date, Menu_Qty, id_dish,
        id_seculant, id_complement
    )
    values
    (
        id_menu_seq.nextval,'&titre','&description',
        &price, to_date(sysdate,'dd-mm-yy'),
        &quantite, v_dish_id, v_seculant_id,
        v_id_complement
    );

    FOR menu_record IN v_menu
    LOOP
    DBMS_OUTPUT.PUT_LINE( v_menu.id_menu
    ||' ' ||v_menu.Menu_title||' '||v_menu.Menu_description
    ||' '||v_menu.Menu_price||' '||v_menu.Menu_date||' '||
    v_menu.Menu_Qty); 
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('**********************************************'); 
    DBMS_OUTPUT.PUT_LINE('*               1. Retour                    *') ;
    DBMS_OUTPUT.PUT_LINE('*               2. Quiter                    *') ;
    DBMS_OUTPUT.PUT_LINE('**********************************************') ;

    v_option := case '&choix'
        when '1' then 'action_respo'
        when '2' then 'quitter'
    end ;
    
  else 
    DBMS_OUTPUT.PUT_LINE('votre login et votre mot de passe ne sont pas correctes. Entrez des informations justes');
  end if;

end ;
/