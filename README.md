# Banking Management System

**<h2>Overview</h2>**
- A group project for the SE2 course in the Faculty of Information Technology at Hanoi University
- A Full-stack Application with Spring Boot backend and JSP frontend for the Banking Management System
- Files & further documentation can be found at: https://drive.google.com/drive/folders/1Rx7xCJ4xwz3w54tDEPWPrwJ5I1UGmG0k

**<h2>Features</h2>**
**<h3>1) Architectural Feature</h3>**
- Session-based Authentication
- CRUD with DTO and constraint validations on all domains
- Role-based Authorization: 2 roles: Admin, Customer
- Database Password Hashing with BCrypt
- Including **12** domains:
    - `User`
    - `Customer`
    - `CustomerAccount`
    - `NormalAccount`
    - `SavingAccount`
    - `LoanAccount`
    - `Transaction`
    - `ChargeTransaction`
    - `TransferTransaction`
    - `WithdrawTransaction`
    - `FakeEWallet`

**<h3>2) Software Feature</h3>**

**<h4>Global Access Feature</h4>**
- Beautiful Landing Page
- Login, Logout

**<h4>Admin Role Feature</h4>**
- View Dashboard
- Customers Management
- Customer Accounts Management
- Transactions Management
- Change User password

**<h4>Customer Role Feature</h4>**
- View Dashboard
- View own profile
- View own Accounts (3 types)
- View own Transactions (3 types)
- Create a new transaction:
  - Create charge transaction
  - Create transfer transaction
  - Create withdraw transaction
- Manage E-wallets
- Change own password

**<h2>Usage</h2>**
- **Requires** JAVA 11 SDK and MySQL 8 (version 8.0.23) to be installed
- Create a database named `bankingsystem` and then either:
    - Go to `src/main/resources/application-dev.properties` and change the following to:
        - `spring.datasource.username=YOUR_DB_USERNAME`
        - `spring.datasource.password=YOUR_DB_PASSWORD`
        - `spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/bankingsystem`
    - Or create a new mysql db account named `se2-dev` with password `se2@2021`
      https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql
- In the project root folder, run in terminal: `mvn springboot:run`
- If you do not want any data to be initialized in your database, go to `src/main/java/com/se2/bankingsystem/InitData.java` and comment out the line (around line 134) containing `testData();` before running it for the first time.
- To reset the database, `drop database bankingsystem;` and `create database bankingsystem;`, `InitData` will be run again.

**<h2>Demo Accounts</h2>**
- Admin: 
    - Username: admin
    - Password: se2@2021
      **<br><br>**
- Customers:
    - Username: tangbaminh
    - Password: 1801040147
      **<br><br>**
    - Username: nguyenthuyduong
    - Password: 1801040052
      **<br><br>**
    - Username: duonghoangnam
    - Password: 1801040153
      **<br><br>**
    - Username: anthiphuong
    - Password: 1801040169
      **<br><br>**
    - Username: tranthingocanh
    - Password: 1801040017
    
Cheers
