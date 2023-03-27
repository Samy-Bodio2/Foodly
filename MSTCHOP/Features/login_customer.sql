SELECT u.username, u.password
FROM Customers c
JOIN Users u
ON(c.id_user = u.id_user)
WHERE u.username = '&username' AND u.password = format1('&password');

@Features/Features_customer/Menu_customer

set VERIFY OFF;
SELECT u.username, u.password
FROM Customers c
JOIN Users u
ON(c.id_user = u.id_user)
WHERE u.username = '&username' AND u.password = format1('&password');
set define on
column script new_value v_script
select case
        when (select count(username) From users WHERE username = '&Username' AND password = '&password' ) >= 1 then '@procedures/menu'
        else '@procedures/exit'
        end as script
from dual;
set term on
@&v_script.