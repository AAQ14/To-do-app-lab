# To-do-app-lab
# Description
To do list app is a Spring Boot REST API that manages the to do list. The application is connected to the the database postgresql. This API allows the user to create, get, update, delete the data.
# Technologies
* Spring Boot
* Java
* Maven
* REST API
# End points
## There are 10 end points implemented
* GET /api/categories get the to do list
* POST /api/categories create a new category
* GET /api/categories/{categoryId} get a category by the id specific
* PUT /api/categories/{categoryId} update a category by the path variable id the requested body
* DELETE /api/categories/{categoryId} delete a category by the specified id
* GET /categories/{categoryId}/items get a list of items by category id
* POST /categories/{categoryId}/items create a new item by category id specified
* GET /categories/{categoryId}/items/{itemId} get an item by item id specified
* PUT /categories/{categoryId}/items/{itemId} update an item by category id and item id specified
* DELETE /categories/{categoryId}/items/{itemId} delete an item by category id and item id specified
# Instructions for running the project
* Java installed
* Maven installed
* IDE like IntelliJ or Visual Studio Code
* clone or download the project
* open the project in IDE.
* run the Spring Boot application.
* the app will run locally usually at http://localhost:8000 .
* use tool like postman to test the end points.
