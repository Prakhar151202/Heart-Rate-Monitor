# Heart Rate Monitor API

## **About the Project**

This project provides a simple implementation of APIs to manage **Users** (medical staff) and **Patients**. The application focuses on basic operations such as user registration, login, and patient management, while intentionally avoiding complex authentication and authorization protocols for simplicity. The primary objective is to enable medical staff to manage patient data and heart rate information.

### **Key Highlights**
- **Entities**:
  The project includes two main entities:
  1. **Users**: Represents medical staff such as doctors, nurses, consultants, etc.
  2. **Patients**: Represents patients whose data, including heart rate, is managed by the APIs.

- **Workflow**:
  - A user must first register with the system by providing the required fields.
  - After successful registration, the user logs in using their credentials.
  - Once logged in, users can perform operations such as:
    - Adding new patients.
    - Retrieving all patients.
    - Fetching the heart rate of a specific patient.
    - Updating a patient's heart rate.

- **Database**:
  The project uses an **H2 in-memory database** to avoid the need for external database installation, making it lightweight and easy to use during development.

  <p align="center">
  <img width="993" alt="Screenshot 2025-01-10 at 4 31 41 PM" src="https://github.com/user-attachments/assets/373fa612-895f-480e-9843-766aa8bb6629" />
</p>

<p align="center">
  <img width="993" alt="Screenshot 2025-01-10 at 4 32 30 PM" src="https://github.com/user-attachments/assets/eb230561-a025-43c2-8629-ceed469ff970" />
</p>

## **APIs Included in the Project**

The following API endpoints are implemented in the project:

### **1. Register a New User**
This API allows users (e.g., doctors, nurses, etc.) to register themselves for the first time by providing their details, email and password.
- **Endpoint**: `POST /api/user/registerUser`
- **Request Body**:
  ```json
  {
    "name": "Ayesha Sharma",
    "age": "32",
    "staff": "Doctor",
    "department": "Neurology",
    "email": "ayesha.sharma@example.com",
    "password": "securepass321"
  }
  
<p align="center"> <img width="993" alt="Register User" src="https://github.com/user-attachments/assets/eafe0b87-6047-45f8-bbd8-9224ba4eebd3" /> </p>

### **2. Login a User**
This API allows users (e.g., doctors, nurses, etc.) to login themselves for the first time by providing their email and password.
- **Endpoint**: `POST /api/user/login`
- **Request Body**:
  ```json
  
  {
    "email": "ayesha.sharma@example.com",
    "password": "securepass321"
  }
<p align="center"> <img width="993" alt="Login User" src="https://github.com/user-attachments/assets/693ff963-8dfc-4645-83dd-c0dffe5d5d58" /> </p>

### **3. Add a new Patient**
This API allows users (e.g., doctors, nurses, etc.) to add the patient to the database after recording all the information in the fields.
- **Endpoint**: `POST /api/patient/addPatient`
- **Request Body**:
  ```json
  
  {
        "patientName": "Emily Davis",
        "age": "26",
        "gender": "Female",
        "contact": "9876543213",
        "heartRate": 75
  }
<p align="center"> <img width="993" alt="Add New Patient" src="https://github.com/user-attachments/assets/29654230-5d75-4f1d-b74c-8a6b0404d867" /> </p>

### **4. Find all the Patient in record**
This API allows users (e.g., doctors, nurses, etc.) to find all the patients.
- **Endpoint**: `GET /api/patient/allPatient`
- **Request Body**:
  ```json

<p align="center"> <img width="993" alt="Retrieve All Patients" src="https://github.com/user-attachments/assets/8e26db3b-96a7-4356-9949-8b006666de43" /> </p>

### **5. Find Heartrate of a Patient using PatientId**
This API allows users (e.g., doctors, nurses, etc.) to find heartrate of their patient.
- **Endpoint**: `GET /api/patient/heartrate/{patiendId}`
- **Request Body**:
  ```json

<p align="center"> <img width="993" alt="Retrieve Heart Rate" src="https://github.com/user-attachments/assets/57ddce62-27e2-436d-9f4b-9e73e281fa35" /> </p>

### **6. Record new heartrate of a Patient**
This API allows users (e.g., doctors, nurses, etc.) to record new heartrate of their patient.
- **Endpoint**: `PUT /api/patient/heartrate/{patientId}`
- **Request Body**:
  ```json

  {
    "patientId": 2,
    "patientName": "Daniel Lee",
    "heartRate": new-heart-rate
  }
<p align="center"><img width="993" alt="Screenshot 2025-01-10 at 3 58 27 PM" src="https://github.com/user-attachments/assets/829ea2e3-8048-41e4-82de-639b085beab5" /></p>


APIs included in project :

1. Register User For The First Time
   <img width="993" alt="Register User" src="https://github.com/user-attachments/assets/eafe0b87-6047-45f8-bbd8-9224ba4eebd3" />


2. Login User and test for validation

   <img width="1001" alt="Screenshot 2025-01-10 at 3 49 32 PM" src="https://github.com/user-attachments/assets/693ff963-8dfc-4645-83dd-c0dffe5d5d58" />

3. Add new Patient to the database

  <img width="1008" alt="Screenshot 2025-01-10 at 3 50 18 PM" src="https://github.com/user-attachments/assets/29654230-5d75-4f1d-b74c-8a6b0404d867" />
   
4. Find all the Patients that has been added

   <img width="1007" alt="Screenshot 2025-01-10 at 3 54 19 PM" src="https://github.com/user-attachments/assets/8e26db3b-96a7-4356-9949-8b006666de43" />

5. Find the Heartrate of the patient using patientId

   <img width="993" alt="Screenshot 2025-01-10 at 3 56 00 PM" src="https://github.com/user-attachments/assets/57ddce62-27e2-436d-9f4b-9e73e281fa35" />

6. Record the new heartrate of a patient

   <img width="1008" alt="Screenshot 2025-01-10 at 3 58 27 PM" src="https://github.com/user-attachments/assets/829ea2e3-8048-41e4-82de-639b085beab5" />
   

