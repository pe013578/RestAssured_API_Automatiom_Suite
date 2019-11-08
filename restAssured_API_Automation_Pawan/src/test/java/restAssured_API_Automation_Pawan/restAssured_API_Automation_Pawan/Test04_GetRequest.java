package restAssured_API_Automation_Pawan.restAssured_API_Automation_Pawan;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//extract all headers from a response and validate

public class Test04_GetRequest {
	
	@Test
	void allHeadersTest()
	{
	//Create base URI
	RestAssured.baseURI = "https://cloud.google.com";
	
	//Create a request object
	RequestSpecification requestObject = RestAssured.given();
	
	//Create a response object
	Response responseObject = requestObject.request(Method.GET, "/maps-platform");
	
	//Convert response body into a string format and print it in console
	String response = responseObject.getBody().asString();
	System.out.println("Response data is " + response);
	
	//Capture all headers
	Headers allHeader = responseObject.getHeaders();
	
	for(Header headerLoop:allHeader)
	{
	 System.out.println("Header Name: "+ headerLoop.getName()+"   "+"Header Value " + headerLoop.getValue());	
	}
	
	//Validating each header. For example only one is given here
	
	String language= allHeader.getValue("Content-Language");
	assertEquals(language, "en");
	
	
	}
}
