CREATE OR REPLACE TRIGGER Menu_tg
BEFORE INSERT ON  Menu 
FOR EACH ROW
BEGIN
:new.id_menu := id_menu_seq.nextval;
END;
/