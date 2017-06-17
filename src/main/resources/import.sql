INSERT INTO MANAGER (id, birth_day, first_name, last_name, clients_limit, is_deleted) VALUES
    (1, '2000-01-01', 'Mihail', 'Sokolovsky', 5, FALSE),
    (2, '1990-02-12', 'Viktor', 'Gratchev', 5, FALSE),
    (3, '1995-03-13', 'Vitaly', 'Staruhin', 0, FALSE),
    (4, '1998-04-16', 'Diego', 'Maradona', 0, FALSE);
ALTER SEQUENCE manager_id_seq RESTART WITH 5;

INSERT INTO CLIENT (id, birth_day, first_name, last_name, is_deleted) VALUES
    (1, '1980-03-14', 'Robert', 'Levandovsky', FALSE),
    (2, '1986-09-08', 'Michael', 'Phelps', FALSE),
    (3, '1991-01-14', 'Marten', 'Fourcade', FALSE),
    (4, '1996-07-30', 'Rafael', 'Nadal', FALSE),
    (5, '1997-05-20', 'Sergey', 'Bubka', FALSE),
    (6, '1996-02-21', 'Arvidas', 'Sabonis', FALSE),
    (7, '1986-03-25', 'Oksana', 'Bayul', FALSE),
    (8, '1980-04-03', 'Steffy', 'Graf', FALSE),
    (9, '1995-09-12', 'Vitaly', 'Klichko', TRUE);
ALTER SEQUENCE client_id_seq RESTART WITH 10;

INSERT INTO MONEY (id, amount, currency, is_deleted) VALUES
    (1, 3000, 'UAH', FALSE),
    (2, 120, 'USD', FALSE),
    (3, 100, 'EUR', FALSE),
    (4, 3000, 'UAH', FALSE),
    (5, 120, 'USD', FALSE),
    (6, 100, 'EUR', FALSE),
    (7, 1500, 'UAH', FALSE),
    (8, 1500, 'UAH', FALSE),
    (9, 1500, 'UAH', FALSE),
    (10, 1500, 'UAH', FALSE),
    (11, 1500, 'UAH', FALSE),
    (12, 1500, 'UAH', FALSE),
    (13, 1500, 'UAH', FALSE),
    (14, 3000, 'UAH', FALSE),
    (15, 3000, 'UAH', FALSE),
    (16, 1500, 'UAH', FALSE),
    (17, 3000, 'UAH', FALSE),
    (18, 1500, 'UAH', FALSE),
    (19, 2000, 'UAH', FALSE),
    (20, 1000, 'UAH', FALSE),
    (21, 3000, 'UAH', FALSE),
    (22, 1500, 'UAH', FALSE),
    (23, 3000, 'UAH', FALSE),
    (24, 1500, 'UAH', FALSE),
    (25, 3000, 'UAH', FALSE),
    (26, 3000, 'UAH', FALSE),
    (27, 1500, 'UAH', FALSE);
ALTER SEQUENCE money_id_seq RESTART WITH 28;

INSERT INTO SERVICE (id, name, description, manager_rate_id, is_deleted) VALUES
    (1, 'менторинг', 'обучение студента идет на заданиях и анализе их выполнения', 7, FALSE),
    (2, 'группа', 'обучение в группе на реальном проекте', 8, FALSE);
ALTER SEQUENCE service_id_seq RESTART WITH 3;

INSERT INTO SERVICE_PRICES (service_id, price_id) VALUES
    (1, 1), (1, 2), (1, 3), (2, 4), (2, 5), (2, 6);

INSERT INTO DEAL (id, client_id, service_id, is_deleted) VALUES
    (1, 5, 1, FALSE),
    (2, 6, 2, FALSE),
    (3, 7, 1, FALSE),
    (4, 8, 2, FALSE),
    (5, 8, 1, FALSE);
ALTER SEQUENCE deal_id_seq RESTART WITH 6;

INSERT INTO CONTRACT (id, number, contract_date, deal_id, client_rate, manager_rate, manager_id, contract_status, is_deleted, is_trial, contract_type)
VALUES
    (1, '1', '2017-01-01', 1, 1, 7, 1, 'ACTIVE', FALSE, FALSE, 'POSTPAID'),
    (2, '2', '2017-02-28', 2, 2, 8, 2, 'ACTIVE', FALSE, FALSE, 'POSTPAID'),
    (3, '3', '2017-04-25', 3, 3, 9, 3, 'FROZEN', FALSE, FALSE, 'POSTPAID'),
    (4, '4', '2017-04-30', 4, 4, 10, 3, 'CLOSED', FALSE, FALSE, 'PREPAID'),
    (5, '5', '2017-05-10', 4, 5, 11, 3, 'ACTIVE', FALSE, FALSE, 'PREPAID');
