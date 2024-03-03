# Libraryweb project
## Introduction
This is a Book Management System that allows users to create, read, update, and delete books. It consist of two front-end user interface project and a back-end paired with a database. 
Front-end project is developed with vue and android which Beck-end is springboot , web and mybais.Both them are provide the test case for api or data persist, which apply the TDD principle.
# Project deploy at local on windows
## Env set up

   ### 1, Install JDK 1.8
   ####    Download the JDK with the link: 
   http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
   ####    updating the path to the ENV Variable

   ### 2, Install Mysql
   #### Download Mysql package with the link:
   https://www.mysql.com/support/supportedplatforms/database.html
   ####  Install Mysql 
   Setup user name and password of the sql server after Mysql installed. 
   #### Open the terminal to access mysql server
   Type "mysql -h localhost -u ${username} -p" 
   #### Create data base with below cmd in terminal
   create database ${databasename};
   #### Gen tables with belwo cmd in terminal
     CREATE TABLE table_book (
            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
            `book_id` bigint(20) DEFAULT NULL COMMENT '书本ID',
            `title` varchar(50) DEFAULT NULL COMMENT '书本名称',
            `author` varchar(50) DEFAULT NULL COMMENT '书本作者',
            `publicationDate` date DEFAULT NULL COMMENT '书本发行时间',
            `isbn` varchar(50) DEFAULT NULL COMMENT '书本序列号',
            PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='图书表';
   
## Gen the beckend JAR package and run it
Open ternimal   
Got into the the ptoject with "cd ${project path}"  
 Run cmd to build application package with "mvn clean package -Dmaven.test.skip=true"  
Got into the the package output location and run cmd "java -jar ${package name}.jar" to run up the application  
Launch the web page with http://localhost:8081  
## Install apk on the phone 
Copy the apk file to the phone.  
Install the aok file inside the phone.  
