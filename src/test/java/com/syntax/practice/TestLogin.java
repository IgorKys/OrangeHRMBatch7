package com.syntax.practice;

import com.syntax.pages.LoginPageWebElements;
import com.syntax.testBase.BaseClass;
import com.syntax.utils.ConfigsUtility;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLogin extends BaseClass {

	@Test
	public void loginTest() {
		LoginPageWebElements login = new LoginPageWebElements();

		login.userName.sendKeys(ConfigsUtility.getProperty("username"));
		login.password.sendKeys(ConfigsUtility.getProperty("password"));
		login.loginBtn.click();
	}

	@Test(dataProvider = "data")
	public static void negativeLoginTest(String username, String password, String expectedErrorMessage) {
		LoginPageWebElements login = new LoginPageWebElements();
		login.userName.sendKeys(username);
		login.password.sendKeys(password);
		login.loginBtn.click();

		String actualErrorMEssage = login.errorMessage.getText();
		Assert.assertEquals(actualErrorMEssage, expectedErrorMessage);
	}

	@DataProvider
	public Object[][] data(){
		
		Object[][] data = {
				
				{"Admin","ads","Invalid credentials"},
				{"Adn","admin123","Invalid credentials"},
				{"Admin","","Password cannot be empty"}	
				
		};
		
		return data;
	}

}
