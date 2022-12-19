SET SERVEROUTPUT ON;
begin
  DBMS_OUTPUT.PUT_LINE('1:Consulter le menu du jour');
  DBMS_OUTPUT.PUT_LINE('2:Consulter les details du menu du jour');
    DBMS_OUTPUT.PUT_LINE('3:Consulter les restaurants');
    DBMS_OUTPUT.PUT_LINE('4:Recherche un menu');
    DBMS_OUTPUT.PUT_LINE('5:Ajouter un menu au panier');
    DBMS_OUTPUT.PUT_LINE('6:Effectuer une commande');
    DBMS_OUTPUT.PUT_LINE('7:Consulter ses commandes');
    DBMS_OUTPUT.PUT_LINE('8:Noter un restaurant');
    DBMS_OUTPUT.PUT_LINE('9:Se deconnecter');
    DBMS_OUTPUT.PUT_LINE('10:Quitter');
    case &number_selected
      when 1 then
      @
        when 2 then 
      @
        when 3 then
        @
            when 4 then
        @
            when 5 then
        @
            when 6 then
            @
            when 7 then
            @
            when 8 then
            @
            when 9 then
            @
            when 10 then
            @
            else
            DBMS_OUTPUT.PUT_LINE('Erreur de saisie');
                end;
                DBMS_OUTPUT.PUT_LINE('Que voulez vous faire :');
                     
end;
/