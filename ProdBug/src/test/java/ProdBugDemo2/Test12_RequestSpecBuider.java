package ProdBugDemo2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import groovyjarjarpicocli.CommandLine.Spec;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Test12_RequestSpecBuider 
{
	RequestSpecification requestSpec;
	
	@BeforeClass
	public void setUp()
	{
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addParam("Parameter1", "ParameterValue");
		builder.addHeader("Header", "headerValue");
		requestSpec = builder.build();
	}
	
	@Test
	public void testResponse1()
	{
		given()
			.spec(requestSpec)
		.when()
			.get("http://jsonplaceholder.typicode.com/photos")
		.then()
			.statusCode(400)
			.time(lessThan(500L))
			.log().all()
			.log().body()
			.log().ifStatusCodeIsEqualTo(200)
			.log().headers()
			.log().cookies()
			.log().ifError()
			.log().ifValidationFails()
			.log().status()
			.log().toString();	
	}
	

}
