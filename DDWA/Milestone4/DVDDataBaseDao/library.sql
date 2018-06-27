DROP DATABASE IF EXISTS library;

CREATE DATABASE library;

USE library;

CREATE TABLE `dvd`
(
	`DVDId` int auto_increment NOT NULL,
    `DVDTitle` varchar(100) NULL,
    `ReleaseYear` int NULL,
    `Director` varchar(100) NULL,
    `Rating` varchar(100) NULL,
    `Notes` varchar(500) NULL,
    PRIMARY KEY (DVDId)
);

