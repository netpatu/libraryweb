# Libraryweb project deploy at local on windows

## Env set up

   ### 1, Install JDK 1.8
   ####    Download the JDK with the link: 
   http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
   ####    updating the path to the ENV Variable

   ### 2, Install Mysql
   #### Download Mysql package and install it with the link:
   https://www.mysql.com/support/supportedplatforms/database.html
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
   
## Gen the JAR package

## Gen the JAR package
