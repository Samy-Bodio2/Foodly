select * from garnish;

UPDATE garnish
SET garnish_name = '&garnish_name'
WHERE garnish_id = &garnish_id;

select * from garnish;