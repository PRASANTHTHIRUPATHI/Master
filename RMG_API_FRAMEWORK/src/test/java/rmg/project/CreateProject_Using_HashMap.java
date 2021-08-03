package rmg.project;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProject_Using_HashMap 
{
@Test
public void testcreatehash()
{
	HashMap map=new HashMap();
	map.put("createdBy","sakthi12");
	map.put("projectName","rmgt1011");
	map.put("status","ongoing");
	map.put("Teamsize", 87);
	
given()
.contentType(ContentType.JSON)
.body(map)
.when()
.post("http://localhost:8084/addProject")
.then()
.log().all()
.assertThat().statusCode(201)
.assertThat().contentType(ContentType.JSON);

when()
.get("http://localhost:8084/projects/TY_PROJ_1805")
.then()
.log().all()
.assertThat().statusCode(200)
.assertThat().contentType(ContentType.JSON);
	
}
}
