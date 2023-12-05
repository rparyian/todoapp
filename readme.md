ToDoApp

A RESTful API to manage a simple todo list application using 
Spring Boot, Hibernate, and MySQL. The application allows users 
to create, read, update, and delete todo items. Each item has 
a title and a description. 


## Getting Started

### Prerequisites

- Java 
- Maven 
- MySQL Database
- SonarQube (optional, for static code analysis)

### Local Development

1. Clone the repository:

   git clone https://github.com/rparyian/todoapp.git
   cd todoapp

2. Configure Database:

    - Open src/main/resources/application.properties.
    - Update the database properties (url, username, password).

3. Configure SonarQube (optional):

    - Open pom.xml (Maven) or build.gradle (Gradle).
    - Set SonarQube server URL and authentication token(or login and password)

4. Build and Run the Application:

    - Maven:
      mvn clean install
      mvn spring-boot:run

    - Gradle:
      ./gradlew clean build
      ./gradlew bootRun

## Running Tests

Run the tests using the following commands:

- Maven:
  mvn test

- Gradle:
  ./gradlew test

## Code Coverage

Check the code coverage using JaCoCo. Generate the report with:

- Maven:
  mvn jacoco:report

- Gradle:
  ./gradlew jacocoTestReport

View the HTML report in target/site/jacoco/index.html (Maven) or build/reports/jacoco/test/html/index.html (Gradle).

## Static Code Analysis

Analyze the code with SonarQube using the following commands:

- Maven:
  mvn clean verify sonar:sonar -Dsonar.login=your_token_here

- Gradle:
  ./gradlew clean build sonarqube -Dsonar.login=your_token_here

View the analysis results on the SonarQube dashboard.

## API Endpoints

Here is a list of available API endpoints:

- Create Todo (POST /api/todos)
- Get All Todos (GET /api/todos)
- Get Todo by ID (GET /api/todos/{id})
- Update Todo (PUT /api/todos/{id})
- Delete Todo (DELETE /api/todos/{id})

## Contributing

Feel free to contribute by opening issues or creating pull requests. Follow the Contributing Guidelines for details.

## License

This project is licensed under the MIT License.

## Short feedback

-It was pretty easy to complete the task using AI
-~3hours
-I only need to change properties to connect to db and Sonar Server
-nothing special
-step by step promting was useful during this task