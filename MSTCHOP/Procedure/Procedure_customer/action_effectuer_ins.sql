PROMPT**************************************************"BIENVENUE SUR Nom de l'application" ****************************************************
PROMPT
PROMPT       *******************************************************************       
PROMPT       |                1:Consulter le menu du jour                      |
PROMPT       |                2:Consulter les details du menu du jour          |
PROMPT       |                3:Consulter les restaurants                      |
PROMPT       |                4:Recherche un menu                              |
PROMPT       |                5:Ajouter un menu au panier                      |
PROMPT       |                6:Effectuer une commande                         |
PROMPT       |                7:Consulter ses commandes                        |
PROMPT       |                8:Noter un restaurant                            |
PROMPT       |                9:Se deconnecter                                 |
PROMPT       |                10:Quitter                                       |
PROMPT       ********************************************************************

accept selection PROMPT "choisissez une option : "
set term off
column script new_value v_script
select  case '&selection'
        when '1' then '@'
        when '2' then '@'
        when '3' then '@'
        when '4' then '@'
        when '5' then '@'
        when '6' then '@'
        when '7' then '@'
        when '8' then '@'
        when '9' then '@'
        when '10' then '@'
        else 'Procedure/Case'
        end as script
from dual;
set term on
@&v_script.