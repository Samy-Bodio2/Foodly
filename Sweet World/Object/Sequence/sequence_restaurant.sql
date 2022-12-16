CREATE SEQUENCE id_resto_seq
START WITH 17 INCREMENT BY 1;

--CREATE OR REPLACE TRIGGER Restaurant_tg
--BEFORE INSERT ON order
--FOR EACH ROW
--BEGIN
--:new.id_resto := id_resto_seq.nextval;
--END;
--/