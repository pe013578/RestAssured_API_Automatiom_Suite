package restAssured_API_Automation_Pawan.restAssured_API_Automation_Pawan;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//Extract each node(each parameter) of response body using JSONPath and validate
//JSONPath prints each node value based on its key for which you got to specify key name in get method

public class Test06_GetRequest {
	
	@Test
	void responseBodyAll()
	{
		//specify the base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Create a request object
		RequestSpecification requestObject = RestAssured.given();
		
		//Create a response object
		Response responseObject = requestObject.request(Method.GET, "/Hyderabad");
		
		//Save JSON response body using JSONPath
		JsonPath responseBody = responseObject.jsonPath();

		//Print JSON response of all nodes
		System.out.println(responseBody.get("City"));
		System.out.println(responseBody.get("Temperature"));
		System.out.println(responseBody.get("Humidity"));
		System.out.println(responseBody.get("WeatherDescription"));
		System.out.println(responseBody.get("WindSpeed"));
		System.out.println(responseBody.get("WindDirectionDegree"));
		
		//Validate each field value
		Assert.assertEquals(responseBody.get("City"), "Hyderabad");
		
	}

}
