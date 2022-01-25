package ProdBugDemo2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

public class Test15_BeforeClass 
{
	@BeforeClass
	public void setUp()
	{
		RestAssured.baseURI="http://jsonplaceholder.typicode.com";
		RestAssured.basePath="/photos";// write in test call and accordingly it will execute
//		RestAssured.port=8080;
//		RestAssured.authentication= basic("Akshay", "Bhagat");
//		RestAssured.rootPath="x.y.z";
//		RestAssured.filters(..);
//		RestAssured.requestSpecification = ..;
//		RestAssured.responseSpecification=.;
//		RestAssured.urlEncodingEnabled=;
//		RestAssured.defaultParser=;
//		RestAssured.registerParser(null, null);
//		RestAssured.unregisterParser(null);
//		RestAssured.useRelaxedHTTPSValidation();
//		RestAssured.trustStore(null);
//		RestAssured.reset();
		
	}
	
	@Test
	public void testResponse1()
	{
		given()
		.when()
			.get("/photos")
		.then()
			.statusCode(400)
			.time(lessThan(500L));	
	}
	
	

}
