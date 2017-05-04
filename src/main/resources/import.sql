INSERT INTO MANAGER (id, birth_day, first_name, last_name, active) VALUES
(1, '2000-01-01', 'Mihail', 'Sokolovsky', true),
(2, '1990-02-12', 'Viktor', 'Gratchev', true),
(3, '1995-03-13', 'Vitaly', 'Staruhin', true),
(4, '1998-04-16', 'Diego', 'Maradona', true);
ALTER SEQUENCE manager_id_seq RESTART WITH 5;

INSERT INTO CLIENT_LEVEL_TYPE (id, title, active, code) VALUES
(1, 'Applicant', true, 'APL'),
(2, 'Beginner', true, 'BGN'),
(3, 'Regular', true, 'REG'),
(4, 'Graduate', true, 'GRD');
ALTER SEQUENCE client_level_type_id_seq RESTART WITH 5;

INSERT INTO CLIENT_STATUS_TYPE (id, title, active, code) VALUES
(1, 'Active', true, 'ACT'),
(2, 'Frozen', true, 'FRZ'),
(3, 'Pending', true, 'PND');
ALTER SEQUENCE client_status_type_id_seq RESTART WITH 4;

INSERT INTO CURRENCY_TYPE (id, title, active, code) VALUES
(1, 'Dollar', true, 'USD'),
(2, 'Hryvnia', true, 'UAH'),
(3, 'Ruble', true, 'RUB');
ALTER SEQUENCE currency_type_seq RESTART WITH 4;

INSERT INTO CLIENT (id, birth_day, first_name, last_name, client_level_type_id, client_status_type_id, active) VALUES
(1, '1980-03-14', 'Robert', 'Levandovsky', 1, 3, true),
(2, '1986-09-08', 'Michael', 'Phelps', 1, 3, true),
(3, '1991-01-14', 'Marten', 'Fourcade', 2, 1, true),
(4, '1996-07-30', 'Rafael', 'Nadal', 2, 1, true),
(5, '1997-05-20', 'Sergey', 'Bubka', 2, 1, true),
(6, '1996-02-21', 'Arvidas', 'Sabonis', 3, 1, true),
(7, '1986-03-25', 'Oksana', 'Bayul', 3, 2, true),
(8, '1980-04-03', 'Steffy', 'Graf', 4, 1, false),
(9, '1995-09-12', 'Vitaly', 'Klichko', 3, 2, true);
ALTER SEQUENCE client_id_seq RESTART WITH 10;

INSERT INTO CLIENT_STATUS_HISTORY (id, date_changed, client_id, client_status_type_id, active) VALUES
(1, '2017-04-01', 7, 1, true),
(2, '2017-04-10', 7, 2, true),
(3, '2017-01-01', 6, 1, true),
(4, '2017-02-01', 6, 2, true),
(5, '2017-03-10', 6, 1, true);
ALTER SEQUENCE client_status_history_id_seq RESTART WITH 6;

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
