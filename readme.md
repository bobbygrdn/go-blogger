
# Go Blogger

![Logo](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/th5xamgrr6se0x5ro4g6.png)

A blog application that allows the tech community to stay up-to-date with the latests trends, news and technologies.

## Screenshots

![Landing Page](https://github.com/bobbygrdn/go-blogger/assets/96712943/844c64a7-dcf1-4dbc-97a2-34f98e0bf797)
![Login Page](https://github.com/bobbygrdn/go-blogger/assets/96712943/5389c5ac-3ab6-4541-ba43-54cffa6fc7d1)
![Home Page](https://github.com/bobbygrdn/go-blogger/assets/96712943/23dc3362-d05c-453c-8c39-ffda231e2f94)

## Demo

https://github.com/bobbygrdn/go-blogger/assets/96712943/c050e979-ac99-41d8-b3d8-c0f607a6a896

## Features

- Authentication/Authorization with Spring Security
- My Blogs Page
- Live Preview Edit Blog Page

## Lessons Learned

What did you learn while building this project? What challenges did you face and how did you overcome them?

- Spring Security can become quite combersome the more you try to control its actions. Configuration is key when you are trying to use enhanced/custom features with it.

- Implementing Spring Security was the biggest hurdle for this project. It took me quite awhile to implement. I read several pieces of documentation, watched several tutorials and asked for help from a mentor of mine that is a Java Engineer.

## Run Locally

Clone the project

```bash
  git clone https://github.com/bobbygrdn/go-blogger.git
```

Go to the project directory

```bash
  cd my-project
```

Change the application.properties file to reflect your own environment

```bash
# Thymeleaf
spring.thymeleaf.cache=false
spring.thymeleaf.enabled=true
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html

# MySQL properties
# Change these properties to match your environment
spring.datasource.url=jdbc:mysql://localhost:3306/springdb?useSSL=false
spring.datasource.username=root
spring.datasource.password=password

# Hibernate properties
# Change the dialect based on which MySQL you use
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update

# Spring devTools
spring.devtools.restart.additional-exclude=logs/**

# Debugging properties
logging.level.web=debug

# Applicaiton properties
# You can remove this or change it to whatever port you want, default is 8080
server.port=8081
```

Install MySQL if you do not already have it

```
  https://dev.mysql.com/downloads/mysql/
```

Create a database with the name you used in your application.properties file

```
create database springdb
```

Run the application to allow Spring Data JPA to create the tables in your database

```
javac RestfulWebserviceApplication.java
```

Run the init.sql file in your MySQL environment to populate the newly created tables with data

```
source init.sql
```

Restart the Spring application and you are all set to start using it!!

## API Reference

### User Controller

#### Get all users

```http
  GET /api/v1/users
```

| Parameter | Type | Description | Example |
| :-------- | :------- | :------ | :------ |
| `N/A` | `N/A` | Returns all users in the database | `[{"username":"user1","password":"password1"},{"username":"user2","password":"password2"}]` |

#### Get user

```http
  GET /api/v1/users/{username}
```

| Parameter | Type | Description | Example |
| :-------- | :------- | :------ | :------ |
| `username` | `string` | **Required**. Username of user to fetch | `sampleusername` |

#### Create user

```http
  POST /api/v1/users
```

| Parameter | Type | Description | Example |
| :-------- | :------- | :------ | :------ |
| `user` | `JSON object` | **Required**. JSON object of all the properties of the user | `{"username":"sampleusername", "password":"samplepassword"}` |

#### Update user

```http
  PUT /api/v1/users/{username}
```

| Parameter | Type | Description | Example |
| :-------- | :------- | :------ | :------ |
| `username` | `string` | **Required**. Username of user to update | `sampleusername`|
| `user` | `JSON object` | **Required**. JSON object of all the updated properties of the user | `{"username":"newsampleusername", "password":"newsamplepassword"}` |

#### Delete user

```http
  DELETE /api/v1/users/{username}
```

| Parameter | Type | Description | Example |
| :-------- | :------- | :------ | :------ |
| `username` | `string` | **Required**. Username of the user you want to delete | `sampleusername` |

### Blogpost Rest Controller

#### Get all blogposts

```http
  GET /api/v1/blogposts
```

| Parameter | Type | Description | Example |
| :-------- | :------- | :------ | :------ |
| `N/A` | `N/A` | Returns all blogposts in the database | `[{"title":"blog1","content":"blog1content"},{"title":"blog2","content":"blog2content"}]` |

#### Get blogpost

```http
  GET /api/v1/blogposts/{id}
```

| Parameter | Type | Description | Example |
| :-------- | :------- | :------ | :------ |
| `id` | `string` | **Required**. Id of blogpost to fetch | `1` |

#### Create blogpost

```http
  POST /api/v1/blogposts
```

| Parameter | Type | Description | Example |
| :-------- | :------- | :------ | :------ |
| `blogpost` | `JSON object` | **Required**. JSON object of all the properties of the blogpost | `{"title":"blogpost1", "content":"blogpost1content"}` |

#### Update blogpost

```http
  PUT /api/v1/blogposts/{id}
```

| Parameter | Type | Description | Example |
| :-------- | :------- | :------ | :------ |
| `id` | `string` | **Required**. Id of blogpost to update | `2`|
| `blogpost` | `JSON object` | **Required**. JSON object of all the updated properties of the blogpost | `{"title":"newblogpost1", "content":"blogpost1content"}` |

#### Delete blogpost

```http
  DELETE /api/v1/blogposts/{id}
```

| Parameter | Type | Description | Example |
| :-------- | :------- | :------ | :------ |
| `id` | `string` | **Required**. Id of the blogpost you want to delete | `2` |

### Blogpost Controller

#### Create blogpost

```http
  POST /create
```

| Parameter | Type | Description | Example |
| :-------- | :------- | :------ | :------ |
| `title` | `string` | **Required**. Title of the blog post to create | `blogpost1` |
| `content` | `string` | **Required**. Content of the blog post to create | `blogpost1content....` |

#### Update blogpost

```http
  POST /editBlog/{id}
```

| Parameter | Type | Description | Example |
| :-------- | :------- | :------ | :------ |
| `id` | `string` | **Required**. Id of blogpost to update | `2`|
| `blogpost` | `JSON object` | **Required**. JSON object of all the updated properties of the blogpost | `{"title":"newblogpost1", "content":"blogpost1content"}` |

#### Delete blogpost

```http
  GET /deleteBlog/{id}
```

| Parameter | Type | Description | Example |
| :-------- | :------- | :------ | :------ |
| `id` | `string` | **Required**. Id of the blogpost you want to delete | `2` |
