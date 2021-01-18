select engine.name as engine_n
from auto
right join engine on auto.engine_id = engine.id
where auto.id is NULL;
