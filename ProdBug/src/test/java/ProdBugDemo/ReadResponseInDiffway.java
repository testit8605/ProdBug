package ProdBugDemo;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.io.InputStream;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReadResponseInDiffway 
{
	
	@Test
	public void testGetResponseAsString() 
	{ 
		String responseAsString = get("http://jsonplaceholder.typicode.com/posts/3").asString();
		System.out.println(responseAsString);
	}
	
	@Test
	public void testGetResponseAsInputString() throws IOException 
	{ 
		InputStream stream = get("http://jsonplaceholder.typicode.com/posts/3").asInputStream();
		System.out.println(stream.toString().length());
		stream.close();
	}
	
	
	@Test
	public void testGetResponseAsByteArray() throws IOException 
	{ 
		byte[] stream = get("http://jsonplaceholder.typicode.com/posts/3").asByteArray();
		System.out.println(stream.toString().length());
	}
	
	@Test
	public void testExtractDetaisusingPath() throws IOException 
	{ 
		String href = 
				
			given()
				.param("key1", "value")
				.header("HeadA", "valueA")
			.when()
				.get("http://jsonplaceholder.typicode.com/posts/3")
			.then()
				.contentType(ContentType.JSON)
				.statusCode(200)
				.body("title", equalTo("ea molestias quasi exercitationem repellat qui ipsa sit aut"))
				.body("id", is(3))
				.extract()
				.path("body");
		
			System.out.println(href);
			
			//when().get(href).then().statusCode(200);
	}
	
	
	@Test
	public void testExtractPathInOneLine() throws IOException 
	{
		String href1 = get("http://jsonplaceholder.typicode.com/posts/3").path("body");
		System.out.println(href1);
		when().get(href1).then().statusCode(200);
		
//		String href2 = get("http://jsonplaceholder.typicode.com/posts/3").andReturn().jsonPath().getString("body");
//		System.out.println(href2);
//		when().get(href2).then().statusCode(200);
		
	}
	
	

	@Test
	public void testExtractdetaisUsingResponse() throws IOException 
	{
		Response response=
		given()
		.param("key1", "value")
		.header("HeadA", "valueA")
	.when()
		.get("http://jsonplaceholder.typicode.com/posts/3")
	.then()
			.contentType(ContentType.JSON)
			.statusCode(200)
			.body("title", equalTo("ea molestias quasi exercitationem repellat qui ipsa sit aut"))
			.body("id", is(3))
			.extract()
			.response();
		
		System.out.println(response.contentType());
		System.out.println(response.path("body"));
		System.out.println(response.statusCode());
	}
	
	

}
