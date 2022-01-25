package ProdBugDemo2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test16_SSL_TLS 
{
	@BeforeClass
	public void setUp()
	{
		//if we writing below statement the no need to write relaxedHTTPSValidation
		RestAssured.useRelaxedHTTPSValidation(); //SSLPeerUnverifiedException exception
		
	}
	
	
	@Test
	public void testSSL()
	{
		given().when().get("/photos").then().statusCode(200);
		
		//OR
		
		given().relaxedHTTPSValidation().when().get("URL").then().statusCode(200);
				
	}
	
	@Test
	public void testTLS()
	{
		given().relaxedHTTPSValidation("TLS").when().get("URL").then().statusCode(200);
		
	}

}
