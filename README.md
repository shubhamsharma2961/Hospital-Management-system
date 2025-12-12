🏥 Hospital Management System
A full-stack Hospital Management System (HMS) built using Spring Boot, React, and MySQL, designed to simplify hospital workflows like patient management, appointments, doctor schedules, and administrative tasks.
This project follows a clean MVC architecture on the backend, RESTful API design principles, and a modern frontend UI built using React.
________________________________________
📌 Table of Contents
•	Overview
•	Features
•	Tech Stack
•	Architecture
•	Database Schema
•	API Endpoints
•	Installation (Backend)
•	Installation (Frontend)
•	Future Enhancements
•	License
________________________________________
🔍 Overview
The Hospital Management System is a full-stack web application that enables hospitals to efficiently manage:
•	Patient records
•	Doctor information
•	Appointments
•	Admin operations
•	Real-time data interactions through REST API
It is built with industry-standard tools like Spring Boot, React, MySQL, JPA, and Lombok, providing a scalable, maintainable, and production-ready architecture.
________________________________________
✨ Features
👨‍⚕️ Doctor Management
•	Add / update / delete doctors
•	Manage specialties
•	Associate with appointments
🧑‍🦽 Patient Management
•	Register new patients
•	Update personal & medical details
•	View all patient profiles
📅 Appointment Management
•	Book appointments
•	Link doctor + patient
•	Cancel or reschedule
•	View appointment list with status
🔐 Authentication (If implemented)
•	Admin login
•	Role-based access (Admin, Staff)
🎨 Modern UI (React Frontend)
•	Responsive design
•	Smooth UI interactions
•	Separate pages for doctors, patients, appointments
________________________________________
🛠 Tech Stack
Backend
•	Java 21
•	Spring Boot
•	Spring MVC
•	Spring Data JPA
•	REST API
•	Lombok
•	Gradle
Frontend
•	React.js
•	React Router
Database
•	MySQL
________________________________________
🏗 Architecture
Backend Architecture (Spring Boot MVC)
Controller  →  Service  →  Repository  →  MySQL
Frontend Architecture (React)
Components → Pages → Services (Axios) → REST API
REST Communication
React → Axios → Spring Boot API → MySQL
________________________________________
🗂 Database Schema
Patient Table
•	id
•	name
•	gender
•	age
•	address
•	contact
•	medical_history
Doctor Table
•	id
•	name
•	specialization
•	experience
•	phone
Appointment Table
•	id
•	patient_id
•	doctor_id
•	date
•	time
•	status
________________________________________
🔗 API Endpoints
Patients
GET    /api/patients
POST   /api/patients
GET    /api/patients/{id}
PUT    /api/patients/{id}
DELETE /api/patients/{id}
Doctors
GET    /api/doctors
POST   /api/doctors
PUT    /api/doctors/{id}
DELETE /api/doctors/{id}
Appointments
GET    /api/appointments
POST   /api/appointments
PUT    /api/appointments/{id}
DELETE /api/appointments/{id}
________________________________________
🚀 Installation (Backend)
1. Clone the repository
git clone https://github.com/shubhamsharma2961/Hospital-Management-system.git
2. Open in Spring Tool Suite (STS) or IntelliJ
3. Configure MySQL
Create a database:
CREATE DATABASE hospital_management;
Update application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_management
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
4. Build & Run
./gradlew bootRun
or using IDE:
▶ Run → HospitalManagementApplication.java
Backend will run at:
http://localhost:8080/
________________________________________
💻 Installation (Frontend)
1. Go to frontend folder
cd frontend
2. Install dependencies
npm install
3. Start frontend
npm start
Frontend runs at:
http://localhost:3000/
________________________________________
🚀 Future Enhancements
•	JWT Authentication
•	Doctor availability calendar
•	Email / SMS appointment notifications
•	Pharmacy & Billing module
•	Analytics dashboard
•	Role-based access for staff
________________________________________
📜 License
MIT License – Free to use and modify.

