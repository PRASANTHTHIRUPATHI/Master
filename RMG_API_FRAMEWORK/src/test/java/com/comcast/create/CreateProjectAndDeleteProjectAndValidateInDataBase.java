package com.comcast.create;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import com.comcast.GenericUtils.BaseApiClass;
import com.comcast.GenericUtils.DataBaseUtilities;
import com.comcast.GenericUtils.EndPoint;
import com.comcast.GenericUtils.JavaUtility;
import com.comcast.GenericUtils.RestAssuredUtility;
import com.comcast.POJOClass.ProjectLibrary1;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectAndDeleteProjectAndValidateInDataBase 
{
	public void createProjectWithCreatestatusandValidatedatainDbTest() throws Throwable
	{
		JavaUtility jlib = new JavaUtility();
		RestAssuredUtility rlib = new RestAssuredUtility();
		DataBaseUtilities dlib = new DataBaseUtilities();
		BaseApiClass baseapi = new BaseApiClass();
		baseapi.baseConfigure();
		int ran1 = jlib.randomnum();
		ProjectLibrary1 projectlibrary = new ProjectLibrary1("Prasanth","Crm"+ran1, "ongoing", 28);
		
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(projectlibrary)
		.when()
		.post(EndPoint.addproject);
		response.then()
		.log().all();
		String firstprojectid = rlib.restAssuredUtility(response,"projectId");
		String actProjectName = rlib.restAssuredUtility(response, "projectName");
		System.out.println(firstprojectid);
		System.out.println(actProjectName);
		dlib.connectToDB();
		String Query="select * from project";
		String expdata = dlib.executequeryandGetData(Query, 1,firstprojectid);
		String expName = dlib.executequeryandGetData(Query, 4,actProjectName );
		Assert.assertEquals(firstprojectid, expdata);
		Assert.assertEquals(actProjectName, expName);
		//delete project
		given()
		.pathParam("jsondata", firstprojectid)		
		.when()
		.delete("projects/{jsondata}")
		.then()
		.contentType(ContentType.JSON).log().all().statusCode(204);
		
		//dlib.executequeryandGetData(Query,1,firstprojectid);
	}
	}

