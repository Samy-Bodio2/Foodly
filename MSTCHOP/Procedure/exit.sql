accept selection PROMPT "Voulez-vous vraiment quitter ? (y/n) "
set term off
column script new_value v_script
select  case '&selection'
        when 'y' then '@Procedure/exitApp'
        when 'n' then '@Procedure/Case'
        else 'Procedure/Case'
        end as script
from dual;
set term on
@&v_script.
