CREATE OR REPLACE PROCEDURE add_menu
v_id_menu Menu.id%TYPE,
v_Menu_title Menu.Menu_title%TYPE,
v_Menu_description Menu.Menu_description%TYPE,
v_Menu_price  Menu.Menu_price%TYPE,
v_Menu_date date Menu.Menu_date%TYPE,
v_Menu_Qty Menu.Menu_Qty%TYPE,
v_id_dish Menu.id_dish%TYPE,
v_id_seculant Menu.id_seculant%TYPE,
v_id_complement Menu.id_complement%TYPE,
v_id_resto Menu.id_resto%TYPE,
v_id_config Menu.id_config%TYPE
AS
BEGIN
INSERT INTO Menu
    (
    id_menu,
    Menu_title,
    Menu_description,
    Menu_price ,
    Menu_date ,
    Menu_Qty,
    id_dish,
    id_seculant,
    id_complement,
    id_resto,
    id_config
    )
VALUES
    (
    v_id_menu = id_menu_seq.nextval,
    v_Menu_title,
    v_Menu_description,
    v_Menu_price ,
    SYSDATE ,
    v_Menu_Qty,
    v_id_dish,
    v_id_seculant,
    v_id_complement,
    v_id_resto,
    v_id_config
    );
END;
/






