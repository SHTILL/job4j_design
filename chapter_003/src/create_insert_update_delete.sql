create table phones (
	id serial primary key,
	name varchar(255),
	display_size real,
	memory bigint
);

insert into phones(name, display_size, memory) values ('iPhone17S', 6.1, 128*1024*1024);
insert into phones(name, display_size, memory) values ('Sumsung Galaxy 15S+', 7.4, 64*1024*1024);

update phones set memory=256*1024*1024;

delete from phones;