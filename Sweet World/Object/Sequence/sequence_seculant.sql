CREATE SEQUENCE id_seculant_seq
START WITH 9 INCREMENT BY 1;

-- CREATE OR REPLACE TRIGGER seculant_tg
-- BEFORE INSERT ON Seculant
-- FOR EACH ROW
-- BEGIN
-- :new.id_seculant := id_seculant_seq.nextval;
-- END;
