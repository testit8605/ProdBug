package ProdBugDemo2;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Authentication 
{
	@Test
	public void testBasicPreemptiveAuthentication()
	{
		//weather server want or not i am passing U and P
		given().auth().preemptive().basic("Username", "Password").when().get("http://jsonplaceholder.typicode.com/photos").then().statusCode(200);
		
	}
	
	@Test
	public void testBasicChallengedAuthentication()
	{
		//pass valid id and pass
		given().auth().basic("Username", "Password").when().get("http://jsonplaceholder.typicode.com/photos").then().statusCode(200);
		
	}
	
	@Test
	public void testBasicAuthentication()
	{
		RestAssured.authentication= basic("u","P");
		given().get("http://jsonplaceholder.typicode.com/photos").then().statusCode(200);
	}
	
	
	@Test
	public void testDigestiveAuthentication()
	{
		//More secure
		given().auth().digest("U", "P").when().get().then().statusCode(200);
	}
	

}
