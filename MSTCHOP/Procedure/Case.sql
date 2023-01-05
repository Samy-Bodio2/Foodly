PROMPT      ****************************************************************************************************************************************** 
PROMPT      **                                                                                                                                      **
PROMPT      ***                                                                                                                                    ***
PROMPT      ****                                          BIENVENUE SUR Nom de lapplication                                                       ****
PROMPT      *****                                                                                                                                *****
PROMPT      ******                                       1- INSCRIPTION                                                                         ******
PROMPT      *******                                      2- CONNEXION                                                                          *******           
PROMPT      ******                                       3- QUITTER                                                                             ******
PROMPT      *****                                                                                                                                *****
PROMPT      ****                                                                                                                                  ****
PROMPT      ***                                                                                                                                    ***
PROMPT      **                                                                                                                                      **
PROMPT      ******************************************************************************************************************************************

accept selection PROMPT "choisissez une option : "
set term off
column script new_value v_script
select  case '&selection'
        when '1' then '@Procedure/Inscription'
        when '2' then '@Procedure/connexion'
        when '3' then '@exit'
        else 'Procedure/Case'
        end as script
from dual;
set term on
@&v_script.

                