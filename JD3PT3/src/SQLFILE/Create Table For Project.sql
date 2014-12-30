
drop database if exist JD3PT3;

create database JD3PT3;

use JD3PT3;

create table InitData (
   id INT NOT NULL auto_increment,

	location text,
	prSrNo text,
	srNo int,
	registrationNumber text,

	rawField1 text,
	rawField2 text,
	rawField3 text,
	rawField4 text,
	rawField5 text,
	rawField6 int,
	rawField7 int,
	rawField8 int,
	rawField9 int,
	rawField10 int,
   PRIMARY KEY (id)
);


create table Login (
   id INT NOT NULL auto_increment,

        userName text,
	userId text,
	userPassword text,
	userPriority int,
	userEmail text,
	userMob text,
	userLastAccountAccess date,
        userAddress text,
      
   userDateOfAddition date,
   userTimeOfAddition time,
   userLocation text,
   userAddedByPersonName text,
   userAddedWithRight text,    
   rawField1 text,
   rawField2 text,
   rawField3 text,
   rawField4 text,
   rawField5 text,
   rawField6 text,
   
   PRIMARY KEY (id)
);



create table CurrentDisellog(
   id INT NOT NULL auto_increment,

	openingQuantity double,
	currentQuantity double,
	currentDateOfStatus date,
   Location text,
   rawField1 text,
   rawField2 text,
   rawField3 text,
   rawField4 text,
   rawField5 text,
   rawField6 text,


   PRIMARY KEY (id)
);

INSERT INTO Currentdisellog (openingQuantity,currentQuantity,currentDateOfStatus,Location,rawField1,rawField2,rawField3,rawField4,rawField5,rawField6)
VALUES (0.0, 0.0, '2014-10-10','Nagpur','NO','NO','NO','NO','NO','NO');

INSERT INTO Login (userName,userId,userPassword,userPriority,userEmail,userMob,userLastAccountAccess,userAddress,userDateOfAddition,userTimeOfAddition,userLocation,userAddedByPersonName,userAddedWithRight,rawField1,rawField2,rawField3,rawField4,rawField5,rawField6)
VALUES ( 'Administrator Name Goes Here','Administrator','Administrator','1','Administrator Email Goes Here','8550900381',null,'Administrator Address Goes Here',null,null,'Nagpur','Developer Yogesh Paisode','Administrator','NO','No','No','No','No','No');

INSERT INTO Login (userName,userId,userPassword,userPriority,userEmail,userMob,userLastAccountAccess,userAddress,userDateOfAddition,userTimeOfAddition,userLocation,userAddedByPersonName,userAddedWithRight,rawField1,rawField2,rawField3,rawField4,rawField5,rawField6)
VALUES ( 'Supervisor Name Goes Here','Supervisor','Supervisor','2','Supervisor Email Goes Here','8550900381',null,'Supervisor Address Goes Here',null,null,'Nagpur','Developer Yogesh Paisode','Administrator','NO','No','No','No','No','No');

INSERT INTO Login (userName,userId,userPassword,userPriority,userEmail,userMob,userLastAccountAccess,userAddress,userDateOfAddition,userTimeOfAddition,userLocation,userAddedByPersonName,userAddedWithRight,rawField1,rawField2,rawField3,rawField4,rawField5,rawField6)
VALUES ( 'Operator Name Goes Here','Operator','Operator','3','Operator Email Goes Here','8550900381',null,'Operator Adress Goes Here',null,null,'Nagpur','Developer Yogesh Paisode','Administrator','NO','No','No','No','No','No');


INSERT INTO InitData (location,prSrNo,srNo,registrationNumber,rawField1,rawField2,rawField3,rawField4,rawField5,rawField6,rawField7,rawField8,rawField9,rawField10)
VALUES ('Nagpur', 'NA',6000,'DMV76355K','NO','NO','NO','NO','NO',0,0,0,0,0);




create table PartyMaster (
   id INT NOT NULL auto_increment,
   
   partyName text,
   partyAddress text,
   partyCity text,
   partyPhone text,
   partyMobile text,
   partyEmail text,
   
   partyDateOfAddition date,
   partyTimeOfAddition time,
   partyLocation text,
   partyAddedByPersonName text,
   partyAddedWithRight text,    
   rawField1 text,
   rawField2 text,
   rawField3 text,
   rawField4 text,
   rawField5 text,
   rawField6 text,
   
   PRIMARY KEY (id)
);

create table ProductMaster (
   id INT NOT NULL auto_increment,
   
   productName text,
   productSize int,
   productMeasurement text,
	
   productDateOfAddition date,
   productTimeOfAddition time,
   productLocation text,
   productAddedByPersonName text,
   productAddedWithRight text,    
   rawField1 text,
   rawField2 text,
   rawField3 text,
   rawField4 text,
   rawField5 text,
   rawField6 text,
	
    PRIMARY KEY (id)
);

create table MachineMaster (
   id INT NOT NULL auto_increment,

   machinePartyLink text,
   machineIdentification text,
   machineType text,
   machineName text,
   machineNumber text,
   machineServicingLogIn text,
   machineServicingLog int,
   machineExpectedAVG double,

   machineStatus text,
   machineCurrentReading int,
   machineFuel double,
   
   machineDateOfAddition date,
   machineTimeOfAddition time,
   machineLocation text,
   machineAddedByPersonName text,
   machineAddedWithRight text,    
   rawField1 text,
   rawField2 text,
   rawField3 text,
   rawField4 text,
   rawField5 text,
   rawField6 text,  
   	
    PRIMARY KEY (id)
);

create table DriverMaster (
   id INT NOT NULL auto_increment,

   driverPartyLink text,
   driverName text,
   driverAddress text,
   driverMobile text,
   driverBloodGroup text,
   driverDateOfJoining date,
   driverPic text,
   
   driverDateOfAddition date,
   driverTimeOfAddition time,
   driverLocation text,
   driverAddedByPersonName text,
   driverAddedWithRight text,    
   rawField1 text,
   rawField2 text,
   rawField3 text,
   rawField4 text,
   rawField5 text,
   rawField6 text,
     
    PRIMARY KEY (id)
);