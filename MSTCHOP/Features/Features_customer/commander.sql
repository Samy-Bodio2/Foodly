accept selection PROMPT "Voulez-vous commander ? (y/n) "
set term off
column script new_value v_script
select  case '&selection'
        when 'y' then '@Features/Features_customer/create_orders'
        when 'n' then '@Features/Features_customer/Menu_customer'
        else '@Features/Features_customer/Menu_customer'
        end as script
from dual;
set term on
@&v_script.
