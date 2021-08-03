package com.comcast.parameterAuthentication;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PathParameter 
{
	@Test
	public void verifyPathParameter()
	{
		baseURI="http://localhost";
		port=8084;
		given()
		.pathParam("project_id","TY_PROJ_1807")
		.when()
		.get("/projects/{project_id}")
		.then()
		.assertThat().statusCode(200)
		.assertThat().time(Matchers.lessThan(500L),TimeUnit.SECONDS)
		.log().all();
		
		
		/*given()
		.pathParam("project_id","TY_PROJ_1404")
		.when()
		.delete("/projects/{project_id}")
		.then()
		.assertThat().statusCode(204)
		.log().all();*/
	}
}
