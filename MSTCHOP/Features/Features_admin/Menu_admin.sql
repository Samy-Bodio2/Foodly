
PROMPT      ****************************************************************************************************************************************** 
PROMPT      **                                   MENU OF ACTIONS TO BE PERFORMED BY AN ADMINISTRATOR                                                **
PROMPT      ***                                                                                                                                    ***
PROMPT      ****                                                                                                                                  ****
PROMPT      *****                                         1- Ajouter un restaurant                                                               *****
PROMPT      ******                                        2- Consulter les restaurants                                                          ******
PROMPT      *******                                       3- Editer un restaurant                                                              *******
PROMPT      ********                                      4- Rechercher un restaurant                                                         ********
PROMPT      *********                                     5- Ajouter un menu du jour                                                         *********           
PROMPT      **********                                    6- Modifier un menu du jour                                                       **********
PROMPT      *********                                     7- Historique des commandes                                                        *********
PROMPT      ********                                      8- Editer admin                                                                     ********
PROMPT      *******                                       9- Supprimer restaurant                                                              *******
PROMPT      ******                                        10- Supprimer menu                                                                    ******
PROMPT      *****                                         11- Se deconnecter                                                                     *****
PROMPT      ****                                          12- Voir plus                                                                           ****
PROMPT      ***                                           13- Quitter                                                                              ***
PROMPT      **                                                                                                                                      **
PROMPT      ******************************************************************************************************************************************

accept selection PROMPT "Choisir une option : "
set term off
column script new_value v_script
select  case '&selection'
        when '1'  then '@Features/Features_admin/add_resto'
        when '2'  then '@Features/Features_admin/consult_resto'
        when '3'  then '@Features/Features_admin/edit_resto'
        when '4'  then '@Features/Features_admin/search_resto'
        when '5'  then '@Features/Features_admin/add_menu'
        when '6'  then '@Features/Features_admin/edit_menu'
        when '7'  then '@Features/Features_admin/Historique_des_commandes'
        when '8'  then '@Features/Features_admin/edit_admin'
        when '9'  then '@Features/Features_admin/delete_resto'
        when '10' then '@Features/Features_admin/delete_menu'
        when '11' then '@Features/Features_admin/se_deconnecter'
        when '12' then '@Features/Features_admin/MenusAction'
        when '13' then '@Procedure/exit'
        else '@Features/Features_admin/Menu_admin'
        end as script
from dual;
set term on
@&v_script.