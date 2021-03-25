create table roles (
    id bigint not null auto_increment,
    role_name varchar(255),
    primary key (id)
    ) engine=InnoDB

create table sensors (
    id bigint not null auto_increment,
    description varchar(255),
    location varchar(255),
    model varchar(255) not null,
    name varchar(255) not null,
    range_from integer,
    rang2e_to integer,
    type_id bigint not null,
    unit_id bigint not null,
    primary key (id)
    ) engine=InnoDB

create table types (
    id bigint not null auto_increment,
    type_name varchar(255),
    primary key (id)
    ) engine=InnoDB

create table units (
    id bigint not null auto_increment,
    unit_name varchar(255),
    primary key (id)
    ) engine=InnoDB

create table usr (
    id bigint not null auto_increment,
    login varchar(255),
    password varchar(255),
    role_id bigint,
    primary key (id)
    ) engine=InnoDB

alter table sensors
    add constraint UK_pwxr50puxe55nd0249ybf21vs
    unique (name);

alter table sensors
    add constraint FK3mvhoabhaml4hjjjh75awe32v
    foreign key (type_id)
    references types (id);

alter table sensors
    add constraint FK466sx5l0tn9eu7hsod0jdiwos
    foreign key (unit_id)
    references units (id);

alter table usr
    add constraint FK88df7ybkeq55cmxcjoth672df
    foreign key (role_id)
    references roles (id);
