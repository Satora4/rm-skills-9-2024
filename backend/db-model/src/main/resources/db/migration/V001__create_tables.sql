CREATE TABLE IF NOT EXISTS ANALYSIS
(
    id              SERIAL PRIMARY KEY,
    phone_name      VARCHAR(50) NOT NULL UNIQUE,
    price           INT         NOT NULL,
    manufacture     ENUM('GOOGLE', 'APPLE', 'SAMSUNG', 'HUAWEI'),
    look_and_feel   ENUM('VERY_GOOD', 'GOOD', 'VERY_BAD', 'UNACCEPTABLE'),
    ram             INT         NOT NULL,
    os              ENUM('ANDROID', 'IOS', 'HARMONY_OS'),
    os_version      INT         NOT NULL,
    storage         INT         NOT NULL,
    cam             INT         NOT NULL
);
