# 🏥 Hospital Management System

A full-stack **Hospital Management System** developed using **Java, Spring Boot, PostgreSQL, Thymeleaf, Bootstrap, HTML, CSS, and JavaScript**. This application helps hospitals manage patients, doctors, appointments, billing, and reports through an easy-to-use web interface.

---

## 🚀 Features

### 🔐 Authentication
- Secure Admin Login
- Session-based Authentication
- Logout Functionality

### 📊 Dashboard
- Total Patients
- Total Doctors
- Total Appointments
- Total Revenue
- Interactive Charts (Bar & Pie Chart)

### 👨‍⚕️ Doctor Management
- Add Doctor
- View Doctor List
- Update Doctor Details
- Delete Doctor
- Search Doctors

### 🧑‍🤝‍🧑 Patient Management
- Add Patient
- View Patient List
- Update Patient Details
- Delete Patient
- Search Patients

### 📅 Appointment Management
- Schedule Appointment
- View Appointment List
- Edit Appointment
- Delete Appointment
- Appointment Status

### 💰 Billing Management
- Generate Bills
- Payment Status
- Billing Records
- Revenue Calculation

### 📈 Reports
- Hospital Summary
- Total Patients
- Total Doctors
- Total Appointments
- Total Revenue

---

# 🛠️ Tech Stack

## Backend
- Java
- Spring Boot
- JDBC
- PostgreSQL

## Frontend
- HTML5
- CSS3
- Bootstrap 5
- JavaScript
- Thymeleaf

## Database
- PostgreSQL

## Tools
- Git
- GitHub
- VS Code
- Maven

---

# 📂 Project Structure

```
Hospital-Management-System
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.hospital.management
│   │   │       ├── controller
│   │   │       ├── dao
│   │   │       ├── database
│   │   │       ├── model
│   │   │       ├── service
│   │   │       └── ManagementApplication.java
│   │   │
│   │   ├── resources
│   │   │       ├── static
│   │   │       ├── templates
│   │   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
├── mvnw
└── README.md
```

---

# ⚙️ Installation

## Clone Repository

```bash
git clone https://github.com/ammartech-hub/Hospital-Management-System.git
```

## Open Project

```bash
cd Hospital-Management-System
```

## Configure PostgreSQL

Update `application.properties`

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

## Run Project

```bash
mvn spring-boot:run
```

Open

```
http://localhost:8080
```

---

# 🎯 Future Improvements

- Email Notifications
- SMS Notifications
- PDF Bill Generation
- Medical Records
- Doctor Availability
- Online Appointment Booking
- Role-Based Authentication
- Responsive Mobile UI

---

# 👨‍💻 Author

## Ammar Khan

Information Technology Student

GitHub:
https://github.com/ammartech-hub

---

# ⭐ If you like this project

Please consider giving this repository a **Star ⭐**.
