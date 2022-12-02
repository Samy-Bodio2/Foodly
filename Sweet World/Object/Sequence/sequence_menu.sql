CREATE SEQUENCE id_menu_seq
START WITH 11 INCREMENT BY 1;

-- CREATE OR REPLACE TRIGGER menu_tg
-- BEFORE INSERT ON Menu
-- FOR EACH ROW
-- BEGIN
-- :new.id_menu := id_menu_seq.nextval;
-- END;
-- /