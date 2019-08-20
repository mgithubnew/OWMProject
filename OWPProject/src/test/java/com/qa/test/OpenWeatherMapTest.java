package com.qa.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.OpenWeatherMapPage;
@Listeners(CustomeListener.class)

public class OpenWeatherMapTest extends TestBase {

	OpenWeatherMapPage page;

	public OpenWeatherMapTest() throws IOException {
		super();
	}

	@BeforeTest
	public void setup() throws IOException, InterruptedException {
		initialization();
		page = new OpenWeatherMapPage();
	}

	@Test(priority = 1)
	public void validatePageTitleTest() {

		String title = page.pageTitle();
		Assert.assertEquals(title, "Current weather and forecast - OpenWeatherMap", "Title not matched");
	}

	@Test(priority = 2)
	public void checkWeatherpgaeLogo() {
		boolean flag = page.pageLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority = 3)
	public void invalidCityTest() throws UnsupportedEncodingException {
			String lable1 = page.validateInvalidCity();
		Assert.assertEquals(lable1, "Not found", "Lable is not correct");
	}

	@Test(priority = 4)
	public void validCityTest() {
		page.validateValidCity();
	}

	@Test(priority = 5)
	public void validateWeatherImgTest() {
		boolean flag = page.validateWeatherImg();
		Assert.assertTrue(flag);
	}

	@Test(priority = 6)
	public void validateNameOfCityInOutputTest() {

		boolean flag = page.validateNameOfCityInOutput();
		Assert.assertTrue(flag);

	}

	@Test(priority = 7)
	public void validateFlagofCityTest() {

		boolean flag = page.validateFlagofCity();
		Assert.assertTrue(flag);

	}

	@Test(priority = 8)
	public void validateWeatherTest() {
		page.validateWeather();

	}

	@Test(priority = 9)
	public void validateWeatherLinkOnPageTest() {

		boolean flag = page.validateWeatherLinkOnPage();
		Assert.assertTrue(flag);
		Assert.assertEquals(OpenWeatherMapPage.weatherLinkName, "Weather", " WeatherLink name is not as expected.");
	}

	@Test(priority = 10)
	public void validateMapsDropDownPageTest() {

		boolean flag = page.validateMapsDropDownOnPage();
		Assert.assertTrue(flag);
		Assert.assertEquals(OpenWeatherMapPage.mapLinkName, "Maps", "Map Link name is not as expected.");
	}

	@Test(priority = 11)
	public void validateGuideLinkTest() {
		boolean flag = page.validateGuideLink();
		Assert.assertTrue(flag);
		Assert.assertEquals(OpenWeatherMapPage.guideLinkName, "Guide", "Guide Link name is not as expected.");

	}

	@Test(priority = 12)
	public void validateAPILink() {
		boolean flag = page.validateAPILink();
		Assert.assertTrue(flag);
		Assert.assertEquals(OpenWeatherMapPage.apiLinkName, "API", "API Link name is not as expected.");

	}

	@Test(priority = 13)
	public void validatePriceLinkTest() {
		boolean flag = page.validatePriceLink();
		Assert.assertTrue(flag);
		Assert.assertEquals(OpenWeatherMapPage.priceLinkName, "Price", "Price Link name is not as expected.");

	}

	@Test(priority = 14)
	public void validatePartnersLinkTest() {
		boolean flag = page.validatePartnersLink();
		Assert.assertTrue(flag);
		Assert.assertEquals(OpenWeatherMapPage.partnerLinkName, "Partners", "Price Link name is not as expected.");

	}

	@Test(priority = 15)
	public void validateStationLinkTest() {
		boolean flag = page.validateStationLink();
		Assert.assertTrue(flag);
		Assert.assertEquals(OpenWeatherMapPage.stationLinkName, "Stations", "Stations Link name is not as expected.");

	}

	@Test(priority = 16)
	public void validateWidgetsLinkTest() {
		boolean flag = page.validateWidgetsLink();
		Assert.assertTrue(flag);
		Assert.assertEquals(OpenWeatherMapPage.widgetsLinkName, "Widgets", "Widgets Link name is not as expected.");

	}

	@Test(priority = 17)
	public void validateBlogLinkTest() {
		boolean flag = page.validateBlogLink();
		Assert.assertTrue(flag);
		Assert.assertEquals(OpenWeatherMapPage.blogLinkName, "Blog", "Blog Link name is not as expected.");

	}

	@Test(priority = 18)
	public void validateSupportLinkTest() {

		boolean flag = page.validateSupportLink();
		Assert.assertTrue(flag);
		Assert.assertEquals(OpenWeatherMapPage.supportLinkName, "Support Center",
				"Support Link name is not as expected.");

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
