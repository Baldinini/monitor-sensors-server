insert into types(type_name) values ('PRESSURE'), ('VOLTAGE'), ('TEMPERATURE'), ('HUMIDITY');
insert into units(unit_name) values ('BAR'), ('VOLTAGE'), ('CELSIUS'), ('PERCENT');
insert into roles(role_name) values ('VIEWER'), ('ADMIN');
insert into usr(login, password, role_id) values ('user', '$2a$10$PIky6hDOoCO1Oqo8Zp3eu.5cs6mWaaYmQDbOH.nsZpsibX96alfoK', 1), ('admin', '$2a$10$PIky6hDOoCO1Oqo8Zp3eu.5cs6mWaaYmQDbOH.nsZpsibX96alfoK', 2);
insert into sensors(name, model, type_id, unit_id) values ('sensor1', 'qwe', 1, 2), ('sensor2', 'asd', 2, 1), ('sensor3', 'zxc', 3, 4);
