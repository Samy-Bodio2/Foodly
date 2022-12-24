/*PROMPT**************************************************BIENVENUE SUR Nom de lapplication ****************************************************
PROMPT
PROMPT      *******************************************************************       
PROMPT      |                                                                  |
PROMPT      |               1- Inscription                                     |
PROMPT      |               2- Connexion                                       |   
PROMPT      |               3- Quitter                                         |
PROMPT      ********************************************************************

accept selection PROMPT "choisissez une option : "
set term off
column script new_value v_script
select  case '&selection'
        when '1' then '@Procedure/Inscription'
        when '2' then '@Features/Features_admin/register_admin'
        when '3' then '@exit'
        else 'Procedure/Case'
        end as script
from dual;
set term on
@&v_script.
*/
exit