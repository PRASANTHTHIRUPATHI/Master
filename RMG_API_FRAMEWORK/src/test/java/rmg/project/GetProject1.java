package rmg.project;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetProject1
	{
		@Test
		public void testProject()
		{
			when()
			.get("http://localhost:8084/projects")
			.then()
			.log().all()
			.and()
			.assertThat().statusCode(200)
			.and()
			.and().assertThat().contentType(ContentType.JSON);

		}
	}