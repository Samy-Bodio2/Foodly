set serveroutput on;
CREATE FUNCTION format1(VAR Users.password%TYPE)
RETURN VARCHAR IS
conk VARCHAR(20);
entier INT;
BEGIN
entier := length(VAR);
FOR i IN 1..entier LOOP

    conk := concat(conk,'*');

END LOOP;
RETURN conk;
END;
/

INSERT INTO ADMIN(id_admin,name_admin,pwd_admin) VALUES (1,'Samy Bodio',format1('qwerty123'));
INSERT INTO ADMIN(id_admin,name_admin,pwd_admin) VALUES (2,'Silha Jason',format1('123456789'));
INSERT INTO ADMIN(id_admin,name_admin,pwd_admin) VALUES (3,'Nguiakam Angele',format1('123ktrd89'));
INSERT INTO ADMIN(id_admin,name_admin,pwd_admin) VALUES (4,'Kangue Loic',format1('day@!6789'));
INSERT INTO ADMIN(id_admin,name_admin,pwd_admin) VALUES (5,'Awounang Stone',format1('123@pryt9'));
INSERT INTO ADMIN(id_admin,name_admin,pwd_admin) VALUES (6,'Fotso Manuel',format1('12345#?fr'));
INSERT INTO ADMIN(id_admin,name_admin,pwd_admin) VALUES (7,'Djouda Patric',format1('12345$ju#'));
INSERT INTO ADMIN(id_admin,name_admin,pwd_admin) VALUES (8,'Tatsinkou Crispin',format1('123kid@sd'));
INSERT INTO ADMIN(id_admin,name_admin,pwd_admin) VALUES (9,'Makolo Ekoka',format1('123fhk@!@'));
INSERT INTO ADMIN(id_admin,name_admin,pwd_admin) VALUES (10,'Kenchoung Sadio',format1('123456qsz'));
INSERT INTO ADMIN(id_admin,name_admin,pwd_admin) VALUES (11,'Motso ALix',format1('1@#lmn9fd'));