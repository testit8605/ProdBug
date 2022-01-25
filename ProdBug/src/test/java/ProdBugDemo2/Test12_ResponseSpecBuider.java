package ProdBugDemo2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class Test12_ResponseSpecBuider 
{
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUp()
	{
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectStatusCode(200);
		builder.expectHeader("Content-Type", "application/json;charset=UFT-8");
		builder.expectHeader("Cache-Control", "no-store, max-age=0, must-revalidate");
		responseSpec = builder.build();
	}
	
	
	@Test
	public void testResponse1()
	{
		given()
			.get("http://jsonplaceholder.typicode.com/photos")
		.then()
			.spec(responseSpec)
			.time(lessThan(500L));
	}
	
	@Test
	public void testResponse2()
	{
		given()
			.get("http://jsonplaceholder.typicode.com/photos")
		.then()
			.spec(responseSpec);
			
	}
	
	

}
