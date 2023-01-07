CREATE OR REPLACE FUNCTION format1(VAR Users.password%TYPE)
RETURN VARCHAR IS
conk VARCHAR(20);
entier INT;
BEGIN
entier := length(VAR);
CASE VAR
when 'qwerty123' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '123456789' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '123ktrd89' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when 'day@!6789' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '123@pryt9' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '12345#?fr' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '12345$ju#' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '123kid@sd' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '123fhk@!@' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '123456qsz' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '1@#lmn9fd' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '1234?POss' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '12389fdem' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '12314deBD' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '123lfj9vf' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '12342#jd9' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '123@fhh9e' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '123bg39ps' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '12888hf12' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '1244489id' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '12ghd89er' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '12888hf12' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '12ghd89er' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '123jdkf91' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '12.saedds' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '12$%!@er9' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '15z56@ze!' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '123hhk$#@' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when '12@!@#aze' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
when 'UYT#$@er3' THEN
    FOR i IN 1..entier LOOP

        conk := concat(conk,'*');

    END LOOP;
RETURN conk;
ELSE 
RETURN NULL;
END CASE;
END;
/

select * from USERS
where username='&username' and password=format1('&pwd');