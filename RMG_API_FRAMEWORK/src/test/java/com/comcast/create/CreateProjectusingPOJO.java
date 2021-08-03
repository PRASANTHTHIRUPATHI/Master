package com.comcast.create;

import com.comcast.POJOClass.ProjectLibrary;
import com.comcast.POJOClass.ProjectLibrary1;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class CreateProjectusingPOJO 
{
@Test
public void createUsingPOJO()
{
	//ProjectLibrary projectLibrary = new ProjectLibrary("vinoth", "rmg26", "ongoing",78);
	ProjectLibrary1 projectLibrary1 = new ProjectLibrary1("karthick", "rmgyar51","ongoing",37);
	given()
	.contentType(ContentType.JSON)
	.body(projectLibrary1)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.log().all()
	.assertThat().contentType(ContentType.JSON)
	.assertThat().statusCode(201);
	
	
	when()
	.get("http://localhost:8084/projects/TY_PROJ_1811")
	.then()
	.log().all()
	.assertThat().contentType(ContentType.JSON)
	.assertThat().statusCode(200);
	
	when()
	.delete("http://localhost:8084/projects/TY_PROJ_1811")
	.then()
	.assertThat().statusCode(204);
}
}
