CREATE OR REPLACE FUNCTION format1(VAR Users.password%TYPE)
RETURN VARCHAR IS
varlower VARCHAR(50) := lower(VAR);
conk VARCHAR(20);
entier INT;
BEGIN
IF varlower like '%a%' THEN
conk := concat(conk,'Zt');
END IF;
IF varlower like '%b%' THEN
conk := concat(conk,'tQ');
END IF;
IF varlower like '%c%' THEN
conk := concat(conk,'a4');
END IF;
IF varlower like '%d%' THEN
conk := concat(conk,'p@');
END IF;
IF varlower like '%e%' THEN
conk := concat(conk,'fk');
END IF;
IF varlower like '%f%' THEN
conk := concat(conk,'bl');
END IF;
IF varlower like '%g%' THEN
conk := concat(conk,'42');
END IF;
IF varlower like '%h%' THEN
conk := concat(conk,'nu');
END IF;
IF varlower like '%i%' THEN
conk := concat(conk,'CS');
END IF;
IF varlower like '%j%' THEN
conk := concat(conk,'At');
END IF;
IF varlower like '%k%' THEN
conk := concat(conk,'e8');
END IF;
IF varlower like '%l%' THEN
conk := concat(conk,'X0');
END IF;
IF varlower like '%m%' THEN
conk := concat(conk,'Da');
END IF;
IF varlower like '%n%' THEN
conk := concat(conk,'9Y');
END IF;
IF varlower like '%o%' THEN
conk := concat(conk,'66');
END IF;
IF varlower like '%p%' THEN
conk := concat(conk,'*^');
END IF;
IF varlower like '%q%' THEN
conk := concat(conk,'#/');
END IF;
IF varlower like '%r%' THEN
conk := concat(conk,'92');
END IF;
IF varlower like '%s%' THEN
conk := concat(conk,'3.');
END IF;
IF varlower like '%t%' THEN
conk := concat(conk,'v&');
END IF;
IF varlower like '%u%' THEN
conk := concat(conk,'!}');
END IF;
IF varlower like '%v%' THEN
conk := concat(conk,'?-');
END IF;
IF varlower like '%w%' THEN
conk := concat(conk,';>');
END IF;
IF varlower like '%x%' THEN
conk := concat(conk,'+$');
END IF;
IF varlower like '%y%' THEN
conk := concat(conk,'8.');
END IF;
IF varlower like '%z%' THEN
conk := concat(conk,'P)');
END IF;
IF varlower like '%1%' THEN
conk := concat(conk,'%2');
END IF;
IF varlower like '%2%' THEN
conk := concat(conk,'/-');
END IF;
IF varlower like '%3%' THEN
conk := concat(conk,'m!');
END IF;
IF varlower like '%4%' THEN
conk := concat(conk,'<"');
END IF;
IF varlower like '%5%' THEN
conk := concat(conk,'/,');
END IF;
IF varlower like '%6%' THEN
conk := concat(conk,'A0');
END IF;
IF varlower like '%7%' THEN
conk := concat(conk,'~=');
END IF;
IF varlower like '%8%' THEN
conk := concat(conk,'zX');
END IF;
IF varlower like '%9%' THEN
conk := concat(conk,'_j');
END IF;
IF varlower like '%@%' THEN
conk := concat(conk,'qR');
END IF;
IF varlower like '%!%' THEN
conk := concat(conk,'0(');
END IF;
IF varlower like '%#%' THEN
conk := concat(conk,'~w');
END IF;
IF varlower like '%?%' THEN
conk := concat(conk,'+|');
END IF;
IF varlower like '%$%' THEN
conk := concat(conk,'{*');
END IF;
IF varlower like '%.%' THEN
conk := concat(conk,'U@');
END IF;
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
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0027,'Nguiakam',format1('12$4!@er9'),3);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0028,'Kangue',format1('15z56@ze!'),4);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0029,'Stone',format1('123hhk$#@'),5);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0030,'Dany',format1('12@!@#aze'),10);
INSERT INTO Users(id_user,username,password,id_admin) VALUES (0031,'Martina',format1('UYT#$@er3'),7);

--***********BY TATSINKOU**********--************AND SAMY BODIO*************