package rmg.project;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ChangeProject {

	@Test
	public void testchanges() {
		JSONObject jobject = new JSONObject();
		jobject.put("createdBy", "ram");
		jobject.put("projectName", "SDET 19 AY");
		jobject.put("status", "ongoing");
		jobject.put("teamSize", 10);

		given().contentType(ContentType.JSON).body(jobject).when().put("http://localhost:8084/projects/TY_PROJ_836")
				.then().log().all().assertThat().contentType(ContentType.JSON).assertThat().statusCode(200);

	}

}
