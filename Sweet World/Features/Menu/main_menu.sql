BEGIN
    DBMS_OUTPUT.PUT_LINE('****************Bienvenue sur Sweet World!****************');
    DBMS_OUTPUT.PUT_LINE('Bonjour, que souhaitez vous faire aujourdhui ?');
    DBMS_OUTPUT.PUT_LINE('1. Inscription');
    DBMS_OUTPUT.PUT_LINE('2. Se connecter');
    DBMS_OUTPUT.PUT_LINE('3. Quitter');


  CASE &number_selected
    WHEN 1 THEN
    @Features/Menu/register.sql
    WHEN 2 THEN
    @Features/Menu/login.sql
    WHEN 3 THEN
    DBMS_OUTPUT.PUT_LINE('Voulez vous quitter (y/n) ?');
    IF &quit = 'y' THEN
    DBMS_OUTPUT.PUT_LINE('Au revoir !');  
    EXIT;
    END IF;
    ELSE
        DBMS_OUTPUT.PUT_LINE('Vous avez choisi une option invalide !');
  END CASE;
END;
/