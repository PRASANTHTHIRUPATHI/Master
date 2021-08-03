package com.comcast.parameterAuthentication;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Queryparameter 
{
@Test
public void verifyQueryParaMeter()
{
	baseURI="https://reqres.in/";
	given()
	.queryParam("page", 2)
	.when()
	.get("/api/users")
	.then()
	.statusCode(200)
	.assertThat().time(Matchers.lessThan(500L),TimeUnit.SECONDS)
	.log().all();
}
}
