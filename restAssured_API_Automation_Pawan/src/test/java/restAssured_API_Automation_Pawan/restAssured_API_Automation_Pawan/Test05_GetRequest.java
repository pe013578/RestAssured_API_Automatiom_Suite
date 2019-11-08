package restAssured_API_Automation_Pawan.restAssured_API_Automation_Pawan;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//Extract response body(each parameter in any response body) and validate one field randomly

public class Test05_GetRequest {
	
	@Test
	void responseBodyValidation()
	{
	//specify the base URI
	RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	
	//Create a request object
	RequestSpecification requestObject = RestAssured.given();
	
	//Create a response object
	Response responseObject = requestObject.request(Method.GET, "/Hyderabad");
	
	//Save response as a string and validate response body
	String responseBody = responseObject.getBody().asString();
	System.out.println("Response body is " + responseBody);
	Assert.assertEquals(responseBody.contains("Hyderabad"), true);
			
	}

}
