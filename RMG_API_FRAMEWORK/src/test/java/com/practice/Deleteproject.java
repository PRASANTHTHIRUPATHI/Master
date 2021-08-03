package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Deleteproject 
{
	@Test
	public void deleteProject()
	{
		Response respo = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_828");
		String result = respo.asString();
		System.out.println(result);
		//String result1 = respo.prettyPrint();
		//System.out.println(result1);
		int actstatuscode = respo.getStatusCode();
		System.out.println(actstatuscode);
		Assert.assertEquals(actstatuscode, 204);
		

		String actcontenttype = respo.contentType();
	   System.out.println(actcontenttype);
	   Assert.assertEquals(actcontenttype,"application/json");
	   
	}
}
