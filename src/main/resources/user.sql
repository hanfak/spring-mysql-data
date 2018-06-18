create database db_example;

create user 'springuser'@'localhost' identified by 'ThePassword';

grant all on db_example.* to 'springuser'@'localhost';

use db_example;

CREATE TABLE user (
  id INT(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(500) NOT NULL,
  email VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

