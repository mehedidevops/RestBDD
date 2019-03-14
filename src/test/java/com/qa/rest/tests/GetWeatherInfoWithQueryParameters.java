package com.qa.rest.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetWeatherInfoWithQueryParameters {

	@Test
	public void GetWeatherInfoWithOneQueryParameter() {

		given().
			params("q", "Dhaka", "APPID", "9c78cfb95f82905df0b6efe2919194a8").
		when().
			get("http://api.openweathermap.org/data/2.5/weather").
		then().
			body("sys.country", equalTo("IN"));
	}

	@Test
	public void GetWeatherInfoWithTwoQueryParameter() {

		given().
			params("q","Dhaka,New Delhi","APPID","9c78cfb95f82905df0b6efe2919194a8").
		when().
			get("http://api.openweathermap.org/data/2.5/weather").
		then().
			body("sys.country", equalTo("IN"));
	}
	
	@Test
	public void GetWeatherInfoWithTwoXmlQueryParameter() {

		given().
			params("q","Dhaka,New Delhi","mode","xml","APPID","9c78cfb95f82905df0b6efe2919194a8").
		when().
			get("http://api.openweathermap.org/data/2.5/weather").
		then().
			body("current.city.country", equalTo("IN"));
	}

}