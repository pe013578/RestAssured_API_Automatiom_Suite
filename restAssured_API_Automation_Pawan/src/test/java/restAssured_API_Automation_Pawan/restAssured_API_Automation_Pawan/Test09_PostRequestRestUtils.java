package restAssured_API_Automation_Pawan.restAssured_API_Automation_Pawan;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Test09_PostRequestRestUtils extends RestUtils{
	
	//This test is verify the post request using the randomly generated values by RandomStringUtils class
	String empname = RestUtils.empName();
	String empsal = RestUtils.empSalary();
	String empage = RestUtils.empAge();
	
	@Test
	void testRestUtils()
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestUtils.request = RestAssured.given();
		
		JSONObject requestparam = new JSONObject();
		
		requestparam.put("name", empname);
		requestparam.put("salary", empsal);
		requestparam.put("age", empage);
		
		request.headers("Content-Type", "application/json");
		request.body(requestparam.toJSONString());
		
		RestUtils.response = request.request(Method.POST, "/create");
		
		String responsebody = response.getBody().asString();
		System.out.println("Response body is " + responsebody);
	}
	

}
