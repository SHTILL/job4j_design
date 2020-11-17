insert into states(name) values ('blocked');
insert into states(name) values ('in_progress');
insert into states(name) values ('new');
insert into states(name) values ('finished');

insert into categories(name) values ('finance');
insert into categories(name) values ('IT');

insert into rules(name) values ('create');
insert into rules(name) values ('approve');
insert into rules(name) values ('remove');

insert into roles(name) values ('director');
insert into roles(name) values ('employee');

insert into role_rule_compose(role_id, rule_id) values (1, 1);
insert into role_rule_compose(role_id, rule_id) values (1, 2);
insert into role_rule_compose(role_id, rule_id) values (1, 3);
insert into role_rule_compose(role_id, rule_id) values (1, 2);

insert into users(name, role_id) values ('Boss', 1);
insert into users(name, role_id) values ('Vasya', 2);
insert into users(name, role_id) values ('Petya', 2);

insert into items(name, user_id, category_id, state_id) values ('Buy furniture', 1, 1, 3);
insert into items(name, user_id, category_id, state_id) values ('Install OS', 2, 2, 2);

insert into comments(name, item_id) values ('We need something to seat on', 1);
insert into comments(name, item_id) values ('My PC is dead', 2);

insert into attaches(name, item_id) values ('Receipt', 1);
insert into attaches(name, item_id) values ('No attachements', 2);