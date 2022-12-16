ALTER TABLE Menu
ADD ( 
		CONSTRAINT menu_price_chk  CHECK(Menu_price > 0),
        CONSTRAINT menu_quantity_chk CHECK(Menu_Qty > 0)
);