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

INSERT INTO Users(id_user,username,password,id_admin) VALUES (0001,'Resto_friends',format1('qwerty123'),1);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0002,'Resto_fourchette',format1('123456789'),3);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0003,'Resto_lynk',format1('123ktrd89'),4);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0004,'Resto_pizerria',format1('day@!6789'),7);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0005,'Resto_africa',format1('123@pryt9'),9);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0006,'Resto_venezia',format1('12345#?fr'),10);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0007,'Resto_food',format1('12345$ju#'),6);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0008,'Resto_socrate',format1('123kid@sd'),5);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0009,'Resto_pizza',format1('123fhk@!@'),2);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0010,'Resto_mychoice',format1('123456qsz'),8);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0011,'Resto_yamo',format1('1@#lmn9fd'),11);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0012,'Resto_hilton',format1('1234?POss'),4);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0013,'Resto_sim',format1('12349segt'),4);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0014,'Resto_plaisirs',format1('12389fdem'),1);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0015,'Resto_ebene',format1('12314deBD'),2);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0016,'Resto_pied_eau',format1('123lfj9vf'),3);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0017,'Samy',format1('12342#jd9'),8);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0018,'Aristide',format1('123@fhh9e'),8);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0019,'Rolande',format1('123bg39ps'),11);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0020,'Juliette',format1('1222289de'),10);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0021,'Jason',format1('12888hf12'),3);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0022,'Makolo',format1('1244489id'),7);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0023,'Tatsinkou',format1('12ghd89er'),2);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0024,'Patrick',format1('123899Ku9'),1);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0025,'Manuel',format1('123jdkf91'),3);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0026,'Alix',format1('12.saedds'),7);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0027,'Arnold',format1('12$%!@er9'),9);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0028,'Eliane',format1('15z56@ze!'),1);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0029,'Lesli',format1('123hhk$#@'),6),;
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0030,'Ermione',format1('12@!@#aze'),5);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0031,'Martina',format1('UYT#$@er3'),7);

--***********BY TATSINKOU**********--************AND SAMY BODIO*************