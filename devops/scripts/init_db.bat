@echo off
SET DATABASE_NAME=rm-skills-9
SET NEW_USER=user
SET USER_PASSWORD=password

echo Creating the database...
mysql -u root -p -e "CREATE DATABASE IF NOT EXISTS `%DATABASE_NAME%`;"

echo Creating new user and granting privileges...
mysql -u root -p -e "CREATE USER IF NOT EXISTS '%NEW_USER%'@'localhost' IDENTIFIED BY '%USER_PASSWORD%'; GRANT ALL PRIVILEGES ON `%DATABASE_NAME%`.* TO '%NEW_USER%'@'localhost'; FLUSH PRIVILEGES;"

echo Done.
