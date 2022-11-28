CREATE TABLE IF NOT EXISTS users (
    id SERIAL NOT NULL,
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS files (
    id SERIAL NOT NULL,
    filename VARCHAR(255),
    size INT,
    date DATE
);

INSERT INTO users (username, password, role)
VALUES ('Andrey', '0000', 'ROLE_ADMIN'),
       ('Mikhail', '1111', 'ROLE_USER'),
       ('Petr', '2222', 'ROLE_USER');

INSERT INTO files (filename, size, date)
VALUES ('Readme.txt',1024,'2022-03-11'),
       ('Start.txt',1024,'2022-05-17'),
       ('Finish.txt',1024,'2022-08-19');