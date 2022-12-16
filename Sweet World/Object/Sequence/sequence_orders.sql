CREATE SEQUENCE id_order_seq
START WITH 30 INCREMENT BY 1;

--CREATE OR REPLACE TRIGGER order_tg
--BEFORE INSERT ON Orders
--FOR EACH ROW
--BEGIN
--:new.id_order := id_order_seq.nextval;
--END;
--/