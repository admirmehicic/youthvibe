# youthvibe
### Overview
Youthvibe is a project by a group of third-year Software Engineering students from the Polytechnic Faculty at the University of Zenica. Through this project, a web application was created where young people can exchange useful information about opportunities for youth in the community. The project was implemented as a web application, accessible through any web browser. 

## Features 
* User registration: Users can enter their information into a form, and that data is inserted into the corresponding 'users' table in the database.
* Admin login: With the login credentials admin/admin, the admin can view and manage all users from the database.
* User login: After registering, users log in with their credentials.
* News posting: Logged-in users are able to post news.
* Logout: Logged-in users are provided with the option to log out and return to the homepage.
* Viewing published opportunities: A controller is used for displaying this view, where data is fetched from the 'opportunities' table. After that, the retrieved data is forwarded to the next view. Thymeleaf technology was used to format the retrieved data appropriately.
* Posting opportunities: Through a form, the user enters data related to opportunities for young people in the community (title, description, date, location), and this data is inserted into the 'news' table. After that, the data is saved to the database.
* Viewing and posting news: Viewing published news is done similarly, based on the same principle.

## Tech Stack
* Frontend: HTML, CSS, Thymeleaf
* Backend: Java, Spring Boot
* Database: MySQL
* API: RESTful services
* Version Control: Git

## Installation
### Prerequisites
* Java JDK 11+
* Maven
* MySQL
* XAMPP

### Steps 
1. Clone the respository:

```git clone https://github.com/admirmehicic/youthvibe.git ```
   
```cd youthvibe```

2. Configure the application.properties file to connect to your MySQL database:

``` spring.datasource.url=jdbc:mysql://localhost:3305/youthvibe ```

``` spring.datasource.username=root ```

``` spring.datasource.password=admir ```

3. Build the project:

` mvn clean install `

4. Run the application:

`mvn spring-boot:run `

5. Open the application:

` localhost:8080 `
