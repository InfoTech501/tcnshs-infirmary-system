drop user sys cascade;

create user sys identified by elijah;

alter user sys quota unlimited on DATA;

alter user sys quota unlimited on USERS;

grant create session to sys with admin option;

grant connect to sys;

alter session set current_schema = sys;

create table item (
	StudentName 	            varchar2(8) primary key,
	Symptoms		            varchar2(128),
	Remarks			            varchar2(16),
	Temperature		            number(3,0),
	Date                        number(31,0),
	TimeVisit                   number(24,0),
	MedicationAdministered      number(5,0)
)