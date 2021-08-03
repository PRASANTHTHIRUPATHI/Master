package rmg.project;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProject {
	@Test
	public void testCreate() {

		JSONObject jobject2 = new JSONObject();
		jobject2.put("createdBy", "ram");
		jobject2.put("projectName", "SDET 191");
		jobject2.put("status", "ongoing");
		jobject2.put("teamSize", 10);
		given().contentType(ContentType.JSON).body(jobject2).when().post("http://localhost:8084/addProject").then()
				.log().all().assertThat().statusCode(201).assertThat().contentType(ContentType.JSON);

	}

}
