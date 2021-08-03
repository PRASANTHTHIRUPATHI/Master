package com.comcast.parameterAuthentication;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary1;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RequestchainingPostAndDelete 
{
@Test
public void verifyrequestChaining()
{
	
	
	ProjectLibrary1 projectLibrary1 = new ProjectLibrary1("nithish", "CRM70","completed",37);
	Response response = given()
	.contentType("application/json")
	.body(projectLibrary1)
	.when()
	.post("http://localhost:8084/addProject");
	System.out.println(response.asPrettyString());
	
	String myproject = response.jsonPath().get("projectId");
	System.out.println(myproject);
	
	given()
	.pathParam("project", myproject)
	.when()
	.delete("http://localhost:8084/projects/{project}")
	.then()
	.assertThat().statusCode(204);
	
	
	

}
}
