CREATE or REPLACE Function prixtotal
CURSOR Menuprice IS
select Menu_price from Menu;
CURSOR comarge IS
select marge from 