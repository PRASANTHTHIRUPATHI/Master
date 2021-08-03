package com.comcast.create;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary1;

import io.restassured.http.ContentType;

public class CreateMultipleProjectUsingDataProvider 
{
	
@Test(dataProvider="getData")
public void createmultipleProject(String createdBy,String projectName,String status,int teamSize)
{
	baseURI="http://localhost";
	port=8084;
	ProjectLibrary1 projectlibrary =new ProjectLibrary1(createdBy, projectName, status, teamSize);
	given()
	.contentType(ContentType.JSON)
	.body(projectlibrary)
	.when()
	.post("/addproject")
	.then()
	.log().all();
}
@DataProvider
public Object[][] getData()
{
	Object[][] obj=new Object[4][4];
	obj[0][0]="surya";
	obj[0][1]="rmgTs";
	obj[0][2]="ongoing";
	obj[0][3]=73;
	
	
	
	obj[1][0]="surya1";
	obj[1][1]="rmgTs1";
	obj[1][2]="ongoing";
	obj[1][3]=73;
	
	
	obj[2][0]="surya2";
	obj[2][1]="rmgTs2";
	obj[2][2]="ongoing";
	obj[2][3]=73;
	
	
	obj[3][0]="surya3";
	obj[3][1]="rmgTs3";
	obj[3][2]="ongoing";
	obj[3][3]=73;
	return obj;
	
}
}
