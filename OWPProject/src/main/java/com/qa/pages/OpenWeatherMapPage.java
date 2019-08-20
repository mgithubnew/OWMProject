package com.qa.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class OpenWeatherMapPage extends TestBase {
	public String lable;
	public static String weatherLinkName,mapLinkName,guideLinkName,apiLinkName,priceLinkName,partnerLinkName,stationLinkName,widgetsLinkName,blogLinkName,supportLinkName;

	@FindBy(xpath = "//*[@class=\"form-control border-color col-sm-12\"]")
	// @CacheLookup
	WebElement cityName;

	@FindBy(xpath = "//*[@id=\"searchform\"]/button")
	WebElement submit;

	@FindBy(xpath = "//*[@id=\"forecast_list_ul\"]/div")
	WebElement notFoundLable;
	
	
	@FindBy(xpath = "//*[@id=\"undefined-sticky-wrapper\"]/div/div/div/div[1]/a/img")
	WebElement logo;

	@FindBy(xpath = "//*[@id=\"forecast_list_ul\"]/table/tbody/tr/td[1]/img")
	WebElement weatherSymbol;

	@FindBy(xpath = "//*[@id=\"forecast_list_ul\"]/table/tbody/tr/td[2]/b[1]/a")
	WebElement nameOfCityInOutput;

	@FindBy(xpath = "//*[@id=\"forecast_list_ul\"]/table/tbody/tr/td[2]/img")
	WebElement flagImage;

	@FindBy(xpath = "//*[@id=\"forecast_list_ul\"]/table/tbody/tr/td[2]/p[1]/span")
	WebElement temperature;

	@FindBy(xpath = "//*[@id=\"undefined-sticky-wrapper\"]/div/div/div/div[2]/ul/li[3]/a")
	WebElement weatherLink;

	@FindBy(xpath = "//*[@id=\"undefined-sticky-wrapper\"]/div/div/div/div[2]/ul/li[4]/a")
	WebElement mapsDropDown;

	@FindBy(xpath = "//*[@id=\"undefined-sticky-wrapper\"]/div/div/div/div[2]/ul/li[5]/a")
	WebElement guideLink;

	@FindBy(xpath = "//*[@id=\"undefined-sticky-wrapper\"]/div/div/div/div[2]/ul/li[6]/a")
	WebElement apiLink;

	@FindBy(xpath = "//*[@id=\"undefined-sticky-wrapper\"]/div/div/div/div[2]/ul/li[7]/a")
	WebElement priceLink;

	@FindBy(xpath = "//*[@id=\"undefined-sticky-wrapper\"]/div/div/div/div[2]/ul/li[8]/a")
	WebElement partnersLink;

	@FindBy(xpath = "//*[@id=\"undefined-sticky-wrapper\"]/div/div/div/div[2]/ul/li[9]/a")
	WebElement stationsLink;

	@FindBy(xpath = "//*[@id=\"undefined-sticky-wrapper\"]/div/div/div/div[2]/ul/li[10]/a")
	WebElement widgetsLink;

	@FindBy(xpath = "//*[@id=\"undefined-sticky-wrapper\"]/div/div/div/div[2]/ul/li[11]/a")
	WebElement blogLink;

	@FindBy(xpath = "/html/body/div[1]/div/div/div[1]/a[1]/span")
	WebElement supportLink;

	public OpenWeatherMapPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public boolean pageLogo() {

		return logo.isDisplayed();
	}

	public String pageTitle() {

		return driver.getTitle();
	}

	public String validateInvalidCity() {
		cityName.sendKeys(prop.getProperty("invalidCityName"));
		submit.click();

		return notFoundLable.getText().replace("Ã" + "", "");
	}

	public void validateValidCity() {
		cityName.clear();
		cityName.sendKeys(prop.getProperty("validCityName"));
		submit.click();
	}

	public boolean validateWeatherImg() {
		return weatherSymbol.isDisplayed();
	}

	public boolean validateNameOfCityInOutput() {

		return nameOfCityInOutput.isDisplayed();
	}

	public boolean validateFlagofCity() {

		return flagImage.isDisplayed();
	}

	public String validateWeather() {
		return temperature.getText();
	}

	public boolean validateWeatherLinkOnPage() {
		
		 weatherLinkName=weatherLink.getText();
		return weatherLink.isDisplayed();
	}

	public boolean validateMapsDropDownOnPage() {
		mapLinkName=mapsDropDown.getText();
		return mapsDropDown.isDisplayed();
	}

	public boolean validateGuideLink() {
		
		guideLinkName=guideLink.getText();
		return guideLink.isDisplayed();
	}

	public boolean validateAPILink() {
		apiLinkName=apiLink.getText();
		return apiLink.isDisplayed();
	}

	public boolean validatePriceLink() {
		priceLinkName=priceLink.getText();
		return priceLink.isDisplayed();
	}
	public boolean validatePartnersLink() {
		partnerLinkName=partnersLink.getText();
		return partnersLink.isDisplayed();
	}

	public boolean validateStationLink() {
        stationLinkName=stationsLink.getText();
		return stationsLink.isDisplayed();
	}

	public boolean validateWidgetsLink() {
		widgetsLinkName=widgetsLink.getText();
		return widgetsLink.isDisplayed();
	}

	public boolean validateBlogLink() {
		blogLinkName=blogLink.getText();
		return blogLink.isDisplayed();
	}

	public boolean validateSupportLink() {
		supportLinkName=supportLink.getText();
		return supportLink.isDisplayed();
	}
}
