package com.comcast.create;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;



public class BearerTokenAuthentication 
{
@Test
public void testBearertoken()
{
	HashMap map = new HashMap();
	map.put("name", "surya12");
	map.put("description","hello world");
	
	given()
	.auth()
	.oauth2("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")
	.body(map)
	.when()
	.post("https://api.github.com/user/repos")
	.then()
	.assertThat().statusCode(201)
	.log().all();
}
}
