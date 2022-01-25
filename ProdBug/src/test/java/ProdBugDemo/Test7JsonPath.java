package ProdBugDemo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test7JsonPath 
{
	

	@Test
	public void testJsonPath() 
	{ 
		String responseAsString=
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/photos")
		.then()
			.statusCode(200)
			.extract()
			.asString();
		
		List<Integer> albumIds = from(responseAsString).get("id");
		System.out.println(albumIds.size());
		
	}
	
	@Test
	public void testJsonPath2() 
	{ 
		String responseAsString=
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/photos")
		.then()
			.statusCode(200)
			.extract()
			.asString();
		
		JsonPath jsonPath = new JsonPath(responseAsString).setRoot("RestResponse.results");
		
		List<String> list = jsonPath.get("name");
		System.out.println(list.size());
		
	}
	
	@Test
	public void testResponseHeader() 
	{ 
		Response responsee = get("http://jsonplaceholder.typicode.com/photos");
		
		//Single header
		String headerCFRAY = responsee.getHeader("HeaderName");
		System.out.println(headerCFRAY);
		
		//Multiple Header
		
		Headers headers = responsee.getHeaders();
		
		for(Header header:headers)
		{
			System.out.println(header.getName()+" : "+ header.getValue());
		}
	}
	
	@Test
	public void testResponseCookies() 
	{ 
		//Cookies
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		
		Map<String, String> map = response.getCookies();
		
		for(Map.Entry<String, String> entry: map.entrySet())
		{
			System.out.println(entry.getKey()+":"+ entry.getValue());
		}
		
	}
	
	@Test
	public void testDetailsCookies() 
	{ 
		//Detailed Cookies
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		
		Cookie c= response.getDetailedCookie("cookie name");
		
		System.out.println(c.hasExpiryDate());
		System.out.println(c.hasValue());
		System.out.println(c.EXPIRES);
		
	}
		
		

	
	
	
	
	
	
}
