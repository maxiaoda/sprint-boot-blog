create table user
(
    id                 bigint primary key auto_increment,
    username           varchar(100),
    encrypted_password varchar(200),
    avatar             varchar(200),
    created_at         datetime,
    updated_at         datetime
);