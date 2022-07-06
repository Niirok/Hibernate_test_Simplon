DROP DATABASE IF EXISTS TP_hibernate;
CREATE DATABASE TP_hibernate;

USE TP_hibernate;

CREATE TABLE T_Articles (
    IdArticle INT PRIMARY KEY AUTO_INCREMENT,
    Description text NOT NULL,
    Brand text NOT NULL,
    UnitaryPrice double NOT NULL
);

INSERT INTO T_Articles(Description, Brand, UnitaryPrice) VALUES  ('Description descriptive qui décrit', 'Adadas', 9.99);
INSERT INTO T_Articles(Description, Brand, UnitaryPrice) VALUES  ('Description descriptive qui décrit', 'Le Coq pas trop sportif', 10.99);