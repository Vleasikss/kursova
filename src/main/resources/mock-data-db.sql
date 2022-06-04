USE students_db;

# FACULTIES

INSERT INTO FACULTY
VALUES ('ФІСІТ');
INSERT INTO FACULTY
VALUES ('ФЕТАУ');
INSERT INTO FACULTY
VALUES ('ЮІ');
INSERT INTO FACULTY
VALUES ('МЕІМ');

# GROUPS

INSERT INTO `GROUP`
VALUES ('IA-101', 'ФІСІТ', 124, 1);
INSERT INTO `GROUP`
VALUES ('IА-201', 'ФІСІТ', 124, 2);
INSERT INTO `GROUP`
VALUES ('ІА-301', 'ФІСІТ', 124, 3);
INSERT INTO `GROUP`
VALUES ('ІА-401', 'ФІСІТ', 124, 4);
INSERT INTO `GROUP`
VALUES ('ІК-101', 'ФІСІТ', 125, 1);
INSERT INTO `GROUP`
VALUES ('ІК-201', 'ФІСІТ', 125, 2);
INSERT INTO `GROUP`
VALUES ('ІК-401', 'ФІСІТ', 125, 3);
INSERT INTO `GROUP`
VALUES ('ІК-401', 'ФІСІТ', 125, 4);
INSERT INTO `GROUP`
VALUES ('ІН-101', 'ФІСІТ', 122, 1);
INSERT INTO `GROUP`
VALUES ('ІН-201', 'ФІСІТ', 122, 2);
INSERT INTO `GROUP`
VALUES ('ІН-301', 'ФІСІТ', 122, 3);
INSERT INTO `GROUP`
VALUES ('ІН-401', 'ФІСІТ', 122, 4);
INSERT INTO `GROUP`
VALUES ('ІН-102', 'ФІСІТ', 122, 1);
INSERT INTO `GROUP`
VALUES ('ІН-202', 'ФІСІТ', 122, 2);
INSERT INTO `GROUP`
VALUES ('ІН-302', 'ФІСІТ', 122, 3);
INSERT INTO `GROUP`
VALUES ('ІН-402', 'ФІСІТ', 122, 4);

INSERT INTO `GROUP`
VALUES ('ЮГ-101', 'ЮІ', 011, 1);
INSERT INTO `GROUP`
VALUES ('ЮГ-201', 'ЮІ', 011, 2);
INSERT INTO `GROUP`
VALUES ('ЮГ-301', 'ЮІ', 011, 3);
INSERT INTO `GROUP`
VALUES ('ЮГ-401', 'ЮІ', 011, 4);

INSERT INTO `GROUP`
VALUES ('ЕК-101', 'ФЕТАУ', 051, 1);
INSERT INTO `GROUP`
VALUES ('ЕК-201', 'ФЕТАУ', 051, 2);
INSERT INTO `GROUP`
VALUES ('ЕК-301', 'ФЕТАУ', 051, 3);
INSERT INTO `GROUP`
VALUES ('ЕК-401', 'ФЕТАУ', 051, 4);

INSERT INTO `GROUP`
VALUES ('МЕ-101', 'МЕІМ', 073, 1);
INSERT INTO `GROUP`
VALUES ('МЕ-201', 'МЕІМ', 073, 2);
INSERT INTO `GROUP`
VALUES ('МЕ-301', 'МЕІМ', 073, 3);
INSERT INTO `GROUP`
VALUES ('МЕ-401', 'МЕІМ', 073, 4);

INSERT INTO `GROUP`
VALUES ('ЮЛ-101', 'ЮІ', 012, 1);
INSERT INTO `GROUP`
VALUES ('ЮЛ-201', 'ЮІ', 012, 2);
INSERT INTO `GROUP`
VALUES ('ЮЛ-301', 'ЮІ', 012, 3);
INSERT INTO `GROUP`
VALUES ('ЮЛ-401', 'ЮІ', 012, 4);





# STUDENTS

