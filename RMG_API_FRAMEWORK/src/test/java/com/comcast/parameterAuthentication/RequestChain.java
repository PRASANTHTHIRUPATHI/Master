package com.comcast.parameterAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RequestChain 
{
@Test
public void testRequestChaining() {
	
	baseURI="http://localhost";
	port=8084;
	//get all projects
	Response response = when()
	.get("/projects");
	
	//capture any id
	String firstproject = response.jsonPath().get("[0].projectId");
	System.out.println(firstproject);
	
	//delete the project
	
	given()
	.pathParam("ProjectID", firstproject)
	.when()
	.delete("/projects/{ProjectID}")
	.then()
	.assertThat().statusCode(204)
	.log().all();
}
}
