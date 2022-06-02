DROP DATABASE IF EXISTS kursova_project_java;

CREATE DATABASE kursova_project_java;
USE kursova_project_java;

CREATE TABLE STUDENT
(
    id           bigint primary key auto_increment,
    first_name   varchar(64) not null,
    last_name    varchar(64) not null,
    patronymic   varchar(64) not null,
    form         varchar(32) not null,
    faculty_id   varchar(64) not null,
    group_id     varchar(64) not null,
    rating_score double      not null
);

CREATE TABLE FACULTY
(
    faculty_name varchar(64) not null primary key
);

CREATE TABLE SPECIALITY
(
    speciality_name int not null primary key
);

CREATE TABLE `GROUP`
(
    group_name      varchar(64) not null primary key,
    faculty_name    varchar(64) not null,
    speciality_name int         not null,
    course          int         not null
);

ALTER TABLE STUDENT
    ADD CONSTRAINT student_group_id
        FOREIGN KEY (group_id)
            REFERENCES `GROUP` (group_name) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE STUDENT
    ADD CONSTRAINT student_faculty_id
        FOREIGN KEY (faculty_id)
            REFERENCES FACULTY (faculty_name) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `GROUP`
    ADD CONSTRAINT group_faculty_id
        FOREIGN KEY (faculty_name)
            REFERENCES FACULTY (faculty_name) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `GROUP`
    ADD CONSTRAINT group_speciality_id
        FOREIGN KEY (speciality_name)
            REFERENCES SPECIALITY (speciality_name) ON DELETE CASCADE ON UPDATE CASCADE;


# PUT SOME MOCK DATA

INSERT INTO FACULTY
VALUES ('IKCT');
INSERT INTO SPECIALITY
VALUES (122);
INSERT INTO `GROUP`
VALUES ('IS-101', 'IKCT', 122, 1);
INSERT INTO STUDENT
VALUES (1, 'Oleg', 'Olegov', 'Olegovich', 'CONTRACT', 'IKCT', 'IS-101', 88.3);

INSERT INTO FACULTY
VALUES ('FTAU');
INSERT INTO SPECIALITY
VALUES (064);
INSERT INTO `GROUP`
VALUES ('OP-202', 'FTAU', 064, 2);
INSERT INTO STUDENT
VALUES (2, 'Dima', 'Dimov', 'Dimovich', 'CONTRACT', 'FTAU', 'OP-202', 86.4);

INSERT INTO FACULTY
VALUES ('IT');
INSERT INTO SPECIALITY
VALUES (124);
INSERT INTO `GROUP`
VALUES ('IA-302', 'IT', 124, 3);
INSERT INTO STUDENT
VALUES (3, 'Alena', 'Alenovna', 'Alenovich', 'BUDGET', 'IT', 'IA-302', 70.6);

INSERT INTO FACULTY
VALUES ('IKT');
INSERT INTO SPECIALITY
VALUES (125);
INSERT INTO `GROUP`
VALUES ('IK-201', 'IKT', 125, 2);
INSERT INTO STUDENT
VALUES (4, 'Dasha', 'Dashev', 'Dashevich', 'BUDGET', 'IKT', 'IK-201', 93.9);
INSERT INTO STUDENT
VALUES (5, 'Abdul', 'Abdulov', 'Abdulovich', 'CONTRACT', 'IKT', 'IK-201', 73.5);

INSERT INTO FACULTY
VALUES ('IC');
INSERT INTO SPECIALITY
VALUES (074);
INSERT INTO `GROUP`
VALUES ('MN-401', 'IC', 074, 4);
INSERT INTO STUDENT
VALUES (6, 'Vlad', 'Vladov', 'Vladovich', 'CONTRACT', 'IC', 'MN-401', 64.6);