INSERT INTO STUDENT
VALUES (1, 'Дарина', 'Іванова', 'Олегівна', 'CONTRACT', 'ФІСІТ', 'IА-101', 88.3);
INSERT INTO STUDENT
VALUES (2, 'Дмитро', 'Міхненко', 'Олексійович', 'BUDGET', 'ФІСІТ', 'IА-101', 86.4);
INSERT INTO STUDENT
VALUES (3, 'Олена', 'Бобенко', 'Михайлівна', 'BUDGET', 'ФІСІТ', 'IA-101', 70.6);
INSERT INTO STUDENT
VALUES (4, 'Ірина', 'Короленко', 'Павлівна', 'BUDGET', 'ФІСІТ', 'IА-!01', 93.9);
INSERT INTO STUDENT
VALUES (5, 'Сеогій', 'Мудрик', 'Сергійович', 'CONTRACT', 'ФІСІТ', 'IА-101', 73.5);
INSERT INTO STUDENT
VALUES (6, 'Сеогій', 'Герасименко', 'Ігорович', 'BUDGET', 'ФІСІТ', 'IА-101', 69.8);
INSERT INTO STUDENT
VALUES (7, 'Ангеліна', 'Андрієнко', 'Віталіївна',  'BUDGET', 'ФІСІТ', 'IА-101', 83.5);
INSERT INTO STUDENT
VALUES (8, 'Вікторія', 'Лопухова', 'Леонідівна', 'BUDGET', 'ФІСІТ', 'IА-101', 67.5);
INSERT INTO STUDENT
VALUES (9, 'Ярина', 'Гладка', 'Богданівна',  'BUDGET', 'ФІСІТ', 'IА-101', 84.3);
INSERT INTO STUDENT
VALUES (10, 'Ігор', 'Трохимчук', 'Данилович',  'BUDGET', 'ФІСІТ', 'IА-101', 89.6);
INSERT INTO STUDENT
VALUES (11, 'Людмила', 'Матвієнко', 'Михайлівна',  'BUDGET', 'ФІСІТ', 'IА-101', 64.3);
INSERT INTO STUDENT
VALUES (12, 'Тетяна', 'Дубова', 'Сергіївна', 'CONTRACT', 'ФІСІТ', 'IА-101', 45.6);
INSERT INTO STUDENT
VALUES (13, 'Руслан', 'Романюк', 'Романович', 'CONTRACT', 'ФІСІТ', 'IА-101', 53.5);
INSERT INTO STUDENT
VALUES (14, 'Павло', 'Недашківський', 'Русланович',  'BUDGET', 'ФІСІТ', 'IА-101', 76.8);
INSERT INTO STUDENT
VALUES (15, 'Лілія', 'Харевська', 'Олександрівна',  'BUDGET', 'ФІСІТ', 'IА-101', 67.3);
INSERT INTO STUDENT
VALUES (16, 'Даяна', 'Чернецька', 'Віталіївна',  'BUDGET', 'ФІСІТ', 'IА-101', 76.2);

INSERT INTO STUDENT
VALUES (1, 'Денис', 'Вирвихвіст', 'Олегович', 'CONTRACT', 'ФІСІТ', 'IА-201', 83.3);
INSERT INTO STUDENT
VALUES (2, 'Діна', 'Мартиненко', 'Олексіївна', 'BUDGET', 'ФІСІТ', 'IА-201', 78.4);
INSERT INTO STUDENT
VALUES (3, 'Діма', 'Вольвах', 'Михайлівна', 'BUDGET', 'ФІСІТ', 'IA-201', 67.6);
INSERT INTO STUDENT
VALUES (4, 'Яніна', 'Короленко', 'Павлівна', 'BUDGET', 'ФІСІТ', 'IА-201', 91.9);
INSERT INTO STUDENT
VALUES (5, 'Софія', 'Оксаніч', 'Богданівна', 'CONTRACT', 'ФІСІТ', 'IА-201', 72.5);
INSERT INTO STUDENT
VALUES (6, 'Юлія', 'Петренко', 'Миколаївна', 'BUDGET', 'ФІСІТ', 'IА-201', 60.8);
INSERT INTO STUDENT
VALUES (7, 'Людмила', 'Лукашенко', 'Віталіївна',  'BUDGET', 'ФІСІТ', 'IА-201', 74.5);
INSERT INTO STUDENT
VALUES (8, 'Вікторія', 'Якименко', 'Дмитрівна', 'BUDGET', 'ФІСІТ', 'IА-201', 69.5);
INSERT INTO STUDENT
VALUES (9, 'Яніна', 'Глушенко', 'Богданівна',  'BUDGET', 'ФІСІТ', 'IА-201', 82.3);
INSERT INTO STUDENT
VALUES (10, 'Артем', 'Сивко', 'Миколайович',  'BUDGET', 'ФІСІТ', 'IА-201', 85.6);

