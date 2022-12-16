select * from seculant;

UPDATE seculant
SET seculant_name = '&seculant_name'
WHERE seculant_id = &seculant_id;

select * from seculant;