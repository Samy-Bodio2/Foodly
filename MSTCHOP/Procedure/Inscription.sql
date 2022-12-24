PROMPT**************************************************BIENVENUE SUR Nom de lapplication ****************************************************
PROMPT
PROMPT       *******************************************************************       
PROMPT       |                                                                  |
PROMPT       |               1- Administrator                                   |
PROMPT       |               2- Restaurant                                      |   
PROMPT       |               3- Customer                                        |
PROMPT       ********************************************************************

accept selection PROMPT "En tant que : "
set term off
column script new_value v_script
select  case '&selection'
        when '1' then '@Features/Features_admin/register_admin'
        when '2' then '@Features/Features_resto/register_resto'
        when '3' then '@Features/Features_customer/register_customer'
        else 'Procedure/Inscription'
        end as script
from dual;
set term on
@&v_script.