set serveroutput on;
CREATE OR REPLACE FUNCTION format1(VAR Users.password%TYPE)
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

INSERT INTO Users(id_user,username,password) VALUES (0001,'Samira',format1('qwerty123'));
INSERT INTO Users(id_user,username,password) VALUES (0002,'Olivier',format1('123456789'));
INSERT INTO Users(id_user,username,password) VALUES (0003,'Zavier',format1('123ktrd89'));
INSERT INTO Users(id_user,username,password) VALUES (0004,'Robert',format1('day@!6789'));
INSERT INTO Users(id_user,username,password) VALUES (0005,'victor',format1('123@pryt9'));
INSERT INTO Users(id_user,username,password) VALUES (0006,'venezia',format1('12345#?fr'));
INSERT INTO Users(id_user,username,password) VALUES (0007,'anastasia',format1('12345$ju#'));
INSERT INTO Users(id_user,username,password) VALUES (0008,'socrate',format1('123kid@sd'));
INSERT INTO Users(id_user,username,password) VALUES (0009,'Willy',format1('123fhk@!@'));
INSERT INTO Users(id_user,username,password) VALUES (0010,'anaele',format1('123456qsz'));
INSERT INTO Users(id_user,username,password) VALUES (0011,'david',format1('1@#lmn9fd'));
INSERT INTO Users(id_user,username,password) VALUES (0012,'joel',format1('1234?POss'));
INSERT INTO Users(id_user,username,password) VALUES (0013,'nikki',format1('12349segt'));
INSERT INTO Users(id_user,username,password) VALUES (0014,'Sabrina',format1('12389fdem'));
INSERT INTO Users(id_user,username,password) VALUES (0015,'ebene',format1('12314deBD'));
INSERT INTO Users(id_user,username,password) VALUES (0016,'Nathan',format1('123lfj9vf'));
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0017,'Samy',format1('12342#jd9'),1);
INSERT INTO Users(id_user,username,password) VALUES (0018,'Aristide',format1('123@fhh9e'));
INSERT INTO Users(id_user,username,password) VALUES (0019,'Rolande',format1('123bg39ps'));
INSERT INTO Users(id_user,username,password) VALUES (0020,'Juliette',format1('1222289de'));
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0021,'Jason',format1('12888hf12'),2);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0022,'Makolo',format1('1244489id'),9);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0023,'Tatsinkou',format1('12ghd89er'),8);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0024,'Patric',format1('123899Ku9'),7);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0025,'Manuel',format1('123jdkf91'),6);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0026,'Alix',format1('12.saedds'),11);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0027,'Nguiakam',format1('12$%!@er9'),3);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0028,'Kangue',format1('15z56@ze!'),4);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0029,'Stone',format1('123hhk$#@'),5);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0030,'Dany',format1('12@!@#aze'),10);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0031,'Martina',format1('UYT#$@er3'),7);

--***********BY TATSINKOU**********--************AND SAMY BODIO*************