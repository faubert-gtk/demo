DROP TABLE IF EXISTS Banks;
CREATE TABLE Banks (
  id UUID PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  bik VARCHAR(255) NOT NULL,
);
INSERT INTO Banks (Id, name, bik) VALUES
(RANDOM_UUID(), 'Sberbank', '000000001'),
(RANDOM_UUID(), 'VTB24', '000000002'),
(RANDOM_UUID(), 'Tinkoff', '000000003');
DROP TABLE IF EXISTS Clients;
CREATE TABLE Clients (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    shortName VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    organizationForm VARCHAR(255) NOT NULL,
);
INSERT INTO Clients (id, name, shortName, address, organizationForm) VALUES
(RANDOM_UUID(), 'Jones Stock Company', 'Jones Stock','Born','CJSC'),
(RANDOM_UUID(), 'Woodstock Company','Woodstock','Moscow','LLC'),
(RANDOM_UUID(), 'Bladberry Fund', 'Bladberry','Philippines','Fund');
DROP TABLE IF EXISTS Deposits;
CREATE TABLE Deposits (
    id UUID PRIMARY KEY,
    client_id UUID NOT NULL,
    foreign key (client_id) REFERENCES Clients(id),
    bank_id UUID NOT NULL,
    foreign key (bank_id) REFERENCES Banks(id),
    dateCreated TIMESTAMP NOT NULL default CURRENT_TIMESTAMP(),
    percent DOUBLE NOT NULL,
    term INT NOT NULL,
);
INSERT INTO Deposits (id, client_id, bank_id, dateCreated, percent, term) VALUES
(RANDOM_UUID(), SELECT id from Clients where name = 'Jones Stock Company', SELECT id from Banks where name = 'Sberbank',CURRENT_TIMESTAMP(),12.0, 24),
(RANDOM_UUID(), SELECT id from Clients where name ='Woodstock Company', SELECT id from Banks where name = 'VTB24',CURRENT_TIMESTAMP(), 7.4, 12),
(RANDOM_UUID(), SELECT id from Clients where name = 'Bladberry Fund', SELECT id from Banks where name = 'Tinkoff',CURRENT_TIMESTAMP(), 4.4, 6);