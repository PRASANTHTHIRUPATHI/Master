package com.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetPostProject

{
	@Test
	public void project()
	{
	
		JSONObject jobject=new JSONObject();
		jobject.put( "createdBy", "ram");
		jobject.put( "projectName","SDET 19PA");
		jobject.put("status", "ongoing");
		jobject.put("teamSize", 10);
		
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobject);
		Response resp = reqspec.post("http://localhost:8084/addProject");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(resp.getStatusCode(), 201);
		
		resp.prettyPrint();
	
		//reqspec.get("http://localhost:8084/projects/{resp}");
		
		//Assert.assertEquals(resp.getStatusCode(), 200);
		
	}
}
