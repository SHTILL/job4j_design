select body.name as body_n
from auto
right join body on auto.body_id = body.id
where auto.id is NULL;
