create table point (id bigint not null auto_increment, amount bigint, user_id bigint, primary key (id)) engine=InnoDB;
create index IDX_POINT_USER_ID on point (user_id);