 
 
 DROP DATABASE IF EXISTS HotelReservation;

 CREATE DATABASE HotelReservation;

# USE HotelReservation;

CREATE TABLE HotelReservation.RoomType
(
	RoomTypeID int auto_increment NOT NULL,
    Description varchar(40),
    PRIMARY KEY(RoomTypeID)
);


CREATE TABLE HotelReservation.Rooms
(
	RoomID int auto_increment NOT NULL,
	RoomTypeID int NOT NULL,
    RoomNumber int NOT NULL,
    OccupancyLimit int ,
    RoomAmenities varchar(30),
    Description varchar(40),
	PRIMARY KEY(RoomID)
   -- FOREIGN KEY(RoomTypeID) REFERENCES RoomType(RoomTypeID)
);

# ADDING MY OWN CONSTRAINTS #

alter table HotelReservation.Rooms
add constraint Room_RoomType_FK FOREIGN KEY ( RoomTypeID ) references RoomType(RoomTypeID);

CREATE TABLE HotelReservation.RoomRate
(
	RoomRateID int auto_increment NOT NULL,
    RoomTypeID int NOT NULL,
    StartDate date,
    EndDate date,
    Price double,
    PRIMARY KEY(RoomRateID)
   -- FOREIGN KEY (RoomTypeID) REFERENCES RoomType(RoomTypeID)
);

alter table HotelReservation.RoomRate
add constraint RoomRate_RoomTypeID_FK FOREIGN KEY ( RoomTypeID ) references RoomType(RoomTypeID);

CREATE TABLE HotelReservation.RoomReservation
(
	RoomReservationID int auto_increment NOT NULL,
    RoomID int NOT NULL,
    ReservationID int NOT NULL,
    CheckIn date,
    CheckOut date,
	PRIMARY KEY (RoomReservationID)
  --  FOREIGN KEY (RoomID) REFERENCES Rooms(RoomID),
  --  FOREIGN KEY (ReservationID) REFERENCES Reservation(ReservationID)
);



CREATE TABLE HotelReservation.Customers 
(
	CustomersID int NOT NULL auto_increment,
    ReservationID int NOT NULL,
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    Age int NOT NULL,
    PhoneNumber VARCHAR(10) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Address VARCHAR(120) NOT NULL,
    PRIMARY KEY (CustomersID)
  --  FOREIGN KEY (ReservationID) REFERENCES Reservation(ReservationID)
);


CREATE TABLE HotelReservation.Reservation
(
	ReservationID int auto_increment NOT NULL,
    CustomersID int NOT NULL,
    RoomReservationID int NOT NULL,
    PromotionalCodesID int NOT NULL,
    ReservationDate date,
    PRIMARY KEY(ReservationID)
 --   FOREIGN KEY (CustomersID) REFERENCES Customers(CustomersID),
 --   FOREIGN KEY (RoomReservationID) REFERENCES RoomReservation(RoomReservationID),
 --   FOREIGN KEY (PromotionalCodesID) REFERENCES PromotionalCodes(PromotionalCodesID)
);


# ALERTING TABLE AFTER THE CREATION OF RESERVATION AND ADDING CUSTOM CONSTRAINTS
alter table HotelReservation.Customers 
add constraint Customers_ReservationID_FK FOREIGN KEY ( ReservationID ) references Reservation(ReservationID);

# NEED TO ALTER TABLE AFTER RESERVATION TABLE GETS CREATED
alter table HotelReservation.RoomReservation
add constraint RoomReservation_RoomID_FK FOREIGN KEY ( RoomID ) references Rooms(RoomID),
add constraint RoomReservation_ReservationID_FK FOREIGN KEY ( ReservationID ) references Reservation(ReservationID);



CREATE TABLE HotelReservation.PromotionalCodes
(
	PromotionalCodesID int NOT NULL auto_increment,
    ReservationID int NOT NULL,
    PromotionalCode int NOT NULL,
    StartDate date,
    EndDate date,
    DiscountType VARCHAR(40),
    PRIMARY KEY (promotionalCodesID)
 --   FOREIGN KEY (ReservationID) REFERENCES Reservation(ReservationID)
);

# PromotionalCodes Constraints
alter table HotelReservation.PromotionalCodes
add constraint PromotionalCodes_ReservationID_FK FOREIGN KEY ( ReservationID ) references Reservation(ReservationID);


# Reservation table adding constraints
alter table HotelReservation.Reservation
add constraint Reservation_CustomersID_FK FOREIGN KEY ( CustomersID ) references Customers(CustomersID),
add constraint Reservation_RoomReservationID_FK FOREIGN KEY ( RoomReservationID ) references RoomReservation(RoomReservationID),
add constraint Reservation_PromotionalCodesID_FK FOREIGN KEY ( PromotionalCodesID ) references PromotionalCodes(PromotionalCodesID);



CREATE TABLE HotelReservation.Billing
(
	BillingID int NOT NULL auto_increment,
    CustomersID int NOT NULL,
    Tax double,
    Total double,
    PRIMARY KEY (BillingID)
 --  FOREIGN KEY (CustomersID) REFERENCES Customers(CustomersID)
);

# Adding my own constraints to billing #
alter table HotelReservation.Billing
add constraint Reservation_CustomerID_FK FOREIGN KEY (CustomersID) references Customers(CustomersID);

CREATE TABLE HotelReservation.AddOns
(
	AddOnsID int NOT NULL auto_increment,
	NameOfAddOn VARCHAR(100),
    Description VARCHAR(200),
    Price double,
    PRIMARY KEY (AddOnsID)
);

CREATE TABLE HotelReservation.RoomService
(
	RoomServiceID int NOT NULL auto_increment,
    Description VARCHAR(200),
    Price double,
    PRIMARY KEY (RoomServiceID)
);

CREATE TABLE HotelReservation.Billing_Details
(
	Billing_Details int auto_increment NOT NULL,
    BillingID int NOT NULL,
    AddOnsID int NOT NULL,
    RoomServiceID int NOT NULL,
    ReservationID int NOT NULL,
    EtcOrComments VARCHAR(200),
    PRIMARY KEY (Billing_Details)
 --   FOREIGN KEY (BillingID) REFERENCES Billing(BillingID),
 --   FOREIGN KEY (AddOnsID) REFERENCES AddOns(AddOnsID),
 --   FOREIGN KEY (RoomServiceID) REFERENCES RoomService(RoomServiceID),
  --  FOREIGN KEY (ReservationID) REFERENCES Reservation(ReservationID)
);

alter table HotelReservation.Billing_Details
add constraint Billing_Details_BillingID_FK FOREIGN KEY (BillingID) references Billing(BillingID),
add constraint Billing_Details_AddOnsID_FK FOREIGN KEY (AddOnsID) REFERENCES AddOns(AddOnsID),
add constraint Billing_Details_RoomServiceID_FK FOREIGN KEY (RoomServiceID) REFERENCES RoomService(RoomServiceID),
add constraint Billing_Details_ReservationID_FK FOREIGN KEY (ReservationID) REFERENCES Reservation(ReservationID);