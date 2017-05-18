INSERT INTO MANAGER (id, birth_day, first_name, last_name, is_deleted) VALUES
(1, '2000-01-01', 'Mihail', 'Sokolovsky', false),
(2, '1990-02-12', 'Viktor', 'Gratchev', false),
(3, '1995-03-13', 'Vitaly', 'Staruhin', false),
(4, '1998-04-16', 'Diego', 'Maradona', false);
ALTER SEQUENCE manager_id_seq RESTART WITH 5;

INSERT INTO CLIENT (id, birth_day, first_name, last_name, is_deleted) VALUES
(1, '1980-03-14', 'Robert', 'Levandovsky', false),
(2, '1986-09-08', 'Michael', 'Phelps', false),
(3, '1991-01-14', 'Marten', 'Fourcade', false),
(4, '1996-07-30', 'Rafael', 'Nadal', false),
(5, '1997-05-20', 'Sergey', 'Bubka', false),
(6, '1996-02-21', 'Arvidas', 'Sabonis', false),
(7, '1986-03-25', 'Oksana', 'Bayul', false),
(8, '1980-04-03', 'Steffy', 'Graf', false),
(9, '1995-09-12', 'Vitaly', 'Klichko', true);
ALTER SEQUENCE client_id_seq RESTART WITH 10;

INSERT INTO MONEY (id, amount, currency, is_deleted) VALUES
(1, 3000, 'UAH', false),
(2, 120, 'USD', false),
(3, 100, 'EUR', false),
(4, 3000, 'UAH', false),
(5, 120, 'USD', false),
(6, 100, 'EUR', false),
(7, 1500, 'UAH', false),
(8, 1500, 'UAH', false);
ALTER SEQUENCE service_id_seq RESTART WITH 9;

INSERT INTO SERVICE (id, name, description, rate_id, is_deleted) VALUES
(1, 'менторинг', 'обучение студента идет на заданиях и анализе их выполнения', 7, false),
(2, 'группа', 'обучение в группе на реальном проекте', 8, false);
ALTER SEQUENCE service_id_seq RESTART WITH 3;

INSERT INTO SERVICE_PRICES (service_id, prices_id) VALUES
(1, 1),(1, 2),(1, 3),(2, 4),(2, 5),(2, 6);

INSERT INTO DEAL (id, client_id, service_id, is_deleted) VALUES
(1, 5, 1, false),
(2, 6, 2, false),
(3, 7, 1, false),
(4, 8, 2, false),
(5, 8, 1, false);
ALTER SEQUENCE deal_id_seq RESTART WITH 6;

INSERT INTO CONTRACT (id, number, contract_date, deal_id, client_rate, manager_rate, manager_id, contract_status, is_deleted, is_trial, contract_type) VALUES
(1, '1', '2017-01-01', 1, 1, 7, 1, 'ACTIVE', false, false, 'POSTPAID'),
(2, '2', '2017-02-28', 2, 1, 7, 2, 'ACTIVE', false, false, 'POSTPAID'),
(3, '3', '2017-04-25', 3, 1, 7, 3, 'FROZEN', false, false, 'POSTPAID'),
(4, '4', '2017-04-30', 4, 1, 7, 3, 'CLOSED', false, false, 'PREPAID'),
(5, '5', '2017-05-10', 4, 1, 7, 3, 'ACTIVE', false, false, 'PREPAID');
ALTER SEQUENCE contract_id_seq RESTART WITH 5;

INSERT INTO QUEUE_REGISTER (id, register_date, deal_id, after_freezing, is_deleted) VALUES
(1, '2017-01-01', 1, false, false),
(2, '2017-01-01', 2, false, false);
ALTER SEQUENCE queue_register_id_seq RESTART WITH 3;

INSERT INTO CLIENT_INFO_TYPE (id, title, is_deleted, code) VALUES
(1, 'telephone', false, 'phone'),
(2, 'e-mail', false, 'mail'),
(3, 'site', false, 'site'),
(4, 'skype', false, 'skype'),
(5, 'city', false, 'city');
ALTER SEQUENCE client_info_type_seq RESTART WITH 6;

INSERT INTO MANAGER_INFO_TYPE (id, title, is_deleted, code) VALUES
(1, 'telephone', false, 'phone'),
(2, 'e-mail', false, 'mail'),
(3, 'site', false, 'site'),
(4, 'skype', false, 'skype'),
(5, 'city', false, 'city');
ALTER SEQUENCE manager_info_type_seq RESTART WITH 6;

INSERT INTO CLIENT_INFO (id, content, info_type_id, client_id, is_deleted) VALUES
(1, '0503265566', 1, 1, false),
(2, 'test@gmail.com', 2, 1, false),
(3, 'www.test.ua', 3, 1, false),
(4, 'testik', 4, 1, false),
(5, 'Kyev', 5, 1, false),
(6, '0936854214', 1, 2, false),
(7, 'karamba@gmail.com', 2, 2, false),
(8, null, 3, 2, false),
(9, 'rocket56', 4, 2, false),
(10, 'Kyev', 5, 2, false);
ALTER SEQUENCE client_info_seq RESTART WITH 11;

INSERT INTO MANAGER_INFO (id, content, info_type_id, manager_id, is_deleted) VALUES
(1, '0503265566', 1, 1, false),
(2, 'test@gmail.com', 2, 1, false),
(3, 'www.test.ua', 3, 1, false),
(4, 'testik', 4, 1, false),
(5, 'Kyev', 5, 1, false),
(6, '0936854214', 1, 2, false),
(7, 'karamba@gmail.com', 2, 2, false),
(8, null, 3, 2, false),
(9, 'rocket56', 4, 2, false),
(10, 'Kyev', 5, 3, false);
ALTER SEQUENCE manager_info_seq RESTART WITH 11;

INSERT INTO PAYMENT (id, date, money_id, payment_type, is_deleted) VALUES
(1, '2017-01-14', 1, 'CASH', false),
(2, '2017-02-14', 1, 'BANK', false),
(3, '2017-03-14', 1, 'UNISTREAM', false);
ALTER SEQUENCE payment_id_seq RESTART WITH 4;

INSERT INTO PERIOD (id, date_from, date_to) VALUES
(1, '2017-01-14', '2017-02-13'),
(2, '2017-02-12', '2017-03-11'),
(3, '2017-03-04', '2017-04-03'),
(4, '2017-04-25', '2017-05-24'),
(5, '2017-05-09', '2017-06-08'),
(6, '2017-06-09', '2017-07-08'),
(7, '2017-07-09', '2017-08-08');
ALTER SEQUENCE period_id_seq RESTART WITH 6;

INSERT INTO INVOICE (id, number, date, contract_id, money_id, invoice_type, payment_id, period_id, is_deleted) VALUES
(1, 'inv# 1', '2017-01-01', 1, 1, 'NEW', NULL, 1, false),
(2, 'inv# 2', '2017-02-01', 2, 1, 'NEW', NULL, 2, false),
(3, 'inv# 3', '2017-03-01', 3, 1, 'PAID', 1, 3, false),
(4, 'inv# 4', '2017-04-01', 4, 1, 'PAID', 2, 4, false),
(5, 'inv# 5', '2017-02-01', 5, 1, 'PAID', 3, 5, false),
(6, 'inv# 6', '2017-03-01', 5, 1, 'PAID', 3, 6, false),
(7, 'inv# 7', '2017-04-01', 5, 1, 'PAID', 3, 7, false);
ALTER SEQUENCE invoice_id_seq RESTART WITH 6;
