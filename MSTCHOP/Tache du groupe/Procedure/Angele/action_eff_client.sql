SET SERVEROUTPUT ON;

prompt ***********************************************************************
prompt ¤¤¤¤¤¤¤¤¤
prompt ¤¤¤¤                  BIENVENUE SUR ...                                ¤¤¤¤¤¤¤¤¤¤
prompt ¤¤                  Choisi Une Action                                       ¤¤¤¤¤¤¤¤¤
prompt ¤¤¤                                                                           ¤¤¤¤¤¤¤¤¤
prompt ¤¤¤¤                     1:Consulter le menu du jour                              ¤¤¤¤¤¤¤
prompt ¤¤¤                      2:Consulter les details du menu du jour                       ¤¤¤¤¤
prompt ¤¤                       3:Consulter les restaurants                                  ¤¤¤
prompt ¤                        4:Recherche un menu                                         ¤¤
prompt ¤¤                       5:Ajouter un menu au panier                                ¤¤¤¤¤
prompt ¤¤¤                      6:Effectuer une commande                                 ¤¤¤¤¤¤
prompt ¤¤¤¤                     7:Consulter ses commandes                              ¤¤¤¤¤¤
prompt ¤¤¤¤¤                    8:Noter un restaurant                               ¤¤¤¤¤¤¤¤
prompt ¤¤¤¤¤¤                   9:Se deconnecter                                  ¤¤¤¤¤¤¤¤
prompt ¤¤¤¤¤¤¤                   10:Quitter                                   ¤¤¤¤¤¤¤¤¤¤
prompt ¤¤¤¤¤¤¤¤¤
prompt ¤¤¤¤¤¤¤¤¤¤
prompt ***************************************************************************
  accept selection PROMPT "choisissez une option : "
  set term off
  column script new_value v_script
  select
    case '&selection'
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
      else ''
    end as script
  from dual;
   set term on
  @&v_script.                     


----ANGELE