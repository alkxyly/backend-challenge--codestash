create sequence hibernate_sequence start 1 increment 1;
create table db_articles (id int8 not null, featured boolean not null, id_article int8, news_site varchar(255), published_at varchar(255), summary varchar(5000), title varchar(255), url varchar(255), primary key (id));
create table tb_control (id int8 not null, limite int8 not null, page int8 not null, total int8 not null, primary key (id));
create sequence hibernate_sequence start 1 increment 1;
create table db_articles (id int8 not null, featured boolean not null, id_article int8, news_site varchar(255), published_at varchar(255), summary varchar(5000), title varchar(255), url varchar(255), primary key (id));
create table tb_control (id int8 not null, limite int8 not null, page int8 not null, total int8 not null, primary key (id));
