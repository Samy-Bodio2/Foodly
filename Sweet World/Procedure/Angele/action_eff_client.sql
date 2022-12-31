SET SERVEROUTPUT ON;

prompt ***********************************************************************
prompt ¤¤¤¤¤¤¤¤¤
prompt ¤¤¤¤¤¤¤¤      BIENVENUE SUR ...                           ¤¤¤¤¤¤¤¤¤¤
prompt ¤¤¤¤¤¤          Choisi Une Action                           ¤¤¤¤¤¤¤¤¤
prompt ¤¤¤¤¤                                                          ¤¤¤¤¤¤¤¤¤
prompt ¤¤¤¤           1:Consulter le menu du jour                         ¤¤¤¤¤¤¤
prompt ¤¤¤            2:Consulter les details du menu du jour               ¤¤¤¤¤
prompt ¤¤             3:Consulter les restaurants                                  ¤¤¤
prompt ¤              4:Recherche un menu                                         ¤¤
prompt ¤¤             5:Ajouter un menu au panier                                ¤¤¤¤¤
prompt ¤¤¤            6:Effectuer une commande                                 ¤¤¤¤¤¤
prompt ¤¤¤¤           7:Consulter ses commandes                              ¤¤¤¤¤¤
prompt ¤¤¤¤¤          8:Noter un restaurant                               ¤¤¤¤¤¤¤¤
prompt ¤¤¤¤¤¤         9:Se deconnecter                                  ¤¤¤¤¤¤¤¤
prompt ¤¤¤¤¤¤¤        10:Quitter                                   ¤¤¤¤¤¤¤¤¤¤
prompt ¤¤¤¤¤¤¤¤¤
prompt ¤¤¤¤¤¤¤¤¤¤
prompt ***************************************************************************
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
      @Procedure/consult_resto
      when 2 then 
      @Procedure/consult_resto
      when 3 then
      @Procedure/consult_resto
      when 4 then
      @Procedure/consult_resto
      when 5 then
      @Procedure/consult_resto
      when 6 then
      @Procedure/consult_resto
      when 7 then
      @Procedure/consult_resto
      when 8 then
      @Procedure/consult_resto
      when 9 then
      @Procedure/consult_resto
      when 10 then
      @Procedure/consult_resto
      else
      DBMS_OUTPUT.PUT_LINE('Erreur de saisie');
    end;
       DBMS_OUTPUT.PUT_LINE('Que voulez vous faire :');
                     
end;
/