delete from usr;
delete from roles;

insert into roles(role_name) values ('VIEWER'), ('ADMIN');
insert into usr(login, password, role_id) values ('user', '$2a$10$PIky6hDOoCO1Oqo8Zp3eu.5cs6mWaaYmQDbOH.nsZpsibX96alfoK', 1),
                                                 ('admin', '$2a$10$PIky6hDOoCO1Oqo8Zp3eu.5cs6mWaaYmQDbOH.nsZpsibX96alfoK', 2);
