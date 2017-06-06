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
(8, 1500, 'UAH', false),
(9, 1500, 'UAH', false),
(10, 1500, 'UAH', false),
(11, 1500, 'UAH', false),
(12, 1500, 'UAH', false),
(13, 1500, 'UAH', false),
(14, 3000, 'UAH', false),
(15, 3000, 'UAH', false),
(16, 3000, 'UAH', false),
(17, 3000, 'UAH', false);
ALTER SEQUENCE money_id_seq RESTART WITH 18;

INSERT INTO SERVICE (id, name, description, manager_rate_id, is_deleted) VALUES
(1, 'менторинг', 'обучение студента идет на заданиях и анализе их выполнения', 7, false),
(2, 'группа', 'обучение в группе на реальном проекте', 8, false);
ALTER SEQUENCE service_id_seq RESTART WITH 3;

INSERT INTO SERVICE_PRICES (service_id, price_id) VALUES
(1, 1),(1, 2),(1, 3),(2, 4),(2, 5),(2, 6);

INSERT INTO DEAL (id, client_id, service_id, is_deleted) VALUES
(1, 5, 1, false),
(2, 6, 2, false),
(3, 7, 1, false),
(4, 8, 2, false),
(5, 8, 1, false);
ALTER SEQUENCE deal_id_seq RESTART WITH 6;

INSERT INTO CONTRACT (id, number, contract_date, deal_id, client_rate, manager_rate, manager_id, contract_status, is_deleted, is_trial, contract_type, close_date) VALUES
(1, '1', '2017-01-01', 1, 1, 7, 1, 'ACTIVE', false, false, 'POSTPAID', null),
(2, '2', '2017-02-28', 2, 4, 8, 2, 'ACTIVE', false, false, 'POSTPAID', null),
(3, '3', '2017-04-10', 3, 14, 9, 3, 'FROZEN', false, false, 'POSTPAID', null),
(4, '4', '2017-03-15', 4, 15, 10, 3, 'CLOSED', false, false, 'PREPAID', '2017-05-15'),
(5, '5', '2017-05-10', 4, 16, 11, 3, 'ACTIVE', false, false, 'PREPAID', null);
ALTER SEQUENCE contract_id_seq RESTART WITH 6;

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
(10, 'Kyev', 5, 2, false),

(11, '', 1, 3, false),
(12, '', 2, 3, false),
(13, '', 3, 3, false),
(14, '', 4, 3, false),
(15, '', 5, 3, false),

(16, '', 1, 4, false),
(17, '', 2, 4, false),
(18, '', 3, 4, false),
(19, '', 4, 4, false),
(20, '', 5, 4, false),

(21, '', 1, 5, false),
(22, '', 2, 5, false),
(23, '', 3, 5, false),
(24, '', 4, 5, false),
(25, '', 5, 5, false),

(26, '', 1, 6, false),
(27, '', 2, 6, false),
(28, '', 3, 6, false),
(29, '', 4, 6, false),
(30, '', 5, 6, false),

(31, '', 1, 7, false),
(32, '', 2, 7, false),
(33, '', 3, 7, false),
(34, '', 4, 7, false),
(35, '', 5, 7, false),

(36, '', 1, 8, false),
(37, '', 2, 8, false),
(38, '', 3, 8, false),
(39, '', 4, 8, false),
(40, '', 5, 8, false);


ALTER SEQUENCE client_info_seq RESTART WITH 41;

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
(1, '2017-02-02', 1, 'CASH', false),
(2, '2017-03-03', 1, 'BANK', false),
(3, '2017-04-02', 1, 'UNISTREAM', false),
(4, '2017-03-30', 1, 'UNISTREAM', false),
(5, '2017-03-17', 1, 'UNISTREAM', false);
ALTER SEQUENCE payment_id_seq RESTART WITH 6;

INSERT INTO PERIOD (id, date_from, date_to) VALUES
(1, '2017-01-01', '2017-01-31'),
(2, '2017-02-01', '2017-02-28'),
(3, '2017-03-01', '2017-03-31'),
(4, '2017-04-01', '2017-04-30'),
(5, '2017-02-28', '2017-03-27'),
(6, '2017-03-28', '2017-04-27'),
(7, '2017-03-15', '2017-04-14'),
(8, '2017-03-15', '2017-04-14'),
(9, '2017-05-10', '2017-06-09');
ALTER SEQUENCE period_id_seq RESTART WITH 10;

INSERT INTO INVOICE (id, number, date, contract_id, money_id, invoice_type, payment_id, period_id, is_deleted) VALUES
(1, 'inv# 1', '2017-01-01', 1, 1, 'PAID', 1, 1, false),
(2, 'inv# 2', '2017-02-01', 1, 1, 'PAID', 2, 2, false),
(3, 'inv# 3', '2017-03-01', 1, 1, 'PAID', 3, 3, false),
(4, 'inv# 4', '2017-04-01', 1, 1, 'NEW', NULL, 4, false),
(5, 'inv# 5', '2017-02-28', 2, 1, 'PAID', 4, 5, false),
(6, 'inv# 6', '2017-03-28', 2, 1, 'NEW', NULL, 6, false),
(7, 'inv# 7', '2017-03-15', 4, 1, 'PAID', 5, 7, false),
(8, 'inv# 8', '2017-04-10', 3, 1, 'NEW', NULL, 8, false),
(9, 'inv# 9', '2017-05-10', 5, 1, 'NEW', NULL, 9, false);

ALTER SEQUENCE invoice_id_seq RESTART WITH 10;
