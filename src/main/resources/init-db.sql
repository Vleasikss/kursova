# DROP
DROP DATABASE IF EXISTS students_db;

# INIT DB
CREATE DATABASE students_db;
USE students_db;

# INIT TABLES
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