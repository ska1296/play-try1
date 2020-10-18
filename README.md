# Contact manager
The project implements a simple birthday reminder implemented using Play! 1.2.4 framework and Java 7 for:
  - Add a contact
  - Get a reminder X hours before contac's birthday over email



The project was built and run in Windows environment in Netbeans. The testing was done using Google Chrome. The poject is a java project that uses Microsoft SQL as database, Play! framework and hibernate. The application launches on port 9000.

## Prerequisites
- Windows Environment
- MSSQL Server 2014
- A web browser

## Setup
- clone the project
- create a database called 'Clone' and add tables using commands in the file setup\createTables.txt. The expected port, username, database name and password are available in application.conf file.
- navigate to application.conf under the project and update the fields (if needed):
  - user
  - password
  - database name in url
  - port in url
  - jpa dialect
  
## Build and Start
- Import the project in Netbeans and click on 'Start' to launch the application. The console should print something similar to:
```
Listening for transport dt_socket at address: 8000
21:55:12,753 INFO  ~ Starting ...\myApp
21:55:13,316 WARN  ~ You're running Play! in DEV mode
21:55:13,405 INFO  ~ Listening for HTTP on port 9000 (Waiting a first request to start) ...

```

## Test
- Sign in into the application using.
  - GET. URL: http://localhost:9000/login
  - Enter username and password
 
- Add a contact
  - GET. URL is generated after login.
  - The default value of hours is 1. Update it to a desired value
  - Enter name of person
  - Enter birthday
  - Click 'Add'
  
Every 31 mins, a scheduled job checks for users whose birthdays are X hours away from current time and if a match is found, an email is sent to all users who have this contact in their contact list.

## Schema:
- USERS:
```
+-------------+--------------+------------------+
| Column Name |  Data Type   |   Description    |
+-------------+--------------+------------------+
| userid      | varchar(MAX) | email of user    |
| password    | varchar(MAX) | password of user |
+-------------+--------------+------------------+
```
- BIRTHDAY
```
+-------------+--------------+--------------------+
| Column Name |  Data Type   |    Description     |
+-------------+--------------+--------------------+
| birthday    | datetime     | birthday of person |
| userid      | varchar(255) | name of person     |
+-------------+--------------+--------------------+
```
- REMINDER
```
+-------------+--------------+------------------------------------------------------+
| Column Name |  Data Type   |                     Description                      |
+-------------+--------------+------------------------------------------------------+
| duration    | int          | Hours before which reminder should be sent           |
| userid      | varchar(255) | email of the user to whom the reminder is to be sent |
+-------------+--------------+------------------------------------------------------+
```
- CONTACTS
```
+-------------+--------------+-------------------------------------+
| Column Name |  Data Type   |             Description             |
+-------------+--------------+-------------------------------------+
| contactname | varchar(255) | name of contact                     |
| username    | varchar(255) | email of person who's contact it is |
+-------------+--------------+-------------------------------------+
```
