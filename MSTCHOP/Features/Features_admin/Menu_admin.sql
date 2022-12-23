PROMPT**************************************************ACTION A EFFECTUER ****************************************************
PROMPT
PROMPT       *******************************************************************       
PROMPT       |                                                                  |
PROMPT       |               1- Ajouter un restaurant                           |
PROMPT       |               2- Consulter les restaurants                       |   
PROMPT       |               3- Editer un restaurant                            |
PROMPT       |               4- Rechercher un restaurant                        |
PROMPT       |               5- Ajouter un menu du jour                         |
PROMPT       |               6- Modifier un menu du jour                        |
PROMPT       |               7- Historique des commandes                        |
PROMPT       |               8- Se deconnecter                                  |
PROMPT       |               9- Quitter                                         |
PROMPT       ********************************************************************

accept selection PROMPT "Que voulez-vous faire ? : "
set term off
column script new_value v_script
select  case '&selection'
        when '1' then '@Features/Features_admin/add_resto'
        when '2' then '@Features/Features_admin/consul_resto'
        when '3' then '@Features/Features_admin/edit_resto'
        when '4' then '@Features/Features_admin/search_resto'
        when '5' then '@Features/Features_admin/add_menu'
        when '6' then '@Features/Features_admin/edit_menu'
        when '7' then '@Features/Features_admin/Historique des commandes'
        when '8' then '@Features/Features_admin/se_deconnecter'
        when '9' then '@Procedure/Case'
        else '@Features/Features_admin/Menu_admin'
        end as script
from dual;
set term on
@&v_script.