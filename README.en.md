# Smart Hospital Registration System Backend

This is a backend project for a smart hospital registration system based on Spring Boot, providing complete management of the hospital registration process, department and doctor information management, user login and registration, and AI-powered intelligent hospital guidance.

## Key Features

- **Smart Guidance**: Integrated AI chatbot to provide intelligent consultation advice  
- **User Management**: Supports user registration, login, and information updates  
- **Registration Management**: Full management of the registration process, including appointment, inquiry, and cancellation  
- **Department Management**: Supports add, delete, update, and query operations for department information  
- **Doctor Management**: Manages doctor schedules and registration levels  
- **Medical Records**: Records patient visit information and supports queries  
- **Treatment Group Management**: Supports creation and management of treatment groups  

## Main Modules

- **HospitalGuide**: AI-powered hospital guidance module using Alibaba Cloud large language model for intelligent conversation  
- **Login**: User and doctor authentication module  
- **Department**: Department information management module  
- **Employee**: Doctor information and scheduling management module  
- **Register**: Core module for registration and appointment  
- **TreatmentGroups**: Treatment group management module  

## Technology Stack

- Spring Boot  
- MyBatis  
- MySQL  
- RESTful API  
- Alibaba Cloud Large Language Model (AI Smart Guidance)  

## API Documentation

### Authentication

- `POST /login`: Doctor login  
- `POST /api/FirstLogin`: User first login  
- `POST /api/UserLogin`: User login  
- `POST /api/UpdateUserInfo`: Update user information  

### Department Management

- `GET /getAllDeptList`: Get list of all departments  
- `GET /getDeptListByPage`: Paginated query of department list  
- `POST /addDepartment`: Add a new department  
- `PUT /updateDepartment`: Update department information  
- `DELETE /deleteDepartment/{deptCode}`: Delete a department  

### Doctor Management

- `GET /getRegistDoctorList`: Get list of doctors available for registration  
- `GET /getDoctorListWithRegistName`: Get list of doctors with registration names  

### Registration Management

- `POST /addRegister`: Add a registration record  
- `GET /getMaxCaseNumber`: Get the maximum case number  
- `GET /getAlreadyRegisterCount`: Get the number of already registered patients  
- `POST /getAlreadyRegisterPatients`: Get list of already registered patients  
- `GET /getTodayRegisterRecords`: Get today's registration records  
- `GET /getRegisterList`: Get registration list (supports conditional queries)  

### Treatment Group Management

- `POST /api/treatment-groups/add`: Add a treatment group  
- `GET /api/treatment-groups/{id}`: Get treatment group details  
- `GET /api/treatment-groups/by-name/{realName}`: Get treatment group by patient name  
- `DELETE /api/treatment-groups/delete-by-name/{treatmentName}`: Delete treatment group by name  

### Smart Guidance

- `POST /api/hospitalGuide/chat`: Chat with the AI guidance bot  

## Database Design

The project uses MySQL database, with main tables including:

- `department`: Department information table  
- `employee`: Doctor information table  
- `register`: Registration record table  
- `treatment_groups`: Treatment group information table  

## Deployment Instructions

1. Install MySQL database and create the corresponding table structure  
2. Modify database connection information in `application.properties`  
3. Build with Maven: `mvn clean package`  
4. Run the project: `java -jar hospital-registration-backend.jar`  

## Contribution Guide

Contributions are welcome! Please follow these steps:

1. Fork the project  
2. Create a new branch  
3. Commit your code changes  
4. Create a Pull Request  

## License

This project is licensed under the MIT License. See the LICENSE file for details.