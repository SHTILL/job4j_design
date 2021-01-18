select transmission.name as trans_n
from auto
right join transmission on auto.transmission_id = transmission.id
where auto.id is NULL;