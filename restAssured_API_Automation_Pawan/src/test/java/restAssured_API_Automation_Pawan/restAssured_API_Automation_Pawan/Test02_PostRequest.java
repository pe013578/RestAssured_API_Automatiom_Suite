package restAssured_API_Automation_Pawan.restAssured_API_Automation_Pawan;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test02_PostRequest {
	
	@Test
	void registration()
	{
		//specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		//Create a request object
		RequestSpecification requestObject = RestAssured.given();
		
		//Request parameters(payload) - values to be posted in JSON format
		JSONObject object = new JSONObject();
		object.put("FirstName", "goyale1");
		object.put("LastName", "passagu1");
		object.put("UserName", "goyale1");
		object.put("Password", "Test123");
		object.put("Email", "goyalepassagu@gmail.com");
		
		//Request header
		requestObject.header("Content-Type", "application/json");
		
		//Request body
		requestObject.body(object.toJSONString());
		
		//Send request now and store it in a response object
		Response responseObject = requestObject.request(Method.POST, "/register");
		
		//Response body
		String response = responseObject.getBody().asString();
		System.out.println("POST request response body is " + response);
		
		//status code validation
		int statusCode = responseObject.getStatusCode();
		System.out.println("Response status code is " + statusCode);
		assertEquals(statusCode, 201);
		
		//Success code validation
		String successCode= responseObject.jsonPath().get("SuccessCode");
		System.out.println("Success code is " + successCode);
		assertEquals(successCode, "OPERATION_SUCCESS");
		
		//Success message validation
		String message = responseObject.jsonPath().get("Message");
		System.out.println("Success message is " + message);
		assertEquals(message, "Operation completed successfully");
		
	}
}
