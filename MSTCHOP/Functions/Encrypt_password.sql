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
conk := concat(conk,'.j');
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