CREATE PROCEDURE Menu_Detail
v.Menu_title  Menu.Menu_title %TYPE,
v.Menu_description Menu.Menu_description %TYPE,
v.Menu_price Menu.Menu_price %TYPE,
v.Menu_date Menu.Menu_date %TYPE,
v.Menu_Qty Menu.Menu_Qty %TYPE,
v.Name_dish Dish.Name_dish %TYPE,
v.Name_Seculant Seculant.Name_Seculant %TYPE,
v.Name_garnish Garnish.Name_garnish %TYPE,
v.name_resto Restaurant.name_resto %TYPE,
begin
  select 
    Menu_title,
    Menu_description,
    Menu_price,
    Menu_date,
    Menu_Qty,
    Name_dish,
    Name_Seculant,
    Name_garnish,
    name_resto
    INTO
    v.Menu_title,
    v.Menu_description,
    v.Menu_price,
    v.Menu_date,
    v.Menu_Qty,
    v.Name_dish,
    v.Name_Seculant,
    v.Name_garnish,
    v.name_resto
    FROM Menu
    JOIN Dish
    On Menu.id_dish = Dish.id_dish
    JOIN Seculant
    On Menu.id_seculant = Seculant.id_seculant
    JOIN Garnish
    On Menu.id_garnish = Garnish.id_garnish
    JOIN Restaurant
    On Menu.id_resto = Restaurant.id_resto
       
end;
/
 begin
    Menu_Detail(
        v.Menu_title,
        v.Menu_description,
        v.Menu_price,
        v.Menu_date,
        v.Menu_Qty,
        v.Name_dish,
        v.Name_Seculant,
        v.Name_garnish,
        v.name_resto
        );
    DBMS_OUTPUT.PUT_LINE('Menu_title: ' || v.Menu_title);
    DBMS_OUTPUT.PUT_LINE('Menu_description: ' || v.Menu_description);
    DBMS_OUTPUT.PUT_LINE('Menu_price: ' || v.Menu_price);
    DBMS_OUTPUT.PUT_LINE('Menu_date: ' || v.Menu_date);
    DBMS_OUTPUT.PUT_LINE('Menu_Qty: ' || v.Menu_Qty);
    DBMS_OUTPUT.PUT_LINE('Name_dish: ' || v.Name_dish);
    DBMS_OUTPUT.PUT_LINE('Name_Seculant: ' || v.Name_Seculant);
    DBMS_OUTPUT.PUT_LINE('Name_garnish: ' || v.Name_garnish);
    DBMS_OUTPUT.PUT_LINE('name_resto: ' || v.name_resto);
 end;
 /
 ---ANGELE