package rmg.project;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PartialChange
{
@Test
public void testpartial()
{
	JSONObject jobject=new JSONObject();
	jobject.put( "projectName","SDET 1932");
	
	
	given()
	.contentType(ContentType.JSON)
	.body(jobject)
	.when()
	.patch("http://localhost:8084/projects/TY_PROJ_836")
	.then()
	.log().all()
	.assertThat().contentType(ContentType.JSON)
	.assertThat().statusCode(200);
}
}