INSERT INTO STUDENT
VALUES (1, 'Єгор', 'Вирвихвіст', 'Олегович', 'CONTRACT', 'ФІСІТ', 'IК-201', 81.3);
INSERT INTO STUDENT
VALUES (2, 'Діна', 'Єремчук', 'Олексіївна', 'BUDGET', 'ФІСІТ', 'IК-201', 78.4);
INSERT INTO STUDENT
VALUES (3, 'Олена', 'Вольвах', 'Михайлівна', 'BUDGET', 'ФІСІТ', 'IК-201', 70.6);
INSERT INTO STUDENT
VALUES (4, 'Інна', 'Королюк', 'Павлівна', 'BUDGET', 'ФІСІТ', 'IК-201', 89.9);
INSERT INTO STUDENT
VALUES (5, 'Софія', 'Мартинюк', 'Сергіївна', 'CONTRACT', 'ФІСІТ', 'IК-201', 72.5);
INSERT INTO STUDENT
VALUES (6, 'Ніна', 'Герасимчук', 'Миколаївна', 'BUDGET', 'ФІСІТ', 'IК-201', 61.8);
INSERT INTO STUDENT
VALUES (7, 'Ангеліна', 'Лукашенко', 'Віталіївна',  'BUDGET', 'ФІСІТ', 'IК-201', 56.5);
INSERT INTO STUDENT
VALUES (8, 'Інна', 'Якимчук', 'Ігорівна', 'BUDGET', 'ФІСІТ', 'IК-201', 67.5);
INSERT INTO STUDENT
VALUES (9, 'Яніна', 'Гладка', 'Богданівна',  'BUDGET', 'ФІСІТ', 'IК-201', 80.3);
INSERT INTO STUDENT
VALUES (10, 'Яків', 'Сивко', 'Миколайович',  'BUDGET', 'ФІСІТ', 'IК-201', 82.6);

INSERT INTO STUDENT
VALUES (1, 'Арсен', 'Воронюк', 'Миколайович', 'CONTRACT', 'ФІСІТ', 'IН-201', 84.3);
INSERT INTO STUDENT
VALUES (1, 'Діна', 'Фатіль', 'Олексіївна', 'BUDGET', 'ФІСІТ', 'IН-101', 76.4);
INSERT INTO STUDENT
VALUES (2, 'Аня', 'Петриченко', 'Іванівна', 'BUDGET', 'ФІСІТ', 'IН-101', 67.6);
INSERT INTO STUDENT
VALUES (2, 'Анастасія', 'Короленко', 'Михайлівна', 'BUDGET', 'ФІСІТ', 'IН-201', 90.9);
INSERT INTO STUDENT
VALUES (3, 'Руслана', 'Стрюк', 'Богданівна', 'CONTRACT', 'ФІСІТ', 'IН-201', 70.5);

INSERT INTO STUDENT
VALUES (1, 'Арсен', 'Хиля', 'Михайлович', 'CONTRACT', 'ЮІ', 'ЮЛ-201', 84.3);
INSERT INTO STUDENT
VALUES (1, 'Богдана', 'Фирка', 'Олегівна', 'BUDGET', 'ЮІ', 'ЮГ-401', 76.4);
INSERT INTO STUDENT
VALUES (2, 'Ірина', 'Павлова', 'Іванівна', 'BUDGET', 'ЮІ', 'ЮЛ-201', 67.6);
INSERT INTO STUDENT
VALUES (1, 'Анастасія', 'Кириченко', 'Михайлівна', 'BUDGET', 'ЮІ', 'ЮЛ-301', 90.9);
INSERT INTO STUDENT
VALUES (1,'Руслана', 'Сірко', 'Богданівна', 'CONTRACT', 'ЮІ', 'ЮГ-201', 70.5);

INSERT INTO STUDENT
VALUES (1, 'Арина', 'Хома', 'Михайлович', 'CONTRACT', 'МЕІМ', 'МЕ-301', 84.3);
INSERT INTO STUDENT
VALUES (1, 'Богдана', 'Візіренко', 'Даніїлівна', 'BUDGET', 'МЕІМ', 'МЕ-401', 76.4);
INSERT INTO STUDENT
VALUES (1, 'Ірина', 'Дончекно', 'Павлівна', 'BUDGET', 'МЕІМ', 'МЕ-201', 67.6);

