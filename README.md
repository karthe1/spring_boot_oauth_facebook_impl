# project description

* This is a spring boot application with OAuth2 protocol implementation using an Authorization code grant type. 
* The application authenticates the end-user using Facebook credentials and gets the user details using Spring Social.

# OAuth2 protocol

* It provides the simplest way to interact with and publish the protected data of end-users to the third-party client applications.
* Resource Owner: The owner of the REST resources. Here the owner term refers to the end-user. 
* Client Application: The application which we are creating using spring boot.
* Authorization Server: The server who authorizes the client application based on the provided information. Once the client information is verified, the authorization server sends the access token to access the REST resource.
* Resource Server: The server who sends the REST resources based on the provided access token.

# Steps to download and deploy the application 

* Check out the git repo in your local directory. ( git clone https://github.com/karthe1/spring_boot_oauth_facebook_impl.git ).

* Import the spring boot project using the existing maven project option in your IDE

* To register your local client application into the Authorization Server you need to integrate Facebook into your application.

* Create a Facebook developer account and get the client id and the client secret.

	* Go to https://developers.facebook.com/
	* Login using your Facebook credentials
	* Create a new application
	* Once the application is created, go the basic settings. There you can find the client Id and secret.
	
* Specify the generated client Id and secret key in your FacebookController.

* Once the changes are done, run the application as Spring boot app.

* Launch the URL: http://localhost:8080/root

* Then your Facebook profile details will be retrieved.



Appreciating your valuable feedback !!!
