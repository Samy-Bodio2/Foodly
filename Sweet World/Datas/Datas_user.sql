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

INSERT INTO Users(id_user,username,password) VALUES (0001,'Resto_friends',format1('qwerty123'));
INSERT INTO Users(id_user,username,password) VALUES (0002,'Resto_fourchette',format1('123456789'));
INSERT INTO Users(id_user,username,password) VALUES (0003,'Resto_lynk',format1('123ktrd89'));
INSERT INTO Users(id_user,username,password) VALUES (0004,'Resto_pizerria',format1('day@!6789'));
INSERT INTO Users(id_user,username,password) VALUES (0005,'Resto_africa',format1('123@pryt9'));
INSERT INTO Users(id_user,username,password) VALUES (0006,'Resto_venezia',format1('12345#?fr'));
INSERT INTO Users(id_user,username,password) VALUES (0007,'Resto_food',format1('12345$ju#'));
INSERT INTO Users(id_user,username,password) VALUES (0008,'Resto_socrate',format1('123kid@sd'));
INSERT INTO Users(id_user,username,password) VALUES (0009,'Resto_pizza',format1('123fhk@!@'));
INSERT INTO Users(id_user,username,password) VALUES (0010,'Resto_mychoice',format1('123456qsz'));
INSERT INTO Users(id_user,username,password) VALUES (0011,'Resto_yamo',format1('1@#lmn9fd'));
INSERT INTO Users(id_user,username,password) VALUES (0012,'Resto_hilton',format1('1234?POss'));
INSERT INTO Users(id_user,username,password) VALUES (0013,'Resto_sim',format1('12349segt'));
INSERT INTO Users(id_user,username,password) VALUES (0014,'Resto_plaisirs',format1('12389fdem'));
INSERT INTO Users(id_user,username,password) VALUES (0015,'Resto_ebene',format1('12314deBD'));
INSERT INTO Users(id_user,username,password) VALUES (0016,'Resto_pied_eau',format1('123lfj9vf'));
INSERT INTO Users(id_user,username,password) VALUES (0017,'Samy',format1('12342#jd9'));
INSERT INTO Users(id_user,username,password) VALUES (0018,'Aristide',format1('123@fhh9e'));
INSERT INTO Users(id_user,username,password) VALUES (0019,'Rolande',format1('123bg39ps'));
INSERT INTO Users(id_user,username,password) VALUES (0020,'Juliette',format1('1222289de'));
INSERT INTO Users(id_user,username,password) VALUES (0021,'Jason',format1('12888hf12'));
INSERT INTO Users(id_user,username,password) VALUES (0022,'Makolo',format1('1244489id'));
INSERT INTO Users(id_user,username,password) VALUES (0023,'Tatsinkou',format1('12ghd89er'));
INSERT INTO Users(id_user,username,password) VALUES (0024,'Patrick',format1('123899Ku9'));
INSERT INTO Users(id_user,username,password) VALUES (0025,'Manuel',format1('123jdkf91'));
INSERT INTO Users(id_user,username,password) VALUES (0026,'Alix',format1('12.saedds'));
INSERT INTO Users(id_user,username,password) VALUES (0027,'Arnold',format1('12$%!@er9'));
INSERT INTO Users(id_user,username,password) VALUES (0028,'Eliane',format1('15z56@ze!'));
INSERT INTO Users(id_user,username,password) VALUES (0029,'Lesli',format1('123hhk$#@'));
INSERT INTO Users(id_user,username,password) VALUES (0030,'Ermione',format1('12@!@#aze'));
INSERT INTO Users(id_user,username,password) VALUES (0031,'Martina',format1('UYT#$@er3'));

--***********BY TATSINKOU**********--************AND SAMY BODIO*************