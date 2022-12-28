
--Awounang
declare

    v_dish_id Dish.id_dish%type;
    v_seculant_id Seculant.id_seculant%type;
    v_id_garnish Complement.id_complement%type;
    v_id_resto Restaurant.id_resto%type;
    v_option varchar(50);
    choix char ;
    procedure add_menu as

  begin

    select id_resto
        into v_id_resto
        from Restaurant r
        join Users u
        on r.id_user=u.id_user
        where u.username='&username';

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


    insert into Menu 
    (
        id_menu, Menu_title, Menu_description,
        Menu_price, Menu_date, Menu_Qty, id_dish,
        id_seculant, id_complement, id_resto, id_config
    )
    values
    (
        id_menu_seq.nextval,'&titre','&description',
        &price, to_date(sysdate,'dd-mm-yy'),
        &quantite, v_dish_id, v_seculant_id,
        v_id_garnish, v_id_resto, 1
    );

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

  exception
  when no_data_found then
  DBMS_OUTPUT.PUT_LINE('aucune valeur trouvée');

  end ;
begin
add_menu;
end;
/