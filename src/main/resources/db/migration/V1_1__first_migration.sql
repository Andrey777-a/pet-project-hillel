create table action_point
(
    id int auto_increment primary key,
    name    varchar(100) not null

);

create table role
(
    id int auto_increment primary key,
    name    varchar(100) not null

);

create table role_action_point
(
    id int auto_increment primary key,
    role_id int not null,
    action_point_id int not null,
    constraint role_action_point_role_id_fk
        foreign key (role_id) references role (id)
            on update cascade on delete cascade,
    constraint role_action_point_action_id_fk
        foreign key (action_point_id) references action_point (id)
            on update cascade on delete cascade

);
create table user
(
    id  int auto_increment primary key,
    first_name varchar(25) not null,
    last_name  varchar(25) not null,
    password varchar(200) not null,
    email      varchar(50) not null,
    role_id int null,
    constraint user_role_id_fk
        foreign key (role_id) references role (id)
);
create table status_task (
                             id int auto_increment primary key,
                             name varchar(500)  not null
);

create table type_task (
                           id int auto_increment primary key,
                           name varchar(500)  not null
);

create table task_user
(
    id int auto_increment primary key,
    name            varchar(500)                         not null,
    description     varchar(500)                         null,
    user_id       int                                  null,
    status_id       int                        not null,
    priority        int                                  not null,
    time_spent      double(10, 2)                        null,
    time_estimated  datetime                             null,
    created_on_date datetime default (CURRENT_TIMESTAMP) not null,
    type_id           int                          not null,
    constraint task_user_user_id_fk
        foreign key (user_id) references user (id),
	constraint task_user_status_id_fk
        foreign key (status_id) references status_task (id),
	constraint task_user_type_id_fk
        foreign key (type_id) references type_task (id)
);

insert into type_task(name) values('USER_STORY');
insert into type_task(name) values('SUP_TASK');
insert into type_task(name) values('EPIC');

insert into status_task(name) values('IN_WORK');
insert into status_task(name) values('ASSIGN');
insert into status_task(name) values('DONE');
insert into status_task(name) values('HOLD');

insert role (name) values ("ROLE_ADMIN");
insert role (name) values ("ROLE_ANALYST");

insert action_point (name) values ("VIEW_TICKET");
insert action_point (name) values ("ADD_USER");
insert action_point (name) values ("ADD_TICKET");
insert action_point (name) values ("EDIT_USER");
insert action_point (name) values ("DELETE_USER");

insert into role_action_point (role_id, action_point_id) values (2, 1);
insert into role_action_point (role_id, action_point_id) values (2, 4);
insert into role_action_point (role_id, action_point_id) values (1, 5);
insert into role_action_point (role_id, action_point_id) values (1, 2);
insert into role_action_point (role_id, action_point_id) values (1, 3);

insert into user (first_name, last_name, password, email, role_id) values ('Roy', 'Gibson', 'pass', 'email1', 2);
insert into user (first_name, last_name, password, email, role_id) values ('Dima', 'Ivanov', 'pass', 'email2', 1);
insert into user (first_name, last_name, password, email, role_id) values ('Ira', 'Smirnova', 'pass', 'email3', 2);





