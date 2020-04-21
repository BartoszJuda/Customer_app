
-- roles
insert into role ("role_id", "role")
values ( 1, 'ADMIN' );

insert into role ("role_id", "role")
values ( 2, 'USER' );

--users
insert into "user" ("id", "active", "email", "last_name", "login", "name", "password")
values ( 1, 1, 'admin@email.pl', 'Nowakowski', 'admin', 'Robert', '$2a$10$zo0LP4v45CIr7VadLtv3ru.dbSH047yQKYDiUydH8YROvpCcFw47i');

insert into "user" ("id", "active", "email", "last_name", "login", "name", "password")
values ( 2, 1, 'user@email.pl', 'Bieńkowski', 'user', 'Zygmunt', '$2a$10$YhBTQv2LENDyUrE8feoCLeKcBHx3ubKJVfsHTSSRo.Ik3.GBjiXTu');

--add roles into users
insert into user_role ("user_id", "role_id") values ( 1, 1 );
insert into user_role ("user_id", "role_id") values ( 1, 2 );
insert into user_role ("user_id", "role_id") values ( 2, 2 );