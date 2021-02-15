DROP DATABASE IF EXISTS BookDB;
CREATE DATABASE BookDB;
USE BookDB;

DROP TABLE IF EXISTS Books;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Rating;

CREATE TABLE Books (
		BookID INT NOT NULL AUTO_INCREMENT,
        Name VARCHAR(150),
        Author VARCHAR(150),
        ISBN VARCHAR(20),
        PublicationYear INT,
        PRIMARY KEY (BookID)
);

CREATE TABLE Users (
	UserID INT AUTO_INCREMENT,
	UserName VARCHAR(20) NOT NULL,
    Password VARCHAR(20),
    PRIMARY KEY (UserID)
);

CREATE TABLE Reading (
	UserID INT,
    BookID INT,
    PRIMARY KEY (UserID, BookID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE,
    FOREIGN KEY (BookID) REFERENCES Books(BookID) ON DELETE CASCADE
);

CREATE TABLE Rating (
	BookID INT,
	Rating FLOAT,
    FOREIGN KEY (BookID) REFERENCES Books(BookID) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Books VALUES(1, 'Harry Potter and the Half-Blood Prince', 'J.K. Rowling',  '439785960', 2006);
INSERT INTO Books VALUES(2, 'Harry Potter and the Order of the Phoenix', 'J.K. Rowling',  '439358078', 2004);
INSERT INTO Books VALUES(3, 'Harry Potter and the Chamber of Secrets', 'J.K. Rowling','439554896', 2003);
INSERT INTO Books VALUES(4, 'Harry Potter and the Prisoner of Azkaban','J.K. Rowling','043965548X',2004);
INSERT INTO Books VALUES(5,  "The Ultimate Hitchhiker's Guide: Five Complete Novels and One Story", 'Douglas Adams',  '517226952', 2005);
INSERT INTO Books VALUES(6, 'A Short History of Nearly Everything' , 'Bill Bryson', '076790818X', 2004);
INSERT INTO Books VALUES(7, 'The Lord of the Rings (The Lord of the Rings  #1-3)', 'J.R.R. Tolkien',  '618517650', 2004);
INSERT INTO Books VALUES(8, 'The Lord of the Rings: Weapons and Warfare',	 'Chris Smith/Christopher Lee/Richard Taylor', '618391002', 2003);
INSERT INTO Books VALUES(9,'The Lord of the Rings: Complete Visual Companion','Jude Fisher'	,'618510826',2004);
INSERT INTO Books VALUES(10,'Agile Web Development with Rails: A Pragmatic Guide','Dave Thomas/David Heinemeier Hansson/Leon Breedt/Mike Clark/Thomas Fuchs/Andreas  Schwarz','097669400X',2005);
INSERT INTO Books VALUES(11,"Hatchet (Brian's Saga  #1)",'Gary Paulsen','689840926',2000);
INSERT INTO Books VALUES(12,'Hatchet: A Guide for Using "Hatchet" in the Classroom','Donna Ickes/Edward Sciranko/Keith Vasconcelles','1557344493',1994);
INSERT INTO Books VALUES(13,'Guts: The True Stories behind Hatchet and the Brian Books','Gary Paulsen','385326505',2001);
INSERT INTO Books VALUES(14,'Molly Hatchet - 5 of the Best','Molly Hatchet','1575606240',2003);
INSERT INTO Books VALUES(15,'Hatchet Jobs: Writings on Contemporary Fiction','Dale Peck','1595580271',2005);
INSERT INTO Books VALUES(16,'A Changeling for All Seasons (Changeling Seasons #1)','Angela Knight/Sahara Kelly/Judy Mays/Marteeka Karland/Kate Douglas/Shelby Morgen/Lacey Savage/Kate Hill/Willa Okati','1595962808',2005);
INSERT INTO Books VALUES(17,'Changeling (Changeling  #1)','Delia Sherman','670059676',2006);
INSERT INTO Books VALUES(18,'The Changeling Sea','Patricia A. McKillip','141312629',2003);
INSERT INTO Books VALUES(19,'The Changeling','Zilpha Keatley Snyder','595321801',2004);
INSERT INTO Books VALUES(20,'The Changeling','Kate Horsley','1590301943',2005);
INSERT INTO Books VALUES(21,'The Changeling (Daughters of England  #15)','Philippa Carr', '449146979',1990);
INSERT INTO Books VALUES(22,'The Known World'	, 'Edward P. Jones'	, '61159174',2006);
INSERT INTO Books VALUES(23,'The Known World'	 ,'Edward P. Jones/Kevin R. Free','006076273X',2004);
INSERT INTO Books VALUES(24,'The Known World'	, 'Edward P. Jones'	,'60749911'	,2004);
INSERT INTO Books VALUES(25,'Traders  Guns & Money: Knowns and Unknowns in the Dazzling World of Derivatives','Satyajit Das','273704745',2006);
INSERT INTO Books VALUES(26,'Artesia: Adventures in the Known World','Mark Smylie','1932386106',2005);
 INSERT INTO Books VALUES(27,'The John McPhee Reader (John McPhee Reader  #1)','John McPhee/William Howarth','374517193',	1982);
 INSERT INTO Books VALUES(28,'Uncommon Carriers','John McPhee','374280398',2006);
 INSERT INTO Books VALUES(29,'Heirs of General Practice','John McPhee','374519749',1986);
 INSERT INTO Books VALUES(30,'The Control of Nature','John McPhee','374522596',1990);
 INSERT INTO Books VALUES(31,'Annals of the Former World','John McPhee', '374518734',	1999);
 INSERT INTO Books VALUES(32,'Coming Into the Country','John McPhee','374522871',	1991);
 INSERT INTO Books VALUES(33,'La Place de la Concorde Suisse','John McPhee','374519323'	,1994);
INSERT INTO Books VALUES(34, 'Giving Good Weight','John McPhee','374516006'	,1994);
 INSERT INTO Books VALUES(35,'Rising from the Plains','John McPhee','374520658',1987);
INSERT INTO Books VALUES(36, 'The Heidi Chronicles'	, 'Wendy Wasserstein','822205106',2002);
INSERT INTO Books VALUES(37, "The Heidi Chronicles: Uncommon Women and Others & Isn't It Romantic",'Wendy Wasserstein','679734996',1991);
INSERT INTO Books VALUES(38, 'Active Literacy Across the Curriculum: Strategies for Reading, Writing, Speaking and Listening','Heidi Hayes Jacobs','1596670231',2006);
 INSERT INTO Books VALUES(39,'Simply Beautiful Beaded Jewelry','Heidi Boyd','1581807740',2006);
 INSERT INTO Books VALUES(40,"Always Enough: God's Miraculous Provision Among the Poorest Children on Earth",'Heidi Baker/Rolland Baker', '800793617',2003);
INSERT INTO Books VALUES(41, "Mapping the Big Picture: Integrating Curriculum & Assessment K-12",'Heidi Hayes Jacobs', '871202867',1997);
INSERT INTO Books VALUES(42, "Heidi (Heidi  #1-2)",'Johanna Spyri/Beverly Cleary/Angelo  Rinaldi', '753454947'	,2002);
INSERT INTO Books VALUES(43, 'Getting Results with Curriculum Mapping'	, 'Heidi Hayes Jacobs', '871209993'	,2004);
INSERT INTO Books VALUES(44, "There's Always Enough: The Miraculous Move of God in Mozambique"	, 'Rolland Baker/Heidi Baker'	, '1852402873'	 ,2003);
INSERT INTO Books VALUES(45, "What to Expect the First Year (What to Expect)",'Heidi Murkoff/Sharon Mazel/Arlene Eisenberg/Sandee Hathaway/Mark D. Widome'	, '761129588'	 ,2003);
INSERT INTO Books VALUES(46, "The Player's Handbook: The Ultimate Guide on Dating and Relationships"	, 'Heidi Fleiss/Libby Keatinge', '972016414'	,2004);
 INSERT INTO Books VALUES(47,'Simply Beautiful Beading: 53 Quick and Easy Projects',	 'Heidi Boyd', '1581805632'	,2004);
 INSERT INTO Books VALUES(48,'God Emperor of Dune (Dune Chronicles  #4)','Frank Herbert'	,	 '441294677',1987);
INSERT INTO Books VALUES(49, 'Chapterhouse: Dune (Dune Chronicles #6)'	, 'Frank Herbert'	, '441102670',	1987);
INSERT INTO Books VALUES(50, 'Dune Messiah (Dune Chronicles #2)','Frank Herbert', '441172695',1987);
INSERT INTO Books VALUES(51, 'Dreamer of Dune: The Biography of Frank Herbert'	, 'Brian Herbert', '765306476'	,2004);
INSERT INTO Books VALUES(52, 'Heretics of Dune (Dune Chronicles  #5)', 'Frank Herbert'	,'399128980',1984);
INSERT INTO Books VALUES(53, 'The Road to Dune',	 'Frank Herbert/Brian Herbert/Kevin J. Anderson', '765353709'	,2006);
 INSERT INTO Books VALUES(54,'Heretics of Dune (Dune Chronicles #5)', 'Frank Herbert', '441328008',	1987);
 INSERT INTO Books VALUES(55,'The Lord of the Rings: The Art of the Fellowship of the Ring',	 'Gary Russell'	, '618212906',2002);
INSERT INTO Books VALUES(56,'The Power of One (The Power of One  #1)',	 'Bryce Courtenay'	, '034541005X',1996);
INSERT INTO Books VALUES(57,'The Power of One (The Power of One  #1)'	, 'Bryce Courtenay', '385732546',2005);
INSERT INTO Books VALUES(58,'The Power of One: One Person  One Rule  One Month'	, 'John C. Maxwell/Stephen R. Graves/Thomas G. Addington'	,'785260056'	,2004);
INSERT INTO Books VALUES(59,'Power of an Hour: Business and Life Mastery in One Hour a Week'	, 'Dave Lakhani'	, '471780936'	,	2006);
INSERT INTO Books VALUES(60,'The Power of One: The Solo Play for Playwrights  Actors  and Directors'	, 'Louis E. Catron'	,'325001537'	,	2000);
INSERT INTO Books VALUES(61,'How to Buy  Sell & Profit on eBay: Kick-Start Your Home-Based Business in Just Thirty Days'	, 'Adam Ginsberg'	, '006076287X'	,	2005);
INSERT INTO Books VALUES(62,'eBay for Dummies',	 'Marsha Collier', '470045299',2006);
INSERT INTO Books VALUES(63,'What to Sell on ebay and Where to Get It: The Definitive Guide to Product Sourcing for eBay and Beyond',	 'Chris Malta/Lisa Suttora'	, '72262788',2006);
INSERT INTO Books VALUES(64,'Starting an eBay Business for Dummies'	 ,'Marsha Collier'	, '764569244'	,2004);
INSERT INTO Books VALUES(65,'eBay: Top 100 Simplified Tips & Tricks'	, 'Julia Wilkinson', '471933821',2006);
INSERT INTO Books VALUES(66,'ebay Timesaving Techniques for Dummies'	, 'Marsha Collier'	, '764559915'	 ,	2004);
INSERT INTO Books VALUES(67,'eBay Business All-in-One Desk Reference for Dummies',	 'Marsha Collier', '764584383',2005);
INSERT INTO Books VALUES(68,'Ruby Cookbook',	 'Lucas Carlson/Leonard Richardson'	, '596523696'	,2006);
INSERT INTO Books VALUES(69,"Ruby Ann's Down Home Trailer Park Cookbook"	, 'Ruby Ann Boxcar'	, '806523492',2005);
INSERT INTO Books VALUES(70,"Ruby Ann's Down Home Trailer Park BBQin' Cookbook"	 ,'Ruby Ann Boxcar'	,'806525363',2005);

INSERT INTO Users VALUES(1, 'npham', 'npham');
INSERT INTO Users VALUES(2, 'dave', 'dave');
INSERT INTO Users VALUES(3, 'alice', 'alice');

INSERT INTO Reading VALUES(1,	12);
INSERT INTO Reading VALUES(1,	5);
INSERT INTO Reading VALUES(1,	28);
INSERT INTO Reading VALUES(2,	14);
INSERT INTO Reading VALUES(2,	7);
INSERT INTO Reading VALUES(2,	51);
INSERT INTO Reading VALUES(3,	1);
INSERT INTO Reading VALUES(3,	9);
INSERT INTO Reading VALUES(3,	31);
INSERT INTO Reading VALUES(3,	62);
INSERT INTO Reading VALUES(3,	18);

INSERT INTO Rating VALUES(1,	4.57);
INSERT INTO Rating VALUES(2,	4.49);
INSERT INTO Rating VALUES(4	,4.42);
INSERT INTO Rating VALUES(5	,4.56);
INSERT INTO Rating VALUES(8	,4.78);
INSERT INTO Rating VALUES(9	,3.74);
INSERT INTO Rating VALUES(10,	4.73);
INSERT INTO Rating VALUES(12,	4.38);
INSERT INTO Rating VALUES(13,	4.38);
INSERT INTO Rating VALUES(14,	4.22);
INSERT INTO Rating VALUES(16,	4.22);
INSERT INTO Rating VALUES(18,	4.38);
INSERT INTO Rating VALUES(21,	4.21);
INSERT INTO Rating VALUES(22,	3.44);
INSERT INTO Rating VALUES(23,	3.87);
INSERT INTO Rating VALUES(24,	4.07);
INSERT INTO Rating VALUES(25,	3.9);
INSERT INTO Rating VALUES(26,	3.83);
INSERT INTO Rating VALUES(27,	3.86);
INSERT INTO Rating VALUES(28,	3.91);
INSERT INTO Rating VALUES(29,	3.93);
INSERT INTO Rating VALUES(30,	4.59);
INSERT INTO Rating VALUES(31,	4.5);
INSERT INTO Rating VALUES(34,	4.36);
INSERT INTO Rating VALUES(35,	4.5);
INSERT INTO Rating VALUES(36,	4.53);
INSERT INTO Rating VALUES(37,	4.5);
INSERT INTO Rating VALUES(45,	3.84);
INSERT INTO Rating VALUES(50,	3.72);
INSERT INTO Rating VALUES(51,	4);
INSERT INTO Rating VALUES(53,	3.88);
INSERT INTO Rating VALUES(54,	4.33);
INSERT INTO Rating VALUES(55,	3.45);
INSERT INTO Rating VALUES(57,	3.76);
INSERT INTO Rating VALUES(58,	3.6);
INSERT INTO Rating VALUES(59,	4.06);
INSERT INTO Rating VALUES(61,	4.17);
INSERT INTO Rating VALUES(63,	3.55);
INSERT INTO Rating VALUES(66,	3.98);
INSERT INTO Rating VALUES(67,	3.83);
INSERT INTO Rating VALUES(68,	3.83);
INSERT INTO Rating VALUES(69,	3.83);
INSERT INTO Rating VALUES(70,	3.83);

DROP VIEW IF EXISTS ViewUsers;
CREATE VIEW ViewUsers AS (SELECT UserID, UserName FROM Users);
select * from Users;

DROP PROCEDURE IF EXISTS getUserBooks;
SET DELIMITER !!!
CREATE PROCEDURE getUserBooks (p_userName VARCHAR(20))
READS SQL DATA
BEGIN
   SELECT Name FROM Users
	JOIN Reading USING (UserID)
	JOIN Books USING (BookID)
	WHERE UserName = p_userName;
END!!!
SET DELIMITER ;

DROP PROCEDURE IF EXISTS addUserBook;
SET DELIMITER !!!
CREATE PROCEDURE addUserBook (p_BookID INT, p_UserName VARCHAR(20))
READS SQL DATA
BEGIN
	DECLARE i_UserID INT;
	SELECT UserID INTO i_UserID
    FROM Users
    WHERE UserName = p_UserName;
    
    INSERT INTO Reading VALUES(i_UserID, p_BookID);
END!!!
SET DELIMITER ;

DROP PROCEDURE IF EXISTS deleteUserBook;
SET DELIMITER !!!
CREATE PROCEDURE deleteUserBook (p_BookName VARCHAR(150))
READS SQL DATA
BEGIN
	DECLARE i_BookID INT;
	SELECT BookID INTO i_BookID
    FROM Books
    WHERE Name = p_BookName;
    
    DELETE FROM Reading WHERE BookID = i_BookID;
END!!!
SET DELIMITER ;

DROP PROCEDURE IF EXISTS getBookID;
SET DELIMITER !!!
CREATE PROCEDURE getBookID (p_BookName VARCHAR(150))
READS SQL DATA
BEGIN
	SELECT MIN(BookID)
    FROM Books
    WHERE Name LIKE CONCAT('%', p_BookName, '%');
    
END!!!
SET DELIMITER ;
