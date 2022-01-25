  package ProdBugDemo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.http.*;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class Test10_VerifyResponse 
{
	
	@Test
	public void testStatusInResponse() 
	{ 
	//
	given()
	.when()
		.get("http://jsonplaceholder.typicode.com/photos")
	.then()
		.assertThat()
		.statusLine("HTTP/1.1 200 OK")
		//.statusLine(containsString("OK"))
		.statusCode(200);
	}
	
	@Test
	public void testHeaderInResponse() 
	{ 
	//Multiple header
	given()
	.when()
		.get("http://jsonplaceholder.typicode.com/photos")
	.then()
		.log().all()
		.assertThat()
		.header("Content-Type", "application/json; charset=utf-8")
	    .header("x-ratelimit-remaining", "999")
	    .headers("Vary", "Accept Encoding", "Content-Type",containsString("json"));
	}
	
	
	@Test
	public void testContentTypeInResponse() 
	{ 
	//Content
	given()
	.when()
		.get("http://jsonplaceholder.typicode.com/photos")
	.then()
		.assertThat()
		.contentType(ContentType.JSON);
	}
	
	@Test
	public void testBodyInResponse() 
	{ 
		String responseString = get("http://jsonplaceholder.typicode.com/photos").asString();
		given().when().get("http://jsonplaceholder.typicode.com/photos").then().assertThat().body(equalTo(responseString));		
	}
	
	@Test
	public void testCookiesInResponse() 
	{ 
		//if cookie value is getting change 
		given().when().get("http://jsonplaceholder.typicode.com/photos").then().assertThat().cookie("CookieName", "Value");		
	}
	
	
	@Test
	public void testBodyParameterInResponse() 
	{ 
		//Comparing response in body
		
//		given()
//		.when()
//			.get("http://jsonplaceholder.typicode.com/photos")
//		.then()
//			.body("anyAttribue", new ResponseAwareMatcher<Response>() {
//				public Matcher<?> matcher(Response response){
//					return equalTo("Attribute Value");
//				}
//			});
//			
		
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/photos")
		.then()
			.body("Attribute", response -> equalTo("Attribute value"));
		
		
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/photos")
		.then()
			.body("Attribute", endsWith("89765"));
	}
	
	
	

}
