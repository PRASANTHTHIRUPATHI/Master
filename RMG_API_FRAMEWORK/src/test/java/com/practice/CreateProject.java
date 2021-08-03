package com.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CreateProject
{
	@Test
public void create()
{
		JSONObject jobject=new JSONObject();
		jobject.put( "createdBy", "ram");
		jobject.put( "projectName","SDET 19 AY");
		jobject.put("status", "ongoing");
		jobject.put("teamSize", 10);
		
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobject);
		Response resp = reqspec.post("http://localhost:8084/addProject");
		resp.prettyPrint();
		Assert.assertEquals(resp.getStatusCode(), 201);
		
}
}