ALTER SEQUENCE contract_id_seq RESTART WITH 6;

INSERT INTO QUEUE_REGISTER (id, register_date, deal_id, after_freezing, is_deleted) VALUES
    (1, '2017-01-01', 1, FALSE, FALSE),
    (2, '2017-01-01', 2, FALSE, FALSE);
ALTER SEQUENCE queue_register_id_seq RESTART WITH 3;

INSERT INTO CLIENT_INFO_TYPE (id, title, is_deleted, code) VALUES
    (1, 'telephone', FALSE, 'phone'),
    (2, 'e-mail', FALSE, 'mail'),
    (3, 'site', FALSE, 'site'),
    (4, 'skype', FALSE, 'skype'),
    (5, 'city', FALSE, 'city');
ALTER SEQUENCE client_info_type_seq RESTART WITH 6;

INSERT INTO MANAGER_INFO_TYPE (id, title, is_deleted, code) VALUES
    (1, 'telephone', FALSE, 'phone'),
    (2, 'e-mail', FALSE, 'mail'),
    (3, 'site', FALSE, 'site'),
    (4, 'skype', FALSE, 'skype'),
    (5, 'city', FALSE, 'city');
ALTER SEQUENCE manager_info_type_seq RESTART WITH 6;

INSERT INTO MANAGER_INFO (id, content, info_type_id, manager_id, is_deleted) VALUES
    (1, '0503265566', 1, 1, FALSE),
    (2, 'test@gmail.com', 2, 1, FALSE),
    (3, 'www.test.ua', 3, 1, FALSE),
    (4, 'testik', 4, 1, FALSE),
    (5, 'Kyev', 5, 1, FALSE),
    (6, '0936854214', 1, 2, FALSE),
    (7, 'karamba@gmail.com', 2, 2, FALSE),
    (8, NULL, 3, 2, FALSE),
    (9, 'rocket56', 4, 2, FALSE),
    (10, 'Kyev', 5, 3, FALSE);
ALTER SEQUENCE manager_info_seq RESTART WITH 11;

INSERT INTO PAYMENT (id, date, money_id, payment_type, is_deleted) VALUES
    (1, '2017-01-14', 1, 'CASH', FALSE),
    (2, '2017-02-14', 1, 'BANK', FALSE),
    (3, '2017-03-14', 1, 'UNISTREAM', FALSE),
    (4, '2017-02-02', 1, 'CASH', FALSE);
ALTER SEQUENCE payment_id_seq RESTART WITH 5;

INSERT INTO PERIOD (id, date_from, date_to) VALUES
    (1, '2017-01-14', '2017-02-13'),
    (2, '2017-02-12', '2017-03-11'),
    (3, '2017-03-04', '2017-04-03'),
    (4, '2017-04-25', '2017-05-24'),
    (5, '2017-05-09', '2017-06-08'),
    (6, '2017-06-09', '2017-07-08'),
    (7, '2017-07-09', '2017-08-08'),
    (8, '2017-03-01', '2017-04-01'),
    (9, '2017-04-01', '2017-05-01'),
    (10, '2017-02-01', '2017-03-01'),
    (11, '2017-03-01', '2017-04-01'),
    (12, '2017-04-01', '2017-05-01'),
    (13, '2017-01-01', '2017-02-01'),
    (14, '2017-01-01', '2017-02-01');
ALTER SEQUENCE period_id_seq RESTART WITH 15;

