package rmg.project;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateprojectUsingJsonFile 
{
@Test
public void testcreatProject()
{
	File file=new File("./CreateProject.json");
	given()
	.contentType(ContentType.JSON)
	.body(file)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.log().all()
	.assertThat().contentType(ContentType.JSON)
	.assertThat().statusCode(201);
	

}
}
