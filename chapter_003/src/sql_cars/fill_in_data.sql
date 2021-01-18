insert into body(id, name) values(1, 'sedan');
insert into body(id, name) values(2, 'hatchback');
insert into body(id, name) values(3, 'crossover');

insert into engine(id, name) values(1, '1.0 six-cylinder');
insert into engine(id, name) values(2, '1.4 six-cylinder');
insert into engine(id, name) values(3, '2.0 eight-cylinder');

insert into transmission(id, name) values(1, 'manual');
insert into transmission(id, name) values(2, 'automatic');
insert into transmission(id, name) values(3, 'variator');

insert into auto(id, name, body_id, engine_id, transmission_id) values (1, 'OKA',   2 , 1, 2);
insert into auto(id, name, body_id, engine_id, transmission_id) values (2, 'LADA',  3 , 3, 1);
insert into auto(id, name, body_id, engine_id, transmission_id) values (3, 'MAZDA', 3 , 1, 2);
insert into auto(id, name, body_id, engine_id, transmission_id) values (4, 'RENO',  2 , 3, 1);
insert into auto(id, name, body_id, engine_id, transmission_id) values (5, 'PEZHO', 2 , 1, 1);
