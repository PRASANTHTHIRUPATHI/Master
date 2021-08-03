package com.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ChangeProject 
{
@Test
public void changPro()
{
	JSONObject jobject=new JSONObject();
	jobject.put( "createdBy", "ram");
	jobject.put( "projectName","SDET 19");
	jobject.put("status", "ongoing");
	jobject.put("teamSize", 10);
	
	RequestSpecification reqspec = RestAssured.given();
	reqspec.contentType(ContentType.JSON);
	reqspec.body(jobject);
	Response resp = reqspec.put("http://localhost:8084//projects/TY_PROJ_834");
	resp.prettyPrint();
	Assert.assertEquals(resp.getStatusCode(), 200);
}
	
}

