
--Awounang
set serveroutput on;
declare
    v_id_panier Panier.id_panier%type;
    v_id_cust Panier.id_cust%type;
    v_option char  := '&choix';
    choix1 char  := '&choix';

begin

    select distinct id_panier
    into v_id_panier
    from Panier
    where id_cust=v_id_cust;

    select id_cust
    into v_id_cust
    from Customers c
    join Users u
    on c.id_user=u.id_user
    where u.username='&userName'
    and u.password='&passwd';

    IF sql%found THEN

    insert into Choix
    (
       id_panier, id_menu, Quantity
    )
    values
    (
         v_id_panier, &menu_id, '&quantite'
    );

    DBMS_OUTPUT.PUT_LINE ('Voulez-vous passer votre commande ? (y/n)');
    if choix1 = 'y' 
    then DBMS_output.put_line('Commande effectuée');
    elsif choix1 = 'n'
    then
        DBMS_OUTPUT.PUT_LINE ('1. Ajouter un autre menu au panier');
        DBMS_OUTPUT.PUT_LINE ('2. Retour');
        DBMS_OUTPUT.PUT_LINE ('3. Quitter');
    Else
        if v_option = '1' then DBMS_output.put_line('Ajouter un autre menu au panier');
        elsif v_option = '2' then DBMS_output.put_line('Retour');
        elsif v_option = '3' then DBMS_output.put_line('Quitter');
        else DBMS_output.put_line('Vous devez faire un choix valide');
        end if;
    end if;

    else 
    DBMS_OUTPUT.PUT_LINE('votre login et votre mot de passe ne sont pas correctes. Entrez des informations justes');
    end if;

    exception
    when no_data_found then
    DBMS_OUTPUT.PUT_LINE('aucune valeur trouvée');

end;
/