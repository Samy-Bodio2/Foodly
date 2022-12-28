SET SERVEROUTPUT ON;
prompt ******************************************************************************
PROMPT      ******************************************************************************************************************************************************************************************* 
PROMPT      **                                                                                                                                                                                       **
PROMPT      ***                                                                                                                                                                                     ***
PROMPT      ****                                          Responsable restaurant
prompt      *****                                      Bienvenue Madame ou Monsieur
prompt      *****                                        Choisi une Action a effectuer   
prompt      ******                                      1. Consulter les menus du jour
prompt      *****                                       2. Recherche un menu 
prompt      **********                                  3. Ajouter un menu au menu du jour
prompt      *******                                     4. Se déconnecter
prompt      ******                                      5. Quitter                                                                                                     ****
PROMPT      *****                                                                                                                                                                                 *****
PROMPT      ******                                                                                                                                                                    ******
PROMPT      *****                                                                                                                                                                                 *****
PROMPT      ****                                                                                                                                                                                   ****
PROMPT      ***                                                                                                                                                                                     ***
PROMPT      **                                                                                                                                                                                       **
PROMPT      *******************************************************************************************************************************************************************************************

accept selection PROMPT "choisissez une option : "
set term off
column script new_value v_script
select  case '&selection'
     
     WHEN 1 THEN '@Procedure/consul_menu_jour'
     WHEN 2 THEN '@Procedure/Recherche_un_menu'
     WHEN 3 THEN '@Procedure/Ajouter_un_menu_au_menu_du_jour'
     WHEN 4 THEN '@Procedure/deconnecter'
     WHEN 5 THEN '@Procedure/exit'
     else 'Procedure/Case'
        end as script
    from dual;
set term on
@&v_script.

     /
     --- Fotso----