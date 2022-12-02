CREATE SEQUENCE id_panier_seq
START WITH 30 INCREMENT BY 1;

--CREATE OR REPLACE TRIGGER panier_tg
--BEFORE INSERT ON Panier
--FOR EACH ROW
--BEGIN
--:new.id_panier := id_panier_seq.nextval;
--END;
--/