PROMPT      ****************************************************************************************************************************************** 
PROMPT      **                                           INSCRIPTION                                                                                **
PROMPT      ***                                                                                                                                    ***
PROMPT      ****                                                                                                                                  ****
PROMPT      *****                                                                                                                                *****
PROMPT      ******                                       1- Restaurant                                                                          ******
PROMPT      *******                                      2- Customer                                                                           *******           
PROMPT      ******                                                                                                                              ******
PROMPT      *****                                                                                                                                *****
PROMPT      ****                                                                                                                                  ****
PROMPT      ***                                                                                                                                    ***
PROMPT      **                                                                                                                                      **
PROMPT      ******************************************************************************************************************************************

accept selection PROMPT "En tant que : "
set term off
column script new_value v_script
select  case '&selection'
        when '1' then '@Features/Features_respo_resto/register_resto'
        when '2' then '@Features/Features_customer/register_cust'
        else 'Procedure/Inscription'
        end as script
from dual;
set term on
@&v_script.




