package restAssured_API_Automation_Pawan.restAssured_API_Automation_Pawan;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//Date drive test using TestNG dataprovider method with hard coded value
public class Test08_DataDrivenTest {
	
	@Test(dataProvider = "testData")
	void dataDrivenTest1(String name, String sal, String age)
	{
	//Base URI definition
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	
	//Create request object
	RequestSpecification requestObject = RestAssured.given();
	
	//Create JSON object and prepare data to be posted
	JSONObject requestParam = new JSONObject();
	requestParam.put("name", name);
	requestParam.put("salary", sal);
	requestParam.put("age", age);
	
	//Add a header to specify it is a JSONPOST request
	requestObject.header("Content-Type", "application/json");
	
	//Add JSON body to the request
	requestObject.body(requestParam.toJSONString());
	
	//Add JSON POST request and capture entire response
	Response response = requestObject.request(Method.POST, "/create");
	
	//Capture response body to perform validation
	String responseBody = response.getBody().asString();
	System.out.println("response body is "+ responseBody);
	
	//Response body validation
	Assert.assertEquals(responseBody.contains(name), true);
	Assert.assertEquals(responseBody.contains(sal), true);
	Assert.assertEquals(responseBody.contains(age), true);
	
	//Status code verification
	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
	}
	
	//Passing data through data provider testNG method with hard coded value
/*	@DataProvider(name = "testData")
	String [][] testDataPrep()
	{
		String testData[][] = {{"rasutest1","23000","27"}, {"rasutest2","27000","29"}, {"rasutest3","39000","32"}};
		return testData;
	}*/
	
	
	//reading data from excel and passing it through dataprovider method
	@DataProvider(name = "testData")
	String [][] testDatafromExcel() throws IOException
	{
		String path = System.getProperty("user.dir")+ "/src/test/java/restAssured_API_Automation_Pawan/restAssured_API_Automation_Pawan/TestData_POSTRequest.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", rowcount);
		String empdata[][]=new String[rowcount][colcount];
		
		for(int i=1; i<=rowcount; i++){
			for(int j=0; j<colcount; j++) {
				empdata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return empdata;
	}
}
