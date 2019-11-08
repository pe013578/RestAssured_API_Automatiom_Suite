package restAssured_API_Automation_Pawan.restAssured_API_Automation_Pawan;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test01_GetRequest {

	@Test
	
	void getWeatherInfo()
	{
		//specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification requestObject = RestAssured.given();
		
		//Response object
		Response responseObject = requestObject.request(Method.GET, "/Hyderabad");
		
		//convert JSON response body to string
		String response= responseObject.getBody().asString();
		
		//Print Response
		System.out.println("Response body is " + response);
		
		//validate response code
		int statusCode = responseObject.getStatusCode();
		System.out.println("Status code is " + statusCode);
		assertEquals(statusCode, 200);
		
		//validate status line
		String statuLine=responseObject.getStatusLine();
		System.out.println("Status line is " + statuLine);
		assertEquals(statuLine, "HTTP/1.1 200 OK");
		
	}
	
}
