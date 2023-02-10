<<<<<<< HEAD
CREATE OR REPLACE TRIGGER order_tg
BEFORE INSERT ON orders
=======
CREATE OR REPLACE TRIGGER admin_tg
BEFORE INSERT ON Admin
>>>>>>> c36d098ac74b4b5ee9a1ffaaa77e87a37448e0a6
FOR EACH ROW
BEGIN
:new.order_number := order_number_seq.nextval;
END;
/


CREATE OR REPLACE TRIGGER client_tg
BEFORE INSERT ON clients
FOR EACH ROW
BEGIN
:new.client_id := client_id_seq.nextval;
END;
/

CREATE OR REPLACE TRIGGER packages_tg
AFTER UPDATE ON packages
FOR EACH ROW
BEGIN
    IF :old.statute = 'Delivred' OR :old.statute = 'Stopped'
        THEN  UPDATE packages SET end_date = SYSDATE WHERE package_id = :old.package_id;
END IF;
END;
/

CREATE OR REPLACE TRIGGER warehouse_tg
BEFORE INSERT ON warehouses
FOR EACH ROW
BEGIN
:new.warehouse_id := warehouse_id_seq.nextval;
END;
/

CREATE OR REPLACE TRIGGER sotre_tg
BEFORE INSERT ON stores
FOR EACH ROW
BEGIN
:new.store_id := store_id_seq.nextval;
END;
/

CREATE OR REPLACE TRIGGER article_tg
BEFORE INSERT ON articles
FOR EACH ROW
BEGIN
:new.article_id := article_id_seq.nextval;
END;
/

CREATE OR REPLACE TRIGGER warranty_tg
BEFORE INSERT ON warranties
FOR EACH ROW
BEGIN
:new.warranty_id := warranty_id_seq.nextval;
END;
/

CREATE OR REPLACE TRIGGER installation_tg
BEFORE INSERT ON installations
FOR EACH ROW
BEGIN
:new.installation_id := installation_id_seq.nextval;
END;
/

CREATE OR REPLACE TRIGGER user_tg
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
:new.user_id := user_id_seq.nextval;
END;
/

CREATE OR REPLACE TRIGGER employee_tg
BEFORE INSERT ON employees
FOR EACH ROW
BEGIN
INSERT INTO users(user_name, type, user_profile) VALUES (:new.name, 'employee', :new.profile);
:new.user_id := user_id_seq.currval;
:new.employee_id := employee_id_seq.nextval;
END;
/

CREATE OR REPLACE TRIGGER package_id_tg
BEFORE INSERT ON packages
FOR EACH ROW
BEGIN
:new.package_id := package_id_seq.nextval;
END;
/


-- CREATE OR REPLACE PROCEDURE add_article_order
-- (  p_order_number    IN    order_item.order_number%type
-- , p_article_id  IN   order_item.article_id%type
-- , p_quantity     IN  NUMBER
-- , p_service_id   IN       order_item.service_id%type
-- )
-- IS
-- BEGIN
--     INSERT INTO order_item(order_number, article_id, service_id)
--     VALUES
--     (   p_order_number, 
--         p_article_id, 
--         CASE WHEN p_service_id = (SELECT service_id FROM article_service WHERE article_id = p_article_id AND service_id = p_service_id) THEN p_service_id
--         ELSE null END);
--     INSERT INTO package_item (order_number, article_id, service_id, package_id, quantity) VALUES (p_order_number, p_article_id, p_service_id, p_order_number, p_quantity);
--     EXCEPTION
--         WHEN DUP_VAL_ON_INDEX THEN
--             UPDATE package_item SET quantity = quantity + p_quantity WHERE order_number = p_order_number AND article_id = p_article_id AND  service_id = p_service_id;
-- END add_article_order;
-- /
COMMIT;