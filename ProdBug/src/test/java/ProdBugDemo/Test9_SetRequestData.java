package ProdBugDemo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

public class Test9_SetRequestData {

	@Test
	public void testSetConnectRequest() 
	{ 
		//HTTPS
	given()
	.when()
		.request("CONNECT", "http://jsonplaceholder.typicode.com/photos")
	.then()
		.statusCode(200);
		
	}
	
	@Test
	public void testQueryParameter() 
	{ 
		
	given()
		.queryParam("A", "A val")
		.queryParam("B", "B val")
	.when()
		.get("http://jsonplaceholder.typicode.com/photos")
	.then()
		.statusCode(400);
	}
	
	
	@Test
	public void testFormParameter() 
	{ 
		
	given()
		.formParam("A", "A val")
		.formParam("B", "B val")
	.when()
		.post("http://jsonplaceholder.typicode.com/photos")
	.then()
		.statusCode(200);
	}
	
	
	@Test
	public void testSetParameter() 
	{ 
		//Generic parameter
		
	given()
		.param("A", "A val")
		.param("B", "B val")
	.when()
		.post("http://jsonplaceholder.typicode.com/photos")
	.then()
		.statusCode(200);
	}
	
	
	@Test
	public void testSetMultipleParameter() 
	{ 
		//List parameter
		
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		
	given()
		.param("A", "val1", "val2", "val3")
		.param("B")
		.param("c", list)
	.when()
		.get("http://jsonplaceholder.typicode.com/photos")
	.then()
		.statusCode(400);
	}
	
	@Test
	public void testSetPathParameter() 
	{ 
		//Path parameter
		
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		
	given()
		.pathParam("A", "val1")
		.param("B", "val2")
		.param("c", list)
	.when()
		.get("http://jsonplaceholder.typicode.com/photos/{A}/{B}")
	.then()
		.statusCode(400);
	}
	
	@Test
	public void testSetCookiesInRequest() 
	{ 
		//Cookies parameter		
	given()
		.cookie("CookieName")  //.cookie("CookieName", "1")
	.when()
		.get("http://jsonplaceholder.typicode.com/photos/{A}/{B}")
	.then()
		.statusCode(400);
	}
	
	
	@Test
	public void testSetMultipleCookiesInRequest() 
	{ 
		//Set multi value Cookie parameter		
	given()
		.cookie("key", "val1", "val2"); //key= val1 key= val2
		
		//Set detailed cookie
		Cookie cookie = new Cookie.Builder("Some cookie", "Some name").setSecured(true).setComment("Some comment").build();
	given().cookie(cookie).when().get("/cookie").then().assertThat().body(equalTo("x"));
		
	//Set multiple detailed cookie
	Cookie someCookie = new Cookie.Builder("key", "Value").setSecured(true).setComment("some comment").build();
	Cookie someCookie2 = new Cookie.Builder("key", "Value").setSecured(true).setComment("some comment").build();
	Cookies cookie2 = new Cookies(someCookie, someCookie2);
	
	given()
		.cookies(cookie2).when().get("url").then().assertThat().body(equalTo("X"));	
	}
	
	@Test
	public void testSetHeaders() 
	{ 
		//Cookies parameter		
	given()
		.header("K", "v")
		.header("B", "h")
		.header("c", "j")
	.when()
		.get("http://jsonplaceholder.typicode.com/photos/")
	.then()
		.statusCode(400);
	}
	
	
	@Test
	public void testSetContenetType() 
	{ 
		//Cookies parameter		
	given()
		.contentType(ContentType.JSON)
		.contentType("application/json; charset=utf-8")
	.when()
		.get("http://jsonplaceholder.typicode.com/photos/")
	.then()
		.statusCode(400);
	}
	
	
}
