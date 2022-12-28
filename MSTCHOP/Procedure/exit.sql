PROMPT**************************************************BIENVENUE SUR Nom de lapplication ****************************************************
PROMPT
PROMPT      *******************************************************************       
PROMPT      |                                                                  |
PROMPT      |               1- Inscription                                     |
PROMPT      |               2- Connexion                                       |   
PROMPT      |               3- Quitter                                         |
PROMPT      ********************************************************************

accept selection PROMPT "Voulez-vous vraiment quitter ? (y/n) "
set term off
column script new_value v_script
select  case '&selection'
        when 'y' then exit
        when 'n' then '@Procedure/Case'
        when '3' then '@exit'
        else 'Procedure/Case'
        end as script
from dual;
set term on
@&v_script.
