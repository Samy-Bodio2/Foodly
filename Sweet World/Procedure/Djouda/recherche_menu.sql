set serveroutput on;
DECLARE
resultat varchar(50);
result varchar(50);
menus menu%ROWTYPE;
PROCEDURE select_menus(men IN VARCHAR) AS
BEGIN
    select * into menus from menu where Menu_title = men;
    DBMS_OUTPUT.PUT_LINE(menus.r_Menu_title||'  '||menus.Menu_descrption||'  '||menus.Menu_price||'  '||menus.Menu_Qty);
    DBMS_OUTPUT.PUT_LINE('---------------------------------------------------------------');
END;
BEGIN
    result := lower('&menu');
    IF result like '%poisson%' or result like '%plantain%' or result like '%mur%'
    or result like '%poison%' or result like '%bar%'
    or result like '%carpes%' or result like '%maqueraux%' or result like '%ton%'
    or result like '%nourriture%' or result like '%braise%' THEN
    resultat := 'poisson braise';
    select_menus(resultat);
    END IF;
    IF result like '%ero%' or result like '%eru%' or result like '%tapioca%' or result like '%peau%'
    or result like '%hero%' or result like '%foufou%'
    or result like '%viande%' or result like '%boeuf%'
    or result like '%heru%'
    resultat := 'eru foufou viande de boeuf';
    select_menus(resultat);
    END IF;
    IF result like '%haricot%' or result like '%haricot sautes%' or result like '%poisson frais%'
    or result like '%saute%' or result like '%plantain mur%' or result like '%haricot blanc%'
    or result like '%haricot rouge%'
    resultat := 'haricot sautes';
    select_menus(resultat);
    END IF;
    IF result like '%riz%' or result like '%tomate%' or result like '%riz sauce tomate%'
    or result like '%RIZ%'
    or result like '%elena tomato%' or result like '%sauce%' or result like '%riz blanc%'
    or result like '%riz sauce%' or result like '%sauce tomate%'
    resultat := 'riz sauce tomate';
    select_menus(resultat);
    END IF;
    IF result like '%koki%' or result like '%coci%' or result like '%coqi%' or result like '%coqui%'
    or result like '%koci%' or result like '%quoki%' or result like '%nkoki%' or result like '%ncoki%'
    or result like '%coki%' or result like '%nqoki%' or result like '%nquoki%' THEN
    resultat := 'Koki';
    select_menus(resultat);
    END IF;
    IF result like '%poulet%' or result like '%pommes%'
    or result like '%poulet pane%' or result like '%pane%'
    or result like '%cuisse poulet%' or result like '%pommes pane%'
    or result like '%viande %' or result like '%viande poulet%'THEN
    resultat := 'Poulet pane';
    select_menus(resultat);
    END IF;
END;
/
----djouda patric