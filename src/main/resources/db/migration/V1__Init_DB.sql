create table if not exists `roles` (
    id bigint not null auto_increment,
    role_name varchar(255),
    primary key (id)
    ) engine=InnoDB;

create table if not exists `sensors` (
    id bigint not null auto_increment,
    description varchar(255),
    location varchar(255),
    model varchar(255) not null,
    name varchar(255) not null,
    range_from integer,
    range_to integer,
    type_id bigint not null,
    unit_id bigint not null,
    primary key (id)
    ) engine=InnoDB;

create table if not exists `types` (
    id bigint not null auto_increment,
    type_name varchar(255),
    primary key (id)
    ) engine=InnoDB;

create table if not exists `units` (
    id bigint not null auto_increment,
    unit_name varchar(255),
    primary key (id)
    ) engine=InnoDB;

create table if not exists `usr` (
    id bigint not null auto_increment,
    login varchar(255),
    password varchar(255),
    role_id bigint,
    primary key (id)
    ) engine=InnoDB;
