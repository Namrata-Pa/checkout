Problem Satement
--------------------------------------------------------
Build the domain model only for a checkout counter in an online retail store that scans products and generates an itemized bill.
The bill should also total the cost of all the products and the applicable sales tax for each product.
The total cost and total sales tax should be printed
Sales tax varies based on the type of products
- Category A products carry a levy of 10%
- Category B products carry a levy of 20%
- Category C products carry no levy

--------------------------------------------------------

Project Details
***********************
git version : 2.26.2.windows.1
mvn version : 3.6.3
Java version : Java 8

Project uses Java 8, Spring Boot, Hibernate, inmemory databas h2 and restful end points to get details of products available in online retail store and generate the bill by passing the list of products to POST service.


Database Information 
***********************
Intial database tables created automatically with provided DDL statements in schema-dev.sql file, intial data added with provided DML statements in data-dev.sql file.
Once project satrted on localhost, database can be accessible on link http://localhost:8080/h2


Rest Service Information
***********************
Rest Webservices GET and POST can be used to check the prodcuts available in online store.

Products
GET : http://localhost:8080/products : To list out all available products in online store
GET : http://localhost:8080/product/{id} : To get particular product from the store

Bills
GET : http://localhost:8080/bills : To list out all bills
GET : http://localhost:8080/bill/{id} : To get particular bill
POST : http://localhost:8080/cbill : To create the bill (curl -X POST -H "Content-Type: application/json" -d "{\"scannedProductList\":[{\"productId\":101,\"qty\":2},{\"productId\":103,\"qty\":1}]}" http://localhost:8080/cbill)


Unit test cases
***********************
All modules including controller, services and repositories are covered with Junit test cases.
