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