CREATE SEQUENCE id_config_seq
START WITH 2;

--CREATE OR REPLACE TRIGGER config_tg
--BEFORE INSERT ON orders
--FOR EACH ROW
--BEGIN
--:new.id_config := id_config_seq.nextval;
--END;
--/