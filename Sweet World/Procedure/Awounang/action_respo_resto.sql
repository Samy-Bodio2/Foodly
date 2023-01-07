
--Awounang
set serveroutput on;
prompt ******************************************************************************
prompt ravi de te revoir
prompt Choisi une action à effectuer :
prompt 1. Ajouter un menu du jour
prompt 2. Consulter les menus du jour
prompt 3. Supprimer un menu du jour
prompt 4. Modifier un menu du jour
prompt 5. Se déconnecter
prompt 6. Quitter

declare

    v_option varchar(50);
    choix char := '&choix';

begin

    v_option := case choix
        when '1' then ' @add_menu_jour'
        when '2' then ' @consulter_menu_jour'
        when '3' then ' Supprimer un menu du jour'
        when '4' then ' @Procedure_modif_menu'
        when '5' then ' @se deconnecter'
        END;
        DBMS_OUTPUT.PUT_LINE (v_option);

end ;
/