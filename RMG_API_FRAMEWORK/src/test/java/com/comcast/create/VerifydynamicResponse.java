package com.comcast.create;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VerifydynamicResponse {
	@Test
	public void verifyDynamicResponse() {
		String Expectedresult = "ADARSH";
		String actualresult = null;
		// baseURI="http://localhost";
		// port=8084;
		Response response = when().get("http://localhost:8084/projects");
		response.then().statusCode(200).log().all();
		List<String> list = response.jsonPath().get("createdBy");
		boolean flag = false;
		for (String data : list) 
		{
			if (data.equals(Expectedresult)) {
				actualresult = data;
				flag = true;
				break;
			}
			
	
		}
		Assert.assertEquals(flag, true);
	}
	
}
