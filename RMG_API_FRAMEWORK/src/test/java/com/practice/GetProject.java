package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProject {
	@Test
	public void getProject() {
		Response respo = RestAssured.get("http://localhost:8084/projects");
		String result = respo.asString();
		System.out.println(result);
		String result1 = respo.prettyPrint();
		System.out.println(result1);
		int actstatuscode = respo.getStatusCode();
		System.out.println(actstatuscode);
		Assert.assertEquals(actstatuscode, 200);

		String actcontenttype = respo.contentType();
		System.out.println(actcontenttype);
		Assert.assertEquals(actcontenttype, "application/json");

	}
}
