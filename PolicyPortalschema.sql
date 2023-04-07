create database PolicyPortal;
use PolicyPortal;

 create table admin (aid varchar(225) not null primary key,password varchar(14),username varchar(25) );
 
 create table user(user_name varchar(25) primary key, password varchar(14),email varchar(50),mobile bigint,userid int not null);
 
 create table  approved (user_name varchar(25) primary key , date datetime(6) ,policy_id int ,request_id int ,status varchar(50));
 
 create  table policies (policy_id int primary key , amount double ,category varchar(100),policy_name varchar(200), tenure_in_years int);
 
 create table queries (userName varchar(25) primary key, answer varchar(300), query_id int , question varchar(500));
 
 create table approvals(user_name varchar(25), date datetime(6),policy_id int ,request_id int , status varchar(255),approvals_user_name varchar(25) );
 
 create table disapproved (user_name varchar(25), date datetime(6),policy_id int,request_id int,status varchar(25));
 
 select * from admin;
 select * from user;
 delete from admin where username='Sammy';