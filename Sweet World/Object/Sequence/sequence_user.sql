CREATE SEQUENCE id_user_seq
START WITH 32 INCREMENT BY 1;

--CREATE OR REPLACE TRIGGER Users_tg
--BEFORE INSERT ON orders
--FOR EACH ROW
--BEGIN
--:new.id_user := id_user_seq.nextval;
--END;
--/
