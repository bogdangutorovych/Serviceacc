INSERT INTO MANAGER (id, birth_day, first_name, last_name, active) VALUES
(1, '2000-01-01', 'Mihail', 'Sokolovsky', true),
(2, '1990-02-12', 'Viktor', 'Gratchev', true),
(3, '1995-03-13', 'Vitaly', 'Staruhin', true),
(4, '1998-04-16', 'Diego', 'Maradona', true);
ALTER SEQUENCE manager_id_seq RESTART WITH 5;

INSERT INTO CURRENCY_TYPE (id, title, active, code) VALUES
(1, 'Dollar', true, 'USD'),
(2, 'Hryvnia', true, 'UAH'),
(3, 'Ruble', true, 'RUB');
ALTER SEQUENCE currency_type_seq RESTART WITH 4;

INSERT INTO CLIENT (id, birth_day, first_name, last_name, active) VALUES
(1, '1980-03-14', 'Robert', 'Levandovsky', true),
(2, '1986-09-08', 'Michael', 'Phelps', true),
(3, '1991-01-14', 'Marten', 'Fourcade', true),
(4, '1996-07-30', 'Rafael', 'Nadal', true),
(5, '1997-05-20', 'Sergey', 'Bubka', true),
(6, '1996-02-21', 'Arvidas', 'Sabonis', true),
(7, '1986-03-25', 'Oksana', 'Bayul', true),
(8, '1980-04-03', 'Steffy', 'Graf', false),
(9, '1995-09-12', 'Vitaly', 'Klichko', true);
ALTER SEQUENCE client_id_seq RESTART WITH 10;

INSERT INTO CONTRACT (id, number, contract_date, client_id, manager_id, contract_status, active) VALUES
(1, 'Contract # 1', '2017-01-01', 1, 2, 'PENDING', true),
(2, 'Contract # 2', '2017-02-28', 2, 1, 'ACTIVE', true),
(3, 'Contract # 3', '2017-04-25', 3, 1, 'FROZEN', true),
(4, 'Contract # 4', '2017-01-31', 3, 1, 'CLOSED', true);
ALTER SEQUENCE contract_id_seq RESTART WITH 5;

INSERT INTO CLIENT_INFO_TYPE (id, title, active, code) VALUES
(1, 'telephone', true, 'phone'),
(2, 'e-mail', true, 'mail'),
(3, 'site', true, 'site'),
(4, 'skype', true, 'skype'),
(5, 'city', true, 'city');
ALTER SEQUENCE client_info_type_seq RESTART WITH 6;

INSERT INTO MANAGER_INFO_TYPE (id, title, active, code) VALUES
(1, 'telephone', true, 'phone'),
(2, 'e-mail', true, 'mail'),
(3, 'site', true, 'site'),
(4, 'skype', true, 'skype'),
(5, 'city', true, 'city');
ALTER SEQUENCE manager_info_type_seq RESTART WITH 6;

INSERT INTO CLIENT_INFO (id, content, info_type_id, client_id, active) VALUES
(1, '0503265566', 1, 1, true),
(2, 'test@gmail.com', 2, 1, true),
(3, 'www.test.ua', 3, 1, true),
(4, 'testik', 4, 1, true),
(5, 'Kyev', 5, 1, true),
(6, '0936854214', 1, 2, true),
(7, 'karamba@gmail.com', 2, 2, true),
(8, null, 3, 2, true),
(9, 'rocket56', 4, 2, true),
(10, 'Kyev', 5, 2, true);
ALTER SEQUENCE client_info_seq RESTART WITH 11;

INSERT INTO MANAGER_INFO (id, content, info_type_id, manager_id, active) VALUES
(1, '0503265566', 1, 1, true),
(2, 'test@gmail.com', 2, 1, true),
(3, 'www.test.ua', 3, 1, true),
(4, 'testik', 4, 1, true),
(5, 'Kyev', 5, 1, true),
(6, '0936854214', 1, 2, true),
(7, 'karamba@gmail.com', 2, 2, true),
(8, null, 3, 2, true),
(9, 'rocket56', 4, 2, true),
(10, 'Kyev', 5, 3, true);
ALTER SEQUENCE manager_info_seq RESTART WITH 11;