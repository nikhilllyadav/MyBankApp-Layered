
# 🏦 Banking System Console Application

A simple command-line banking application built with **Spring Boot**, demonstrating clean **layered architecture** using **Spring IoC**, **Dependency Injection**, and **Spring Data JPA** for database interactions with **MySQL**.

---

## 🚀 Features

This application allows users to manage bank accounts via a console interface:

* 🔐 **Create Account**: Create a new bank account with an initial balance.
* 💰 **Deposit Funds**: Add funds to an existing account.
* 🏧 **Withdraw Funds**: Withdraw money with balance validation.
* 🔍 **View Account Details**: Retrieve account information by ID.
* 📋 **List All Accounts**: Display all existing bank accounts.
* ❌ **Exit**: Close the application.

---

## ⚙️ Technologies Used

* **Java 11+**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate** (JPA provider)
* **MySQL** (RDBMS)
* **Maven** (Build and dependency management)

---

## 📁 Project Structure

```
banking-app/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/bankingapp/
│       │       ├── config/
│       │       │   └── AppConfig.java
│       │       ├── controller/
│       │       │   └── AccountController.java
│       │       ├── model/
│       │       │   └── Account.java
│       │       ├── repository/
│       │       │   └── AccountRepository.java
│       │       ├── service/
│       │       │   └── AccountService.java
│       │       └── BankingApplication.java
│       └── resources/
│           └── application.properties
└── pom.xml
```

---

## 🛠️ Prerequisites

Ensure the following are installed:

* ✅ Java Development Kit (JDK) 11 or later
* ✅ Apache Maven
* ✅ MySQL Server (running locally)
* ✅ MySQL user: `root` / `root` *(update if different)*

---

## 🧰 Setup Instructions

### 1️⃣ Database Setup (MySQL)

* Make sure your MySQL server is running.
* The application connects to `banking_db` on `localhost:3306`.
* If the database doesn't exist, it will be created automatically.

### 2️⃣ Configuration

Edit `src/main/resources/application.properties` if needed:

```properties
# MySQL DataSource configuration
spring.datasource.url=jdbc:mysql://localhost:3306/banking_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate / JPA settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
```

---

## ▶️ Running the Application

In the project root, run the following command:

```bash
mvn spring-boot:run
```

This will build and launch the console interface.

---

## 🎮 Console Menu

```
--- Banking System Menu ---
1. Create Account
2. Deposit
3. Withdraw
4. View Account
5. List All Accounts
6. Exit
Enter your choice:
```

### ✅ Example Usage

**1. Create an Account**

```
Enter: 1
Name: John Doe
Initial Balance: 1000.00
```

**2. View an Account**

```
Enter: 4
Account ID: 1
```

**3. Deposit Funds**

```
Enter: 2
Account ID: 1
Deposit Amount: 500
```

**4. Withdraw Funds**

```
Enter: 3
Account ID: 1
Withdrawal Amount: 300
```

**5. List All Accounts**

```
Enter: 5
```

**6. Exit Application**

```
Enter: 6
```

---

## 🧪 Verify Database Changes

To verify records in MySQL:

```sql
USE banking_db;
SELECT * FROM account;
```

---

## 📌 Notes

* All operations are handled via service and repository layers using Spring IoC.
* Hibernate handles table creation and schema updates automatically.
* Error handling for negative balances and invalid input is included.

<img width="1918" height="1078" alt="image" src="https://github.com/user-attachments/assets/05e6e5f2-1ff8-42ed-ba88-b58c53253ddd" />
<img width="1918" height="1078" alt="image" src="https://github.com/user-attachments/assets/eb6ba5a7-3e24-43e8-9040-f7e07a103419" />



## 📬 Contribution

If you'd like to contribute to this project (e.g., adding REST APIs, unit tests, Docker support), feel free to fork it and submit a pull request.


