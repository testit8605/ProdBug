package ProdBugDemo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.hamcrest.*;
import io.restassured.http.*;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test3_SchemaTest {
	
	@Test
	public void testContentType()
	{
		given()
			.param("key1", "value")
			.header("HeadA", "valueA")
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/3")
		.then()
			.contentType(ContentType.JSON)
			.statusCode(200);
	}
	

	@Test
	public void testSchema()
	{
		
		given()
		.when()
			.get("http://geo.groupkt.com/ip/172.217.4.14/json")
		.then();
			//.assertThat().body(matchesJsonSchemaInClasspath("test3_geo_schema123.json"));//File name		
	}
	
	
	@Test
	public void testPresentOfElement()
	{
		given()
		.when()
			.get("http://geo.groupkt.com/ip/172.217.4.14/json")
		.then()
			.body("RestResponse.result.name", hasItems("Cayman Island", "Cook Island")).log().all();
	}

	@Test
	public void testLenghtOfResponse()
	{
		given()
		.when()
			.get("http://geo.groupkt.com/ip/172.217.4.14/json")
		.then()
			.body("RestResponse.result.alpha3_code*lenght().sum()", greaterThan(50));
	}
	
	
	@Test
	public void testGetResponsseAsList()
	{
		String response = get("http://geo.groupkt.com/ip/172.217.4.14/json").asString();
		
		List<String> ls = from(response).getList("RestResponse.result.name");
		
		System.out.println(ls.size());
		
			for(String country: ls)
			{
				if(country.equals("Solemon Island"))
					System.out.println("Found my place");
			}
		
		} 
	
	@Test
	public void testGetResponsseAsString() //name is greater that 30
	{
		String response = get("http://geo.groupkt.com/ip/172.217.4.14/json").asString();
		List<String> ls = from(response).getList("RestResponse.result.findAll {it.name.length()>40}.name");
		System.out.println(ls);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
