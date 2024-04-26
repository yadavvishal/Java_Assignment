1- Clone the project from the Github- https://github.com/yadavvishal/Java_Assignment

2- Open the project in Spring Tool Suite or Eclipse.

3- Go to application.properties file of the project configure  database.

	spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
	spring.datasource.username=your_username
	spring.datasource.password=your_password
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.show-sql = true
	
4-  Create the database in MySQL.

5- Run the project and Test the API. 
