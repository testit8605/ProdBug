package ProdBugDemo2;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.mapper.ObjectMapperType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SerializationAndDeserialization 
{
	
	@Test
	public void testSerializationUsingHashMap()
	{
		//Java Object
		Map<String, String> map = new HashMap<String , String>();
		map.put("FirstName", "A");
		map.put("LastName", "B");
		map.put("Age", "30");
		
		
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post("http://jsonplaceholder.typicode.com/photos")
		.then()
			.statusCode(201);
	}
	

	@Test
	public void testSerializationUsingObject()
	{
		SerializationAndDeserializationZebraRequestClassName obj = new SerializationAndDeserializationZebraRequestClassName();
		obj.setAge(10);
		obj.setWeight(40);
		obj.setHome("India");
		 
		given()
			.contentType("application/json")
			.body(obj)
		.when()
			.post("http://jsonplaceholder.typicode.com/photos")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void testSerializationUsingJaxon()
	{
		SerializationAndDeserializationZebraRequestClassName obj = new SerializationAndDeserializationZebraRequestClassName();
		obj.setAge(10);
		obj.setWeight(40);
		obj.setHome("India");
		 
		given()
			.contentType("application/json")
			.body(obj, ObjectMapperType.JACKSON_2)
		.when()
			.post("http://jsonplaceholder.typicode.com/photos")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	@Test
	public void testDESerializationUsingJaxon()
	{
		SerializationAndDeserializationZebraRequestClassName obj = new SerializationAndDeserializationZebraRequestClassName();
		obj.setAge(10);
		obj.setWeight(40);
		obj.setHome("India");
		 
		SerializationAndDeserializationZebraResponseClassName resObj=
		given()
			.contentType("application/json")
			.body(obj, ObjectMapperType.JACKSON_2)
		.when()
			.post("http://jsonplaceholder.typicode.com/photos")
			.as(SerializationAndDeserializationZebraResponseClassName.class);
		
		resObj.setRegID(1000);
		
		Assert.assertTrue(resObj.getRegID()>0);
	}
	
	
	
	
	
	

}
