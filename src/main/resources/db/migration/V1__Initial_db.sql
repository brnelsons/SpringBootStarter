create table if not exists users
(
    uuid       uuid primary key not null,
    first_name text             not null,
    last_name  text             not null,
    email      text             not null,
    pass       text
);