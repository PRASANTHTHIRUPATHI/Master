package com.comcast.GenericUtils;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseApiClass 
{
	DataBaseUtilities dbutil=new DataBaseUtilities();
	@BeforeSuite
public void baseConfigure()
{
	baseURI = "http://localhost";
	port = 8084;
	
	dbutil.connectToDB();
}
	@AfterSuite
public void asConfig() throws Throwable
{
	dbutil.closeDB();
}
}
