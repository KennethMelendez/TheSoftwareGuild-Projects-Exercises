/*DROP DATABASE MovieCatalogue;*/

CREATE DATABASE IF NOT EXISTS MovieCatalogue;


USE MovieCatalogue;


CREATE TABLE IF NOT EXISTS `Genre` (
	`GenreID` int(11) not null auto_increment,
	`GenreName` varchar(30) not null,
    PRIMARY KEY (`GenreID`)
);

CREATE TABLE IF NOT EXISTS `Rating` (
	`RatingID` int(11) not null auto_increment,
	`RatingName` varchar(5) not null,
    PRIMARY KEY (`RatingID`)
);

CREATE TABLE IF NOT EXISTS `Director` (
	`DirectorID` int(11) not null auto_increment,
	`FirstName` varchar(30) not null,
	`LastName` varchar(30) not null,
	`BirthDate` date null,
    PRIMARY KEY (`DirectorID`)
);

CREATE TABLE IF NOT EXISTS `Actor` (
	`ActorID` int(11) not null auto_increment,
	`FirstName` varchar(30) not null,
	`LastName` varchar(30) not null,
	`BirthDate` date null,
    PRIMARY KEY (`ActorID`)
   
);

CREATE TABLE IF NOT EXISTS `Movie` (
	`MovieID` int(11) not null auto_increment,
	`GenreID` int(11) not null,
	`DirectorID` int(11) null,
	`RatingID` int(11) null,
	`Title` varchar(128) not null,
	`ReleaseDate` date null,
    PRIMARY KEY (`MovieID`),
	FOREIGN KEY (`GenreID`) REFERENCES Genre(`GenreID`),
    FOREIGN KEY (`DirectorID`) REFERENCES Director(`DirectorID`),
    FOREIGN KEY (`RatingID`) REFERENCES Rating(`RatingID`)
);

/*
ALTER TABLE `Movie`
 ADD CONSTRAINT `fk_MovieGenre` FOREIGN KEY (`GenreID`) REFERENCES `Genre`
(`GenreID`) ON DELETE NO ACTION;
ALTER TABLE `Movie`
 ADD CONSTRAINT `fk_MovieDirector` FOREIGN KEY (`DirectorID`) REFERENCES `Director`
(`DirectorID`) ON DELETE NO ACTION;
ALTER TABLE `Movie`
 ADD CONSTRAINT `fk_MovieRating` FOREIGN KEY (`RatingID`) REFERENCES `Rating`
(`RatingID`) ON DELETE NO ACTION;
*/
CREATE TABLE IF NOT EXISTS `CastMember` (
	`CastMemberID` int(11) not null auto_increment,
	`ActorID` int(11) not null,
	`MovieID` int(11) not null,
	`Role` varchar(50) not null,
    PRIMARY KEY (`CastMemberID`),
    FOREIGN KEY	(`ActorID`) REFERENCES Actor(`ActorID`),
    FOREIGN KEY (`MovieID`) REFERENCES Movie(`MovieID`)
);

/*
ALTER TABLE `CastMember`
 ADD CONSTRAINT `fkCastMemberActor` FOREIGN KEY (`ActorID`) REFERENCES `Actor`
(`ActorID`) ON DELETE NO ACTION;


ALTER TABLE `CastMember`
 ADD CONSTRAINT `fkCastMemberMovie` FOREIGN KEY (`MovieID`) REFERENCES `Movie`
(`MovieID`) ON DELETE NO ACTION;
*/

-- inserting into database
-- INSERT INTO actor(FirstName,LastName,BirthDate)
-- VALUES('Bill','Murray','1950-09-21'),
-- ('Dan','Akyroyd','1952-07-01'),
-- ('John','Candy','1950-10-31'),
-- ('Steve','Martin',NULL),
-- ('Sylvester','Stallone', NULL);

-- SELECT * FROM actor;

-- SELECT * FROM Director;

-- INSERT INTO Director (FirstName,LastName,BirthDate)
-- VALUES('Ivan','Reitman','1946-10-27'),
-- ('Ted','Kotcheff',NULL)

-- SELECT * FROM director;

-- INSERT INTO rating(RatingName)
-- VALUES('G'),
-- ('PG'),
-- ('PG-13'),
-- ('R');

-- SELECT * FROM Rating;

-- INSERT INTO Genre(GenreName)
-- VALUES('Action'),('Comedy'),('Drama'),('Horror');

-- SELECT * FROM GENRE;
-- SELECT * FROM Movie;

-- INSERT INTO Movie(GenreID,DirectorID,RatingID,Title,ReleaseDate)
-- VALUES(1,2,4,'Rambo: First Blood','1982-10-22'),
-- (2,NULL,4,'Planes, Trains & Automobiles','1987-11-25'),
-- (2,1,2,'Ghostbusters',NULL),
-- (2,NULL,2,'The Great Outdoors','1988-06-17');

-- SELECT * FROM Movie;

-- SELECT * FROM CastMember;

-- INSERT INTO CastMember(ActorID,MovieID,Role)
-- VALUE(5,1,'John Rambo'),
-- (4,2,'Neil Page'),
-- (3,2,'Del Griffith'),
-- (1,3,'Dr. Peter Venkman'),
-- (2,3,'Dr. Raymond Stanz'),
-- (2,4,'Roman Craig'),
-- (3,4,'CHet Ripley');
-- SELECT * FROM CastMember;
-- SELECT * FROM Movie;

-- UPDATE Movie
-- SET Title = 'Ghostbusters(1984)', ReleaseDate = '1984-06-08'
-- WHERE MovieID = 3;

 -- SELECT * FROM movie;
 -- DELETE FROM CastMember
 -- WHERE MovieID = 1;
 -- DELETE FROM Movie 
 -- WHERE MovieID = 1;
 
-- SELECT * FROM Movie;

-- ALTER TABLE Actor
-- ADD DateOfDeath Char;
 -- SELECT * FROM actor;
 
 -- ALTER TABLE Actor
 -- MODIFY COLUMN DateOfDeath date;
-- SELECT * FROM actor;

 -- UPDATE Actor
 -- SET DateOfDeath = '1994-03-04'
 -- WHERE ActorID = 3;

 -- SELECT * FROM actor;

-- DROP DATABASE moviecatalogue;