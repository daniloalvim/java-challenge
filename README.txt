HOW TO COMPILE AND RUN THE APPLICATION
	1. Download the zip file and extract it in the default workspace directory.
	2. At the prompt window, write the command: mvn eclipse:eclipse
	3. Import the downloaded project into Eclipse
	4. In the Project Explorer View, click with the right mouse bottom at file pom.xml and select Run as.. -> Maven build
	5. At the root of your target directory, pick the generated .war file
	6. Drop the .war file in your webapps directory web server
	7. Start your web server and the new application might be available

HOW TO TEST THE WEBSERVICE METHODS
	1. PRODUCTS
		1.1 List product catalog
			1.1.1 If your web server is started, access the url http://localhost:8080/java-webapp-coding-test/rest/produto/list
			1.1.2 The list (in Json format) must be displayed on the page
		1.2 Read a single product by its id
			1.2.1 If your web server is started, access the url http://localhost:8080/java-webapp-coding-test/rest/produto/detail/{ID_PRODUCT},
				  where {ID_PRODUCT} is the primary key of Produt0 (table TB_PRODUTO). 
				  E.g.: http://localhost:8080/java-webapp-coding-test/rest/produto/detail/1
			1.2.2 The Product's detail (in Json format) must be displayed on the page
			
	2. ORDERS
		2.1 Place an order
			2.1.1 Open the file StartPlaceOrder.java
			2.1.2 Change the values of the constants by the values of your new Order
			2.1.3 If your web server is started, click with the right mouse bottom at file StartPlaceOrder.java and select Run as.. -> Java application
			2.1.4 The new Order (in Json format) must be displayed on the Console
		2.2 Modify an existing order
			2.1.1 Open the file StartModifyOrder.java
			2.1.2 Change the values of the constants by the values of your selected Order to modify.
			2.1.3 For better test, choose an ID that exists in the database (table TB_ORDEM)
			2.1.4 If you want, you can change the values of an OrdemProduto object by choosing an ID that exists in the database (table TB_ORDEM_PRODUTO)
			2.1.5 If your web server is started, click with the right mouse bottom at file StartModifyOrder.java and select Run as.. -> Java application
			2.1.6 The modified Order (in Json format) must be displayed on the Console
		2.3 List placed orders
			2.3.1 If your web server is started, access the url http://localhost:8080/java-webapp-coding-test/rest/ordem/list
			2.3.2 The list (in Json format) must be displayed on the page
		2.4 Read an existing order by its id
			2.4.1 If your web server is started, access the url http://localhost:8080/java-webapp-coding-test/rest/ordem/detail/{ID_ORDER},
				  where {ID_ORDER} is the primary key of Ordem (table TB_ORDEM). 
				  E.g.: http://localhost:8080/java-webapp-coding-test/rest/ordem/detail/1
			2.4.2 The Order's detail (in Json format) must be displayed on the page

HOW TO RUN THE AUTOMATED TESTS
	1. TestOrdemService
		1.1 Open the file TestOrdemService.java
		1.2 Change the value of the Order's ID (ID_ORDEM constant) to be tested if desirable
		1.3 Click with the right mouse bottom at file TestOrdemService.java and select Run as.. -> JUnit Test
		1.4 The results will be displayed in the Console and JUnit views
	2. TestProdutoService
		1.1 Open the file TestProdutoService.java
		1.2 Change the value of the Product's ID (ID_PRODUTO constant) to be tested if desirable
		1.3 Click with the right mouse bottom at file TestProdutoService.java and select Run as.. -> JUnit Test
		1.4 The results will be displayed in the Console and JUnit views

COMMENTS
	1. In this project, I preferred to use MySql instead of H2 Database. I have created a MySql database called DGASISTEMAS01 and put it accessible to any external IPs.
		1.1 To manage this database, access mysql.dgasistemas.com.br, username dgasistemas01 and password dgasistemas