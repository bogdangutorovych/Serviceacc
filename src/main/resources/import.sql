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
(4, 8, 2, false);
ALTER SEQUENCE deal_id_seq RESTART WITH 5;

INSERT INTO CONTRACT (id, number, contract_date, deal_id, manager_id, contract_status, is_deleted, is_trial) VALUES
(1, '1', '2017-01-01', 1, 1, 'ACTIVE', false, false),
(2, '2', '2017-02-28', 2, 2, 'ACTIVE', false, false),
(3, '3', '2017-04-25', 3, 3, 'FROZEN', false, false),
(4, '4', '2017-01-31', 4, 3, 'CLOSED', false, false);
ALTER SEQUENCE contract_id_seq RESTART WITH 5;

INSERT INTO QUEUE_ENROLL (id, queue_enroll_date, deal_id, novice, is_deleted) VALUES
(1, '2017-01-01', 1, true, false),
(2, '2017-01-01', 2, true, false);
ALTER SEQUENCE queue_enroll_id_seq RESTART WITH 3;

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
