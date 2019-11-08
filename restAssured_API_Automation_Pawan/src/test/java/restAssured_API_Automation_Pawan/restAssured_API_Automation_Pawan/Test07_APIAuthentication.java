package restAssured_API_Automation_Pawan.restAssured_API_Automation_Pawan;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test07_APIAuthentication {
	
	@Test
	void APIAuthentication()
	{
	    //specify the base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
	
		//Basic Authentication code
		PreemptiveBasicAuthScheme authObject = new PreemptiveBasicAuthScheme();
		authObject.setUserName("ToolsQA");
		authObject.setPassword("TestPassword");
		RestAssured.authentication = authObject;
				
		//Create a request object
		RequestSpecification requestObject = RestAssured.given();
		
		//Create a response object
		Response responseObject = requestObject.request(Method.GET, "/");
		
		//Print response body
		String responseBody = responseObject.getBody().asString();
		System.out.println("Response body is " + responseBody);
		
		//Verify if the status code is 200
		int statusCode = responseObject.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("test is a pass");
	}
}
