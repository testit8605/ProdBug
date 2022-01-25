package ProdBugDemo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test1_BasisFeature 
{
	
	@Test
	public void testStatusCode() 
	{ 
	
		given()
			.param("key1", "value")
			.header("HeadA", "valueA")
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/3")
		.then().
			statusCode(200)
			.log().all()
			.body("RestResponse.Results.name", equalTo("Unitet State of America"))
			.body("RestResponse.Results.name", equalTo("Unitet State of India"))
			.body("RestResponse.Results.name", equalTo("Unitet State of America"))
			.body("RestResponse.Results.name", is("Unitet State of India"));
		
			//XML response
			//.body(hasXpath("/CUSTOMER/FIRSTNAME", containsString("sau")))
			//.body(hasXpath("/CUSTOMER/INVOICE[text()='40']"));
		//.body(hasXpath("/CUSTOMER/INVOICE[text()='40']")).log().all();
			
			
	
	}

}
