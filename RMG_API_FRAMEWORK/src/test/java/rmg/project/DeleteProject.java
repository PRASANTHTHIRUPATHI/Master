package rmg.project;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProject 
{
	@Test
	public void testDelete()
{

		when()
		.delete("http://localhost:8084/projects/TY_PROJ_837")
		.then()
		.log().all()
		.and()
		.assertThat().statusCode(204)
		.and()
		.and().assertThat().contentType(ContentType.JSON);
}
	

}
