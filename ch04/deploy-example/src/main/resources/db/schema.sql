create table user (
    id bigint not null auto_increment,
    name varchar(200) not null,
    email varchar(200),
    photo_url varchar(200),
    phone_number varchar(200),
    support bool,
    confirmed_and_active bool
);