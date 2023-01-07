set serveroutput on;
DECLARE
result23 varchar(50);
result varchar(50);
restau Restaurant%ROWTYPE;
PROCEDURE select_restau(rst IN VARCHAR) AS
BEGIN
    select * into restau from Restaurant where name_resto = rst;
    DBMS_OUTPUT.PUT_LINE(restau.name_resto||'  '||restau.Description||'  '||restau.phone_number||'  '||restau.resto_address);
    DBMS_OUTPUT.PUT_LINE('---------------------------------------------------------------');
END;
BEGIN
    result := lower('&Restaurant');
    IF result like '%burger%' or result like '%sandwich%' or result like '%steak%'
    or result like '%friend%' or result like '%food%'
    or result like '%restaurant%' or result like '%viande%' or result like '%dla%'
    or result like '%douala%' or result like '%bonamoussadi%' or result like '%fast%'
    or result like '%nourriture%' or result like '%snack%' THEN
    result23 := 'Friends Food';
    select_restau(result23);
    END IF;
    IF result like '%restaurant%'
    or result like '%fourchette%' or result like '%dla%'
    or result like '%5%' or result like '%chic%'
    or result like '%douala%' or result like '%bonamoussadi%'
    or result like '%nourriture%' or result like '%luxe%'THEN
    result23 := '5 Fourchettes';
    select_restau(result23);
    END IF;
    IF result like '%restaurant%' or result like '%dla%'
    or result like '%fourchette%' or result like '%boisson%'
    or result like '%douala%' or result like '%bonanjo%'
    or result like '%lynk%'
    or result like '%nourriture%' or result like '%bar%'THEN
    result23 := 'Lynk';
    select_restau(result23);
    END IF;
    IF result like '%restaurant%' or result like '%pizza%' or result like '%margarita%' or result like '%patte%'
    or result like '%croutte%' or result like '%italie%'
    or result like '%douala%' or result like '%bonamoussadi%'
    or result like '%la%'
    or result like '%europe%' or result like '%dla%'
    or result like '%nourriture%' or result like '%pizzeria%'THEN
    result23 := 'LA PIZZERIA';
    select_restau(result23);
    END IF;
    IF result like '%restaurant%' or result like '%africa%' or result like '%bierre%'
    or result like '%afro%' or result like '%tradition%' or result like '%dla%'
    or result like '%saga%'
    or result like '%douala%' or result like '%bonamoussadi%'
    or result like '%nourriture%' or result like '%afrique%'THEN
    result23 := 'Saga Africa';
    select_restau(result23);
    END IF;
    IF result like '%restaurant%' or result like '%afri%' or result like '%pizza%'
    or result like '%italie%' or result like '%vene%' or result like '%dla%'
    or result like '%douala%' or result like '%yassa%'
    or result like '%nourriture%' or result like '%europe%'THEN
    result23 := 'L Italien-Piccola Venezia';
    select_restau(result23);
    END IF;
    IF result like '%restaurant%' or result like '%afri%' or result like '%bierre%'
    or result like '%afro%' or result like '%tradition%' or result like '%met%'
    or result like '%traditionnal%' or result like '%food%'
    or result like '%douala%' or result like '%bonaberi%' or result like '%dla%'
    or result like '%nourriture%' or result like '%afrique%'THEN
    result23 := 'Traditional-food';
    select_restau(result23);
    END IF;
    IF result like '%restaurant%' or result like '%le%'
    or result like '%yde%' or result like '%socrate%'
    or result like '%yaounde%' or result like '%Mokolo%'
    or result like '%nourriture%' or result like '%luxe%'THEN
    result23 := 'Le Socrate';
    select_restau(result23);
    END IF;
    IF result like '%restaurant%' or result like '%pizza%' or result like '%margarita%' or result like '%patte%'
    or result like '%croutte%' or result like '%italie%'
    or result like '%douala%' or result like '%akwa%' or result like '%c%'
    or result like '%europe%' or result like '%dla%' or result like '%c-pizza%'
    or result like '%nourriture%' or result like '%pizzaria%'THEN
    result23 := 'C-PIZZA';
    select_restau(result23);
    END IF;
    IF result like '%burger%' or result like '%k%' 
    or result like '%MyChoice%' or result like '%sandwich%' or result like '%steak%'
    or result like '%restaurant%' or result like '%viande%'
    or result like '%buea%' or result like '%messasi%' or result like '%fast%'
    or result like '%food%' or result like '%nourriture%' or result like '%snack%' THEN
    result23 := 'K MyChoice';
    select_restau(result23);
    END IF;
    IF result like '%burger%' or result like '%yamo%'
    or result like '%tchop%' or result like '%sandwich%' or result like '%steak%'
    or result like '%restaurant%' or result like '%viande%' or result like '%logbessou%'
    or result like '%douala%' or result like '%messasi%' or result like '%fast%'
    or result like '%food%'
    or result like '%nourriture%' or result like '%snack%' THEN
    result23 := 'Tchop et Yamo';
    select_restau(result23);
    END IF;
    IF result like '%restaurant%' or result like '%hilton%'
    or result like '%fourchette%' or result like '%dla%'
    or result like '%5%' or result like '%chic%'
    or result like '%douala%' or result like '%bonanjo%'
    or result like '%nourriture%' or result like '%luxe%' THEN
    result23 := 'Hilton';
    select_restau(result23);
    END IF;
    IF result like '%restaurant%' or result like '%bierre%'
    or result like '%afro%' or result like '%tradition%' or result like '%met%'
    or result like '%traditionnal%' or result like '%food%'
    or result like '%sim%' or result like '%akwa%'
    or result like '%douala%' or result like '%dla%'
    or result like '%nourriture%' or result like '%afrique%' THEN
    result23 := 'Restaurant SIM';
    select_restau(result23);
    END IF;
    IF result like '%restaurant%' or result like '%pizza%' or result like '%margarita%' or result like '%patte%'
    or result like '%croutte%' or result like '%italie%'
    or result like '%douala%' or result like '%kribi%' or result like '%le%'
    or result like '%la%' or result like '%plaisir%' or result like '%gout%'
    or result like '%europe%' or result like '%dla%'
    or result like '%nourriture%' or result like '%pizzeria%'THEN
    result23 := 'Le plaisir du Gout Pizzeria';
    select_restau(result23);
    END IF;
    IF result like '%restaurant%' or result like '%bierre%'
    or result like '%afro%' or result like '%tradition%' or result like '%met%'
    or result like '%traditionnal%' or result like '%food%'
    or result like '%sim%' or result like '%kribi%' or result like '%afrique%'
    or result like '%douala%' or result like '%dla%'
    or result like '%nourriture%' or result like '%afri%' THEN
    result23 := 'Ebene plus';
    select_restau(result23);
    END IF;
    IF result like '%restaurant%' or result like '%poisson%' or result like '%kribi%'
    or result like '%plage%'
    or result like '%pied%' or result like '%dans%' or result like '%eau%' or result like '%marin%'
    or result like '%douala%' or result like '%crabe%' THEN
    result23 := 'Pieds dans l eau';
    select_restau(result23);
    END IF;  
END;
/

---------------samy bodio