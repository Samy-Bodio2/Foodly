SET SERVEROUTPUT ON;

DECLARE 
    v_decide integer := &v_decide;
    reponse VARCHAR2(50);
    BEGIN
     reponse := CASE v_decide
     WHEN 1 THEN 'Consulter le menu du jour'
     WHEN 2 THEN 'Consulter les details du menu'
     WHEN 3 THEN 'Consulter les restaurants'
     WHEN 4 THEN 'Recherche un menu'
     WHEN 5 THEN 'Ajouter un menu au panier'
     WHEN 6 THEN 'Effectuer une commande'
     WHEN 7 THEN 'Consulter ses commandes'
     WHEN 8 THEN 'Noter un restaurant'
     WHEN 9 THEN 'Se deconnecter'
     WHEN 10 THEN 'Quitter'
     ELSE 'choix incorrect'
     END;
     DBMS_OUTPUT.put_line('Que voulez vous faire : '||v_decide);
     END;
     /