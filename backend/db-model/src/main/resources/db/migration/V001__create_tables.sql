CREATE TABLE IF NOT EXISTS USER
(
    user_id       SERIAL PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    role          ENUM('R', 'B'),
    administrator BOOLEAN     NOT NULL
);
