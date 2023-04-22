insert into users (user_id, first_name, last_name)
values (1, 'Pavel', 'Lukyanovich'),
       (2, 'Igor', 'Usov'),
       (3, 'Gleb', 'Petrov');

select setval('users_user_id_seq', (select MAX(user_id) FROM users));

insert into gift_certificate (certificateid)
values (1),
       (2),
       (3);

select setval('gift_certificate_certificateid_seq', (select MAX(certificateid) FROM gift_certificate));

insert into orders (order_id, order_price)
values (1, 100),
       (2, 200),
       (3, 300);

select setval('orders_order_id_seq', (select MAX(order_id) FROM orders));