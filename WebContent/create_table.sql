drop database if exists Relater;

create database Relater;
grant all privileges on Relater.* to 'relater'@'%' identified by 'password';
grant all privileges on Relater.* to 'relater'@'localhost' identified by 'password';

use Relater;

create table Users (
	UserID		integer		primary key auto_increment,
	Username	varchar(16)	unique,
	Nickname	varchar(255),
	Password	varchar(16)
) Type=InnoDB;

create table Friendships (
	HolderID	integer		not null,
	HoldeeID	integer		not null,
	constraint foreign key (HolderID) references Users (UserID),
	constraint foreign key (HoldeeID) references Users (UserID),
	constraint unique index (HolderID, HoldeeID)
) Type=InnoDB;

create table Relations (
	RelationID	integer		primary key auto_increment,
	OwnerID		integer		not null,
	Message		varchar(255)	not null,
	RelateDate	datetime	not null,
	constraint foreign key (OwnerID) references Users (UserID)
) Type=InnoDB;
