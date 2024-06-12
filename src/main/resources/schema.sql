DROP TABLE IF EXISTS note;
DROP TABLE IF EXISTS christian;
DROP TABLE IF EXISTS schedule;

CREATE TABLE note (
    note_id SERIAL PRIMARY KEY,
    christian_id INT,
    created_date TIMESTAMP not null,
    modified_date TIMESTAMP not null,
    part VARCHAR(50) not null,
    keyword VARCHAR(150),
    content TEXT not null,
    goal VARCHAR(4000),
    share BOOLEAN not null
);

CREATE EXTENSION citext;
CREATE DOMAIN DOMAIN_EMAIL AS citext
    CHECK (
        VALUE ~ '^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$'
    );

CREATE TABLE christian (
    user_id SERIAL PRIMARY KEY,
    password VARCHAR(250) not null,
    name VARCHAR(70) not null,
    mail DOMAIN_EMAIL not null,
    role VARCHAR(15) not null,
    provider VARCHAR(30),
    provider_id VARCHAR(100)
);

ALTER TABLE note ADD CONSTRAINT fk_christian FOREIGN KEY (christian_id) REFERENCES christian(user_id);

CREATE TABLE schedule (
    schedule_id SERIAL PRIMARY KEY,
    christian_id INT,
    created_date TIMESTAMP not null,
    modified_date TIMESTAMP not null,
    targetDate DATE not null,
    goal VARCHAR(100) not null,
    achieve BOOLEAN not null
);

ALTER TABLE schedule ADD CONSTRAINT fk_christian FOREIGN KEY (christian_id) REFERENCES christian(user_id);