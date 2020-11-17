create table roles (
	id serial primary key,
	name text
);

create table users (
	id serial primary key,
	name text,
	role_id int references roles(id)
);

create table rules (
	id serial primary key,
	name text
);

create table categories (
	id serial primary key,
	name text
);

create table states (
	id serial primary key,
	name text
);

create table items (
	id serial primary key,
	name text,
	user_id int references users(id),
	category_id int references categories(id),
	state_id int references states(id)
);

create table comments (
	id serial primary key,
	name text,
	item_id int references items(id)
);

create table attaches (
	id serial primary key,
	name text,
	item_id int references items(id)
);

create table role_rule_compose (
	id serial primary key,
	name text,
	rule_id int references rules(id),
	role_id int references roles(id)
);