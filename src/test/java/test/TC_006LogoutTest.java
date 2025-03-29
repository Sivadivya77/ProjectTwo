package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.LoginPage;
import page.LogoutPage;

public class TC_006LogoutTest extends ProjectSpecificationMethod {
	@Test
	public void testLogoutPage() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("siva77@guvi.com");
		loginPage.enterPassword("123456789");
		loginPage.clickLoginButton();
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickLogout();
		String expecttext = loginPage.islogintextvisibil();
		String actultext = "Log In:";
		Assert.assertEquals(expecttext, actultext);

	}

}
