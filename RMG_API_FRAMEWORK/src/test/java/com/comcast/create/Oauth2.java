package com.comcast.create;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oauth2 
{
@Test
public void testOuath2()
{
	//provide the client id and client scerete to generate token
	Response resp = given()
	.formParam("client_id", "Widmung")
	.formParam("client_secret", "f883acca24f648ecaa58538e108b2fa8")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri", "http://Widmung.com")
	
	//generate the token
	.when()
	.post("http://coop.apps.symfonycasts.com/token");
	System.out.println(resp.asPrettyString());
	String mytoken = resp.jsonPath().get("access_token");
	//use this token id any API 
	given()
	.auth()
	.oauth2(mytoken)
	.pathParam("USER_ID", "2111")
	.when()
	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
	.then()
	.log().all();
}
}
