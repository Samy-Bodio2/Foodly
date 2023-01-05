CREATE OR REPLACE FUNCTION CALCUL
RETURN INT IS
    
    valt int not null := id_panier_seq.currval;
    
    CURSOR prix IS
    SELECT Menu_price 
    from Menu M
    join Control_Panier_Menu CPM
    on M.id_menu = CPM.id_menu
    join Panier P
    on P.id_panier = CPM.id_panier
    where P.id_panier =  valt;

    CURSOR Quant IS
    SELECT Quantity
    from Control_Panier_Menu
    where id_panier = valt;

    entier1 int; 
    entier2 int; 
    result int;
BEGIN
    OPEN prix;
    OPEN Quant;
    FETCH prix INTO entier1;
    FETCH Quant INTO entier2;

    result := entier1*entier2;
RETURN result;
END;
/