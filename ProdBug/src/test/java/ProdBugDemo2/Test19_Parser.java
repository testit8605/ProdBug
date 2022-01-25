package ProdBugDemo2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class Test19_Parser 
{
	
	@Test
	public void testDefaultparser()
	{
		RestAssured.defaultParser= Parser.XML;
		RestAssured.defaultParser= Parser.JSON;
		RestAssured.defaultParser= Parser.HTML;
	}
	
	@Test
	public void testDefaultparser2()
	{
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/photos")
		.then()
			.using()
			.defaultParser(Parser.JSON)
			.statusCode(200);
	}
	
	@Test
	public void testCustomParser1()
	{
		RestAssured.registerParser("application/vnd.uoml+xml", Parser.JSON);
		RestAssured.unregisterParser("application/vnd.uoml+xml");
	}
	
	@Test
	public void testCustomParser2()
	{
		given().get("http://jsonplaceholder.typicode.com/photos")
		.then().using().parser("application/vnd.uoml+xml", Parser.JSON);
	}
	
	

}
