package restAssured_API_Automation_Pawan.restAssured_API_Automation_Pawan;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//Extract specific headers from a response and validate. Note: Wrong API URL needs correction.

public class Test03_GetRequest {
	
	@Test
	void googleMapTest()
	{
		//Specify URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		//Create request object
		RequestSpecification requestObject = RestAssured.given();
		
		//Create response object
		Response responseObject = requestObject.request(Method.GET, "/employees");
		
		//Store JSON response as a string value
		String response = responseObject.getBody().asString();
		System.out.println("JASON response is " + response);
		
		//Retrieve headers and validate. response contains more than one id. need to figure out how to store all ids.
		String id = responseObject.jsonPath().get("[0].id");
		System.out.println("ID is " + id);
		
		
	}

}
