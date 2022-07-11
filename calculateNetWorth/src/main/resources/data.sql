drop table if exists stockdetail;
drop table if exists mutualfund;
drop table if exists portfolio;
create table portfolio(portfolio_id int primary key);
create table stockdetail(id int primary key,name varchar(20),units int,portfolio_id int,foreign key(portfolio_id) references portfolio(portfolio_id));
create table mutualfund(id int primary key,name varchar(20),units int,portfolio_id int,foreign key(portfolio_id) references portfolio(portfolio_id));

insert into portfolio values(101);
insert into portfolio values(102);
insert into portfolio values(103);
insert into portfolio values(104);
  
insert into stockdetail values(1,'CTS',10,101);
insert into stockdetail values(2,'DHF',6,102);
insert into stockdetail values(3,'SBI',7,101);
insert into stockdetail values(4,'SBI',8,104);
insert into stockdetail values(5,'CTS',12,103);

insert into mutualfund values(1,'QSF',2,102);
insert into mutualfund values(2,'AMF',3,101);
insert into mutualfund values(3,'CPE',4,101);
insert into mutualfund values(4,'CPE',2,103);
insert into mutualfund values(5,'AMF',5,104);