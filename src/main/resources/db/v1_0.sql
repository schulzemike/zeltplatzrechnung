--liquibase formatted sql

--changeset mike.schulze:1
CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(256) DEFAULT NULL,
  password varchar(256) DEFAULT NULL,
  surname varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

INSERT INTO user (username, password, surname) VALUES ('zepalei', '$2a$10$hqbXJnySFCOg9Zw8kmZYGuSSIymC6o3i2wQwtQGfXMAmtzMrj2n4a', 'Schulze');
INSERT INTO user (username, password, surname) VALUES ('cf', '$2a$10$hqbXJnySFCOg9Zw8kmZYGuSSIymC6o3i2wQwtQGfXMAmtzMrj2n4a', 'Schulze');
--rollback drop table user;


