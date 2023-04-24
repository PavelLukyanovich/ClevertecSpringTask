insert into users (user_id, first_name, last_name)
values (1, 'Pavel', 'Lukyanovich'),
       (2, 'Igor', 'Usov'),
       (3, 'Gleb', 'Petrov');

select setval('users_user_id_seq', (select MAX(user_id) FROM users));

insert into gift_certificate (certificateid, name, duration, price)
values (1, 'ZARA', 360, 100),
       (2, 'PUMA', 230, 120),
       (3, 'DC', 180, 250);

select setval('gift_certificate_certificateid_seq', (select MAX(certificateid) FROM gift_certificate));

insert into orders (order_id, order_price, order_date, user_id)
values (1, 100, '2000-01-01', 1),
       (2, 200, '2000-02-01', 2),
       (3, 300, '2000-03-01', 3);

select setval('orders_order_id_seq', (select MAX(order_id) FROM orders));

insert into tag (tagid, name)
values (1, 'ZARA01'),
       (2, 'PUMA01'),
       (3, 'DC01');

select setval('tag_tagid_seq', (select MAX(tagid) FROM tag));