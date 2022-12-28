SET SERVEROUTPUT ON;
declare
    v_option char  := '&choix';
begin
    DBMS_OUTPUT.PUT_LINE ('Voulez-vous vraiment quitter ? (y/n)');
    if v_option = 'y' then 'exit' ;
    ELSE v_option = 'n' THEN 'Procedure/Case';
END;
/