package com.comcast.create;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicAuthentication 
{
@Test
public void teseBascicAuthentication() {
	
	baseURI="http://localhost";
	port=8084;
	given()
	.auth()
	.basic("rmgyantra","rmgy@9999")
	.when()
	.get("/login")
	.then()
	.assertThat().statusCode(202)
	.log().all();
}
}
