create table if not exists public.gift_certificate
(
    id               bigint not null primary key,
    name             varchar(20),
    description      varchar(100),
    price            int,
    duration         daterange,
    create_date      date,
    lust_update_date date

);

create table if not exists public.tag
(
    id           bigint not null primary key,
    name        varchar(20)
);

CREATE SEQUENCE IF NOT EXISTS certificate_seq;

copy gift_certificate FROM 'D:\Programming\Clevertec\CLEVERTEC_BACK_2023.Feb\TASK_8_SPRING\certificate\certificate\src\main\resources\csvs\gift_certificate.csv' DELIMITER ',';
copy tag FROM 'D:\Programming\Clevertec\CLEVERTEC_BACK_2023.Feb\TASK_8_SPRING\certificate\certificate\src\main\resources\csvs\tag.csv' DELIMITER ',';