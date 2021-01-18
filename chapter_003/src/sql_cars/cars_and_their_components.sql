select auto.name as car_n, body.name as body_n, engine.name as engine_n, transmission.name as trans_n
from auto
join body         on auto.body_id         = body.id
join engine       on auto.engine_id       = engine.id
join transmission on auto.transmission_id = transmission.id