-- Create the catalog of possible ingredients.
insert into ingredient (name, alias, price) values ('Alface', 'LTC', 0.4);
insert into ingredient (name, alias, price) values ('Bacon', 'BCN', 2.0);
insert into ingredient (name, alias, price) values ('Hambúrguer de carne', 'MHB', 3.0);
insert into ingredient (name, alias, price) values ('Ovo', 'EGG', 0.8);
insert into ingredient (name, alias, price) values ('Queijo', 'CHE', 1.5);

-- Create the catalog of possible sandwiches.
insert into sandwich (name) values ('X-Bacon');
insert into sandwich (name) values ('X-Burger');
insert into sandwich (name) values ('X-Egg');
insert into sandwich (name) values ('X-Egg Bacon');

-- Create the association between a sandwich and its ingredients.
insert into sandwich_ingredient (id_sandwich, id_ingredient) values ((select id from sandwich where name = 'X-Bacon'), (select id from ingredient where name = 'Bacon'));
insert into sandwich_ingredient (id_sandwich, id_ingredient) values ((select id from sandwich where name = 'X-Bacon'), (select id from ingredient where name = 'Hambúrguer de carne'));
insert into sandwich_ingredient (id_sandwich, id_ingredient) values ((select id from sandwich where name = 'X-Bacon'), (select id from ingredient where name = 'Queijo'));
insert into sandwich_ingredient (id_sandwich, id_ingredient) values ((select id from sandwich where name = 'X-Burger'), (select id from ingredient where name = 'Hambúrguer de carne'));
insert into sandwich_ingredient (id_sandwich, id_ingredient) values ((select id from sandwich where name = 'X-Burger'), (select id from ingredient where name = 'Queijo'));
insert into sandwich_ingredient (id_sandwich, id_ingredient) values ((select id from sandwich where name = 'X-Egg'), (select id from ingredient where name = 'Ovo'));
insert into sandwich_ingredient (id_sandwich, id_ingredient) values ((select id from sandwich where name = 'X-Egg'), (select id from ingredient where name = 'Hambúrguer de carne'));
insert into sandwich_ingredient (id_sandwich, id_ingredient) values ((select id from sandwich where name = 'X-Egg'), (select id from ingredient where name = 'Queijo'));
insert into sandwich_ingredient (id_sandwich, id_ingredient) values ((select id from sandwich where name = 'X-Egg Bacon'), (select id from ingredient where name = 'Ovo'));
insert into sandwich_ingredient (id_sandwich, id_ingredient) values ((select id from sandwich where name = 'X-Egg Bacon'), (select id from ingredient where name = 'Bacon'));
insert into sandwich_ingredient (id_sandwich, id_ingredient) values ((select id from sandwich where name = 'X-Egg Bacon'), (select id from ingredient where name = 'Hambúrguer de carne'));
insert into sandwich_ingredient (id_sandwich, id_ingredient) values ((select id from sandwich where name = 'X-Egg Bacon'), (select id from ingredient where name = 'Queijo'));

-- Create the catalog of possible promotions.
insert into promotion (name, alias, discount) values ('Light', 'LGT', 0.10);
insert into promotion (name, alias, discount) values ('Muita carne', 'HAM', 0.33);
insert into promotion (name, alias, discount) values ('Muito queijo', 'AMC', 0.33);

-- Create the inflation configuration variable.
insert into configuration (code, value) values ('INFLATION', '0.0295');