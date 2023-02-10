
PROMPT      ****************************************************************************************************************************************** 
PROMPT      **                                   MENU OF ACTIONS TO BE PERFORMED BY AN ADMINISTRATOR                                                **
PROMPT      ***                                                                                                                                    ***
PROMPT      ****                                                                                                                                  ****
PROMPT      *****                                         1- Ajouter un plat                                                                     *****
PROMPT      ******                                        2- Supprimer un plat                                                                  ******
PROMPT      *******                                       3- Editer un plat                                                                    *******
PROMPT      ********                                      4- Ajouter un complement                                                            ********
PROMPT      *********                                     5- Supprimer un complement                                                         *********           
PROMPT      **********                                    6- Editer un complement                                                           **********
PROMPT      *********                                     7- Ajouter un seculant                                                             *********
PROMPT      ********                                      8- Supprimer un seculant                                                            ********
PROMPT      *******                                       9- Editer un seculant                                                                *******
PROMPT      ******                                        10- Consulter                                                                         ******
PROMPT      *****                                         11- Se deconnecter                                                                     *****
PROMPT      ****                                          12- Retour                                                                              ****
PROMPT      ***                                                                                                                                    ***
PROMPT      **                                                                                                                                      **
PROMPT      ******************************************************************************************************************************************

accept selection PROMPT "Choisir une option : "
set term off
column script new_value v_script
select  case '&selection'
        when '1'  then '@Features/Features_admin/add_dish'
        when '2'  then '@Features/Features_admin/delete_dish'
        when '3'  then '@Features/Features_admin/edit_dish'
        when '4'  then '@Features/Features_admin/add_garnish'
        when '5'  then '@Features/Features_admin/delete_garnish'
        when '6'  then '@Features/Features_admin/edit_garnish'
        when '7'  then '@Features/Features_admin/add_seculant'
        when '8'  then '@Features/Features_admin/delete_seculant'
        when '9'  then '@Features/Features_admin/edit_seculant'
        when '10' then '@Features/Features_admin/Consulter'
        when '11' then '@Features/Features_admin/se_deconnecter'
        when '12' then '@Features/Features_admin/Menu_admin'
        else '@Features/Features_admin/MenusAction'
        end as script
from dual;
set term on
@&v_script.