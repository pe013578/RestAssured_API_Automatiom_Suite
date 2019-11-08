package restAssured_API_Automation_Pawan.restAssured_API_Automation_Pawan;

import org.apache.commons.lang3.RandomStringUtils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {
	
	public static RequestSpecification request;
	public static Response response;
	
	public static String empName()
	{
		String empname = RandomStringUtils.randomAlphanumeric(5);
		return ("John"+ empname);
	}

	public static String empSalary()
	{
		String empsal = RandomStringUtils.randomNumeric(5);
		//return (Integer.parseInt(empsal));
		return empsal;
	}
	
	public static String empAge()
	{
		String empage = RandomStringUtils.randomNumeric(2);
		//return (Integer.parseInt(empage));
		return empage;
	}
}
