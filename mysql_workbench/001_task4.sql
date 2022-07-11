USE MyJoinsDB1;

CREATE TABLE Phones
(id int auto_increment not null primary key,
Name varchar(30),
Phone varchar(15)
);

CREATE TABLE SalaryAndPosition
(id INT NOT NULL UNIQUE,
salary DECIMAL(10,2),
position VARCHAR(30),
PRIMARY KEY (id),
FOREIGN KEY (id) REFERENCES Phones(id)
);

CREATE TABLE info
(id INT NOT NULL UNIQUE,
marital_status VARCHAR(30),
DateOfBirth DATE,
PlaceOfLive VARCHAR(30),
PRIMARY KEY (id),
FOREIGN KEY (id) REFERENCES Phones(id)
);

INSERT INTO phones(Name, Phone)
VALUES
('Smith', '380684249486'),
('Jones', '380684249643'),
('Taylor', '380684249693'),
('Williams', '380684249743'),
('Brown', '380684249793'),
('White', '380684249843'),
('Harris', '380684249893'),
('Martin', '380684249943'),
('Davies', '380684249993'),
('Wilson', '380684250043'),
('Cooper', '380684250093'),
('Evans', '380684250143'),
('King', '380684250193'),
('Thomas', '380684250243'),
('Baker', '380684250293'),
('Green', '380684250343'),
('Wright', '380684250393'),
('Edwards', '380684250443'),
('Roberts', '380684250493');

INSERT INTO SalaryAndPosition(id, salary, position)
VALUES
(1, 500000, 'главный директор'),
(2, 6000, 'рабочий'),
(3, 7000, 'рабочий'),
(4, 8000, 'рабочий'),
(5, 9000, 'менеджер'),
(6, 10000, 'рабочий'),
(7, 11000, 'рабочий'),
(8, 12000, 'рабочий'),
(9, 13000, 'рабочий'),
(10, 14000, 'менеджер'),
(11, 15000, 'рабочий'),
(12, 16000, 'рабочий'),
(13, 17000, 'рабочий'),
(14, 18000, 'рабочий'),
(15, 19000, 'рабочий'),
(16, 20000, 'менеджер'),
(17, 21000, 'рабочий'),
(18, 22000, 'менеджер'),
(19, 23000, 'рабочий');


INSERT INTO info(id, marital_status, DateOfBirth, PlaceOfLive)
VALUES
(1, 'married', 19920510, 'Kyiv'),
(2, 'notmarried', 19920818, 'Kharkiv'),
(3, 'married', 19921126, 'Odessa'),
(4, 'notmarried', 19930306, 'Dnipro'),
(5, 'notmarried', 19930614, 'Lviv'),
(6, 'married', 19930922, 'Poltava'),
(7, 'married', 19931231, 'Lviv'),
(8, 'notmarried', 19940410, 'Lviv'),
(9, 'married', 19940719, 'Kyiv'),
(10, 'notmarried', 19941027, 'Kharkiv'),
(11, 'married', 19950204, 'Odessa'),
(12, 'notmarried', 19950515, 'Dnipro'),
(13, 'married', 19950823, 'Lviv'),
(14, 'married', 19951201, 'Poltava'),
(15, 'notmarried', 19960310, 'Lviv'),
(16, 'notmarried', 19960618, 'Lviv'),
(17, 'married', 19960926, 'Kyiv'),
(18, 'married', 19970104, 'Kharkiv'),
(19, 'notmarried', 19970414, 'Odessa');