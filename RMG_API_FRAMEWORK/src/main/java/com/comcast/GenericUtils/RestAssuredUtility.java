package com.comcast.GenericUtils;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class RestAssuredUtility 
{
public String restAssuredUtility(Response response,String jsonPath)
{
	String jsonData = response.jsonPath().get(jsonPath);
	return jsonData;
}
}
