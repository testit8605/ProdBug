package ProdBugDemo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Test1_SettingRoots 
{
	
	@Test
	public void testwithRoots() 
	{ 
	
		given()
			.param("key1", "value")
			.header("HeadA", "valueA")
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/3")
		.then()
			.statusCode(200)
			.root("RestResponse.Results")
			.body("name", is("Unitet State of America"))
			.body("name", is("Unitet State of America"))
			.log().all();
				
			//XML response
			//.body(hasXpath("/CUSTOMER/FIRSTNAME", containsString("sau")))
			//.body(hasXpath("/CUSTOMER/INVOICE[text()='40']"));
		//.body(hasXpath("/CUSTOMER/INVOICE[text()='40']")).log().all();
	}
	
	@Test
	public void tesDetachedRoots() 
	{ 
		given()
		.param("key1", "value")
		.header("HeadA", "valueA")
	.when()
		.get("http://jsonplaceholder.typicode.com/posts/3")
	.then()
		.statusCode(200)
		.root("RestResponse.Results")
		.body("name", is("Unitet State of America"))
		.detachRoot("Results")
		.body("name", is("Unitet State of America"))
		.log().all();	
	}
	
	
	@Test
	public void tesPostReq() 
	{ 
		given()
		.header("HeadA", "valueA")
	.when()
		.post("http://jsonplaceholder.typicode.com/posts/3")
	.then()
		.statusCode(201)
		.log().all();
			
	}
	
}
