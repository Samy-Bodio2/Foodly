PROMPT      ****************************************************************************************************************************************** 
PROMPT      **                                                                                                                                      **
PROMPT      ***                                                                                                                                    ***
PROMPT      ****                                                                                                                                  ****
PROMPT      *****                                                                                                                                *****
PROMPT      ******                                       1- Administrator                                                                       ******
PROMPT      *******                                      2- Restaurant                                                                         *******           
PROMPT      ******                                       3- Customer                                                                            ******
PROMPT      *****                                                                                                                                *****
PROMPT      ****                                                                                                                                  ****
PROMPT      ***                                                                                                                                    ***
PROMPT      **                                                                                                                                      **
PROMPT      ******************************************************************************************************************************************

accept selection PROMPT "En tant que : "
set term off
column script new_value v_script
select  case '&selection'
        when '1' then '@Features/login_admin'
        when '2' then '@Features/login_restaurant'
        when '3' then '@Features/login_customer'
        else 'Procedure/Connexion'
        end as script
from dual;
set term on
@&v_script.
