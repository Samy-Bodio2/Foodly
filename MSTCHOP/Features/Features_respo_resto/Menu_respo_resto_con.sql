PROMPT      ****************************************************************************************************************************************** 
PROMPT      **                                                                                                                                      **
PROMPT      ***                                           1- Consulter le menu du jour                                                             ***
PROMPT      ****                                          2- Consulter les details dun menu                                                       ****
PROMPT      *****                                         3- Rechercher un menu                                                                  *****
PROMPT      ******                                        4- Rechercher un plat                                                                 ******
PROMPT      *******                                       5- Ajouter un menu du jour                                                           *******   
PROMPT      ******                                        6 Se deconnecter                                                                      ******
PROMPT      *****                                         7- Quitter                                                                             *****
PROMPT      ****                                                                                                                                  ****
PROMPT      ***                                                                                                                                    ***                                             
PROMPT      **                                                                                                                                      **                                                                                
PROMPT      ******************************************************************************************************************************************

accept selection PROMPT "Que voulez-vous faire ? : "
set term off
column script new_value v_script
select  case '&selection'
        when '1' then '@Features/Features_respo_resto/consult_menu'
        when '2' then '@Features/Features_respo_resto/consult_detail_menu'
        when '3' then '@Features/Features_respo_resto/search_menu'
        when '4' then '@Features/Features_respo_resto/search_plat'
        when '5' then '@Features/Features_respo_resto/add_menu_j'
        when '6' then '@Features/Features_respo_resto/se_deconnecter'
        when '7' then '@Procedure/Case'
        else '@Features/Features_respo_resto/Menu_respo_resto_con'
        end as script
from dual;
set term on
@&v_script.

