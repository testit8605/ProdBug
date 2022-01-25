package ProdBugDemo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class Test11_TimeMeasurment 
{
	
	@Test
	public void testResponseTime()
	{
		long t = given().get("http://jsonplaceholder.typicode.com/photos").time();
		System.out.println(t);
	}
	
	@Test
	public void testResponseTimeUnit()
	{
		long t = given().get("http://jsonplaceholder.typicode.com/photos").timeIn(TimeUnit.SECONDS);
		System.out.println(t);
	}
	
	

	@Test
	public void testResponseTimeAssertion()
	{
		given().get("http://jsonplaceholder.typicode.com/photos")
				.then()
				.time(lessThan(500L));
	}
	
	
	
	

}
