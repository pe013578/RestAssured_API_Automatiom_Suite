package restAssured_API_Automation_Pawan.restAssured_API_Automation_Pawan;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class Test10_DeleteRequest extends RestUtils {
	//This script automates deleting a record
	
	@Test
	void deleteEmployeeRecord()
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestUtils.request = RestAssured.given();
		RestUtils.response = request.request(Method.GET, "/employees");
		
		//To extract JSON body data, use JsonPath. This is equivalent of xPath in XML
		JsonPath empids = response.jsonPath();
		
		//To find the employee id on the top of the employees record to be deleted
		String empid = empids.get("[2].id");
		//way 2 to get empid
		/*String id = responseObject.jsonPath().get("[0].id");*/
		System.out.println("employee id to be deleted "+ empid);
		
		//Sending a delete request
		RestUtils.response = request.request(Method.DELETE, "/delete/"+empid);
		String responsebody = response.getBody().asString();
		System.out.println("Response body is "+ responsebody);
	}

}
