
--Awounang
declare

        v_Panier Panier.id_Panier%type;
        v_customer_id Panier.id_cust%type;
        v_Menu_Qty Menu.Menu_Qty%type;
        v_menu_id Menu.id_menu%type;
        v_id_resto Restaurant.id_resto%type;
        choice_qte choix.Quantity%type;
        v_option varchar(50);
        choix char := '&choix';

        procedure do_commande as

        begin 

        select id_Panier
        into v_Panier
        from Panier
        where id_cust=v_customer_id;

        select id_cust
        into v_customer_id
        from Customers c
        join Users u
        on c.id_user=u.id_user
        where u.username='&username'
        and u.password='&password';

        if sql%found then

        select id_resto
        into v_id_resto
        from Restaurant
        where name_resto = '&name_resto';

        select Menu_Qty
        into v_Menu_Qty
        from Menu
        where id_menu=v_menu_id;

        select Quantity
        into choice_qte
        from choix
        where id_menu = v_menu_id;

        insert into Orders
        (
                id_order,order_date,id_resto,id_Panier 
        )
        values
        (
                id_order_seq.nextval,
                to_char(sysdate,'dd/mm/yyyy'),v_id_resto,v_Panier
        );

        v_Menu_Qty := v_Menu_Qty-choice_qte;

        update Menu 
        set Menu_Qty = v_Menu_Qty; 

        delete from choix
        where id_Panier=v_Panier;

        DBMS_OUTPUT.PUT_LINE ('1. Retour');
        DBMS_OUTPUT.PUT_LINE ('2. Quitter');

        v_option := case choix
                when '1' then 'action_respo'
                when '2' then 'quitter'
        end ;

        else 
        DBMS_OUTPUT.PUT_LINE('votre login et mot de passe sont faux... entrez les a nouveau : ');
        end if;

        exception
        when no_data_found then
        DBMS_OUTPUT.PUT_LINE('aucune valeur trouvée');

    end ;

    begin
    do_commande;
    end;
/