# PROJECT : dm-online-banking
 
__This project is a maven multi module project for MR Gokan Ekinci. This is the last TP. The writer of the code is Ruben Edery. The class is Inge3-FISAA-SCCIN:__ 
__There are 6 modules in this project.
* aspectj-aop-utils : AOP Process 
 
* client-management-services
 
* client-services
 
* client-models
 
* data-access-services
 
* rest-client-utils
 
 
 
__Diagram:__ 
* ![alt text](https://github.com/rubenedery/dm-online-banking-new/blob/master/diagram/diagram1.png) 
__Diagram:__ 
* ![alt text](https://github.com/rubenedery/dm-online-banking-new/blob/master/diagram/diagram2.png) 


 
 
 
if you want to use the app and run it, you can use instructions 

__Step 1:__
 
* Clone the project with the command :
> git clone https://github.com/rubenedery/dm-online-banking-new.git
 
__Step 2:__
* Open your terminal
* Use this command: 
> mvn clean package
 
__Step 3:__
__Launch data-access-services__
* move the current directory to the directory name « data-access-services » 
* Mysql port need to be 8889 and db name is test
*The app start on port 25002
*If you want to use your port and your database, you can change values on application.properties
* Run with the command: 
> mvn spring-boot:run
 
- In this order you need to do the same handling : 
* client_management_services(port : 25003)
* client_services(port : 25004)
 
__Step 4:__
 
*Use Postman or download it with google chrome* 
 
* Send a postman request:
 
* For users
1. User by id
GET: http://localhost:25002/data-access/users/1
POST : http://localhost:25002/data-access/users (Insert Json)
PUT : http://localhost:25002/data-access/users/2 (Insert Json)
…
 