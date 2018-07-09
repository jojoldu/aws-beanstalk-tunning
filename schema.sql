create table point (id bigint not null auto_increment, amount bigint, user_id bigint, primary key (id)) engine=InnoDB;
create index IDX_POINT_USER_ID on point (user_id);

insert into point (amount, user_id) values (1000, 1);
insert into point (amount, user_id) values (200, 1);
insert into point (amount, user_id) values (30, 1);
insert into point (amount, user_id) values (4, 1);