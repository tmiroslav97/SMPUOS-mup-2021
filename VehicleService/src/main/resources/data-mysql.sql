insert into persons (ID, first_name, last_name, UID, birth_date, role) values
    (1, 'Ime', 'Prezime', '1234123400121', '1998-06-04 00:00:00+00:00', 'DRIVER');
insert into persons (ID, first_name, last_name, UID, birth_date, role) values
    (2, 'Tanja', 'Savic', '1234123400122', '1999-02-16 00:00:00+00:00', 'DRIVER');
insert into persons (ID, first_name, last_name, UID, birth_date, role) values
    (3, 'Lora', 'Ipsic', '1234123400123', '1996-04-02 00:00:00+00:00', 'STUDENT');
insert into persons (ID, first_name, last_name, UID, birth_date, role) values
    (4, 'Mahmut', 'Hajdarpasic', '1234123400124', '1997-06-28 00:00:00+00:00', 'STUDENT');
insert into persons (ID, first_name, last_name, UID, birth_date, role) values
    (5, 'Milutin', 'Stojic', '1234123400125', '1970-01-01 00:00:00+00:00', 'INSTRRUCTOR');
insert into persons (ID, first_name, last_name, UID, birth_date, role) values
    (6, 'Milunka', 'Bojevic', '1234123400126', '2000-01-01 00:00:00+00:00', 'STUDENT');


insert into lessons (ID, datee, subject, student_id, instructor_id) values
    (1, '2020-05-02 12:30:00+00:00', 'SAFETY', 3, 5);
insert into lessons (ID, datee, subject, student_id, instructor_id) values
    (2, '2020-05-03 12:30:00+00:00', 'OPERATING', 3, 5);
insert into lessons (ID, datee, subject, student_id, instructor_id) values
    (3, '2020-05-04 12:30:00+00:00', 'SIGNS', 3, 5);
insert into lessons (ID, datee, subject, student_id, instructor_id) values
    (4, '2020-05-02 09:00:00+00:00', 'SAFETY', 4, 5);
insert into lessons (ID, datee, subject, student_id, instructor_id) values
    (5, '2020-05-02 12:30:00+00:00', 'SAFETY', 6, 5);
insert into lessons (ID, datee, subject, student_id, instructor_id) values
    (6, '2020-05-03 12:30:00+00:00', 'OPERATING', 6, 5);
insert into lessons (ID, datee, subject, student_id, instructor_id) values
    (7, '2020-05-04 12:30:00+00:00', 'SIGNS', 6, 5);


insert into exams (ID, datee, passed, student_id, examinar_id) values
    (1, '2020-10-02 09:00:00+00:00', 0, 1, 5);
insert into exams (ID, datee, passed, student_id, examinar_id) values
    (2, '2020-10-03 09:00:00+00:00', 1, 1, 5);
insert into exams (ID, datee, passed, student_id, examinar_id) values
    (3, '2020-10-04 09:00:00+00:00', 1, 2, 5);
insert into exams (ID, datee, passed, student_id, examinar_id) values
    (4, '2020-10-013 09:00:00+00:00', 0, 3, 5);


insert into licences (ID, origin_date, expiration_date, valid, holder_id) values
    (1, '2012-10-013 09:00:00+00:00', '2022-10-013 09:00:00+00:00', 1, 1);
insert into licences (ID, origin_date, expiration_date, valid, holder_id) values
    (2, '1992-10-013 09:00:00+00:00', '2012-10-013 09:00:00+00:00', 0, 1);
insert into licences (ID, origin_date, expiration_date, valid, holder_id) values
    (3, '2013-10-013 09:00:00+00:00', '2023-10-013 09:00:00+00:00', 1, 2);
insert into licences (ID, origin_date, expiration_date, valid, holder_id) values
    (4, '2014-10-013 09:00:00+00:00', '2024-10-013 09:00:00+00:00', 1, 3);


insert into tickets (ID, datee, offense, points, licence_id) values
    (1, '2017-10-013 09:00:00+00:00', 'Red light', 3, 1);
insert into tickets (ID, datee, offense, points, licence_id) values
    (2, '2018-10-013 09:00:00+00:00', 'Bad parking', 1, 1);
insert into tickets (ID, datee, offense, points, licence_id) values
    (3, '2019-10-013 09:00:00+00:00', 'Collision', 8, 1);









