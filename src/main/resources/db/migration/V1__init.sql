DROP TABLE IF EXISTS public.users CASCADE;
DROP TABLE IF EXISTS public.type_product CASCADE;
DROP TABLE IF EXISTS public.products;

CREATE TABLE public.users
(id bigserial PRIMARY KEY,
username varchar(255) unique
);
CREATE INDEX idx_users_id ON public.users(id);

insert into public.users (username)
values
    ('Evgen'),
    ('Vasia'),
    ('Sergey'),
    ('Aleksey'),
    ('Katya'),
    ('Vladimir'),
    ('Denis');

CREATE TABLE public.products
(id bigserial PRIMARY KEY,
 account_number varchar(25),
 balance real,
 type_products varchar(25),
 user_id bigint);
CREATE INDEX idx_products_id ON public.products(id);

insert into public.products (account_number, balance, type_products, user_id)
values
    ('40802810345124535123', 123.12, 'ACCOUNT', 1),
    ('6453411547575745431', 323.44, 'CARD', 3),
    ('1234567889', 53535.00, 'CARD', 3),
    ('40802810233223322122', 555.12, 'ACCOUNT', 1)
;
