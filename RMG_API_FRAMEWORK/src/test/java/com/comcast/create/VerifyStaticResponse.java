package com.comcast.create;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class VerifyStaticResponse
{
	@Test
	
	public void testStaticeresponse()
	{
		String expecteddata = "AUTOMATION";
		//baseURI="http://localhost";
		//port=8084;
		Response response = when()
				.get("http://localhost:8084/projects");
				response.then().statusCode(200).log().all();
				String actualData = response.jsonPath().get("[0].projectName");
				Assert.assertEquals(actualData, expecteddata);
				//System.out.println("expected data is :"+expecteddata);
				
				
	}
}