INSERT INTO INVOICE (id, number, date, contract_id, money_id, invoice_type, payment_id, period_id, is_deleted) VALUES
    (1, 'inv# 1', '2017-01-01', 1, 1, 'NEW', NULL, 1, FALSE),
    (2, 'inv# 2', '2017-02-01', 2, 2, 'NEW', NULL, 2, FALSE),
    (3, 'inv# 3', '2017-03-01', 3, 3, 'PAID', 1, 3, FALSE),
    (4, 'inv# 4', '2017-04-01', 4, 4, 'PAID', 2, 4, FALSE),
    (5, 'inv# 5', '2017-02-01', 5, 5, 'PAID', 3, 5, FALSE),
    (6, 'inv# 6', '2017-03-01', 5, 6, 'PAID', 3, 6, FALSE),
    (7, 'inv# 7', '2017-04-01', 5, 7, 'PAID', 3, 7, FALSE),
    (8, 'inv# 8', '2017-02-01', 1, 25, 'PAID', 4, 13, FALSE),
    (9, 'inv# 9', '2017-03-01', 1, 25, 'PAID', 4, 14, FALSE);
ALTER SEQUENCE invoice_id_seq RESTART WITH 10;

INSERT INTO SALARY (id, date, manager_id, money_id, is_deleted) VALUES
    (1, '2017-02-15', 1, 27, FALSE),
    (2, '2017-03-15', 1, 27, FALSE);

INSERT INTO WORK_STATEMENT (id, manager_id, client_spending, manager_earning, invoice_id, period_id, salary_id, is_deleted)
VALUES
    (1, 1, 15, 16, 3, 8, NULL, FALSE),
    (2, 1, 17, 18, 4, 9, NULL, FALSE),
    (3, 2, 19, 20, 5, 10, NULL, FALSE),
    (4, 2, 21, 22, 6, 11, NULL, FALSE),
    (5, 3, 23, 24, 7, 12, NULL, FALSE),
    (6, 1, 26, 27, 8, 13, 1, FALSE),
    (7, 1, 26, 27, 9, 14, 2, FALSE);


INSERT INTO CLIENT_INFO (id, content, info_type_id, client_id, is_deleted) VALUES
    (1, '0503265566', 1, 1, FALSE),
    (2, 'test1@gmail.com', 2, 1, FALSE),
    (3, 'www.test.ua', 3, 1, FALSE),
    (4, 'testik', 4, 1, FALSE),
    (5, 'Kyev', 5, 1, FALSE),
    (6, '0936854214', 1, 2, FALSE),
    (7, 'karamba@gmail.com', 2, 2, FALSE),
    (8, NULL, 3, 2, FALSE),
    (9, 'rocket56', 4, 2, FALSE),
    (10, 'Lviv', 5, 2, FALSE),
    (11, '0936854214', 1, 3, FALSE),
    (12, 'mail2@gmail.com', 2, 3, FALSE),
    (13, '-', 3, 3, FALSE),
    (14, 'skype3', 4, 3, FALSE),
    (15, 'Kharkiv', 5, 3, FALSE),
    (16, '093000000', 1, 4, FALSE),
    (17, 'test3@gmail.com', 2, 4, FALSE),
    (18, '-', 3, 4, FALSE),
    (19, 'qwerty', 4, 4, FALSE),
    (20, 'Kiev', 5, 4, FALSE),
    (21, '0936854214', 1, 5, FALSE),
    (22, 'myweb@gmail.com', 2, 5, FALSE),
    (23, '-', 3, 5, FALSE),
    (24, 'skype5', 4, 5, FALSE),
    (25, 'Kyev', 5, 5, FALSE),
    (26, '0936854214', 1, 6, FALSE),
    (27, 'test4@gmail.com', 2, 6, FALSE),
    (28, '-', 3, 6, FALSE),
    (29, 'skype6', 4, 6, FALSE),
    (30, 'Kyev', 5, 6, FALSE),
    (31, '0936854214', 1, 7, FALSE),
    (32, 'test5@gmail.com', 2, 7, FALSE),
    (33, '-', 3, 7, FALSE),
    (34, 'skype7', 4, 7, FALSE),
    (35, 'Kyev', 5, 7, FALSE),
    (36, '0936854214', 1, 8, FALSE),
    (37, 'test6@gmail.com', 2, 8, FALSE),
    (38, '-', 3, 8, FALSE),
    (39, 'skype7', 4, 8, FALSE),
    (40, 'Kyev', 5, 8, FALSE),
    (41, '0936854214', 1, 9, FALSE),
    (42, 'test8@gmail.com', 2, 9, FALSE),
    (43, '-', 3, 9, FALSE),
    (44, 'skype9', 4, 9, FALSE),
    (45, 'Kyev', 5, 9, FALSE);
ALTER SEQUENCE client_info_seq RESTART WITH 51;
