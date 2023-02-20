PROMPT      ****************************************************************************************************************************************** 
PROMPT      **                                                                                                                                      **
PROMPT      ***                                   MENU OF ACTIONS TO BE PERFORMED BY AN CUSTOMERS                                                  ***
PROMPT      ****                                                                                                                                  **** 
PROMPT      *****                                           1- Consulter le menu du jour                                                         *****
PROMPT      ******                                          2- Consulter les details dun menu                                                   ******
PROMPT      *******                                         3- Consulter les restaurants                                                       *******
PROMPT      ********                                        4- Rechercher un menu                                                             ********
PROMPT      *********                                       5- Rechercher un plat                                                            *********   
PROMPT      **********                                      6- Ajouter un menu au panier                                                    **********
PROMPT      *********                                       7- Consulter des commandes                                                       *********
PROMPT      ********                                        8- Noter un restaurant                                                            ********                                             
PROMPT      *******                                         9- Se deconnecter                                                                  *******
PROMPT      ******                                         10- Quitter                                                                          ******
PROMPT      *****                                                                                                                                *****
PROMPT      ****                                                                                                                                  ****   
PROMPT      ***                                                                                                                                    ***
PROMPT      **                                                                                                                                      **                                                                                
PROMPT      ******************************************************************************************************************************************

accept selection PROMPT "Que voulez-vous faire ? : "
set term off
column script new_value v_script
select  case '&selection'
        when '1' then '@Features/Features_customer/consult_menu'
        when '2' then '@Features/Features_customer/consult_detail_menu'
        when '3' then '@Features/Features_customer/consult_resto'
        when '4' then '@Features/Features_customer/search_menu'
        when '5' then '@Features/Features_customer/search_dish'
        when '6' then '@Features/Features_customer/add_menu_in_panier'
        when '7' then '@Features/Features_customer/consult_order'
        when '8' then '@Features/Features_customer/note_resto'
        when '9' then '@Features/Features_customer/se_deconnecter'
        when '10' then '@Procedure/Case'
        else '@Features/Features_customer/Menu_customer'
        end as script
from dual;
set term on
@&v_script.
