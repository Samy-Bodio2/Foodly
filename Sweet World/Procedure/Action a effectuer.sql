SET SERVEROUTPUT ON;

DECLARE 
    v_choix integer := &choix;
    reponse VARCHAR2(100);
    BEGIN
     reponse := CASE v_choix
     WHEN 1 THEN 'Consulter le menu du jour'
     WHEN 2 THEN 'Consulter les details du menu'
     WHEN 3 THEN 'Recherche un menu'
     WHEN 4 THEN 'Ajouter un menu au menu du jour'
     WHEN 5 THEN 'Se deconnecter'
     WHEN 6 THEN 'Quitter'
     ELSE 'choix non correct'
     END;
     DBMS_OUTPUT.put_line('que voulez vous faire : '||v_choix);
     END;
     /