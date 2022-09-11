# JavaSpringBootPostgresDemo

### Delete student
DELETE http://localhost:8080/api/v1/student/{studentId}


### Adding new student

POST http://localhost:8080/api/v1/student
Content-Type: application/json
{
 "name" : "teststudent2",
 "email" : "studenttest@gmail.com",
 "dob" : "1997-12-17"
}

### Getting Existing students
GET http://localhost:8080/api/v1/student


### Updaeting existing student
PUT http://localhost:8080/api/v1/student/{studentId}
Content-Type: application/json
{
 "email" : "newEmail@gmail.com",
 "dob" : "1997-12-17"
}
