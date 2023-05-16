insert into PERSON (name, gender, age, documetId, address, phoneNumber) values ('Hugues Rosengart', 'Male', 4, '418-93-7094', '943 Tomscot Parkway', '964-526-2546');
insert into PERSON (name, gender, age, documetId, address, phoneNumber) values ('Emmett Beagley', 'Male', 41, '857-98-1003', '5647 Montana Place', '448-548-2235');
insert into PERSON (name, gender, age, documetId, address, phoneNumber) values ('Cymbre Whitcher', 'Female', 29, '839-98-6824', '62 3rd Drive', '395-351-7890');
insert into PERSON (name, gender, age, documetId, address, phoneNumber) values ('Janina Shallcrass', 'Female', 23, '506-38-6709', '31702 East Point', '520-443-3599');
insert into PERSON (name, gender, age, documetId, address, phoneNumber) values ('Bartel Wasbey', 'Male', 23, '195-62-5839', '4 Schurz Road', '184-522-8926');

insert into CLIENT (password, state, name, documentId) values ('JSDni7Ja', 'True', 'Emmeline Inkpin', '661-43-7516');
insert into CLIENT (password, state, name, documentId) values ('dgf1qqKfYxsO', 'True', 'Fin Schild', '516-29-6508');
insert into CLIENT (password, state, name, documentId) values ('wIwbev', 'True', 'Dorrie Fouldes', '468-91-8587');
insert into CLIENT (password, state, name, documentId) values ('3ooLoFGwxp9D', 'True', 'Ebeneser Bonwick', '747-84-5871');
insert into CLIENT (password, state, name, documentId) values ('T3iSPL6', 'False', 'Massimo Piet', '623-64-0433');

insert into ACCOUNT (accountNumber, accountType, initialBalance, state, ID_CLIENT) values ('eUeqF', 'Current', 12627, 'True', '805-91-0590');
insert into ACCOUNT (accountNumber, accountType, initialBalance, state, ID_CLIENT) values ('EEH6O', 'Savings', 68361, 'True', '149-30-8446');
insert into ACCOUNT (accountNumber, accountType, initialBalance, state, ID_CLIENT) values ('zjS5r', 'Savings', 28067, 'True', '322-70-8391');
insert into ACCOUNT (accountNumber, accountType, initialBalance, state, ID_CLIENT) values ('8uDew', 'Savings', 78861, 'True', '486-15-3492');
insert into ACCOUNT (accountNumber, accountType, initialBalance, state, ID_CLIENT) values ('uRGDs', 'Savings', 97822, 'True', '121-74-8503');

insert into TRANSACTION (date, transactionType, transactionValue, transactionBalance, ACCOUNT_ID) values ('2022-11-15 00:09:15', 'WITHDRAWAL', 99929, 53029, 1);
insert into TRANSACTION (date, transactionType, transactionValue, transactionBalance, ACCOUNT_ID) values ('2023-01-06 23:07:38', 'WITHDRAWAL', 12436, 50201, 2);
insert into TRANSACTION (date, transactionType, transactionValue, transactionBalance, ACCOUNT_ID) values ('2022-11-13 12:19:29', 'DEBIT', 62120, 96881, 3);
insert into TRANSACTION (date, transactionType, transactionValue, transactionBalance, ACCOUNT_ID) values ('2022-08-11 06:08:15', 'DEBIT', 98110, 56034, 4);
insert into TRANSACTION (date, transactionType, transactionValue, transactionBalance, ACCOUNT_ID) values ('2022-09-26 03:33:49', 'DEBIT', 57765, 76147, 5);