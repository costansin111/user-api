CREATE TABLE IF NOT EXISTS UserId
(
    userId VARCHAR(254) PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS MyData
(
    id VARCHAR(254) PRIMARY KEY ,
    myData  VARCHAR(254),
    userId VARCHAR(254) references userid(userId),
    timeCreate timestamp
);