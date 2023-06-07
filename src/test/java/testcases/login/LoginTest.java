package testcases.login;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.orangehrm.DashboardPage;

public class LoginTest extends BaseTest {
@Test
	public void loginTest() {

	DashboardPage dashboard = loginpageor.login("Admin", "admin123");
	}
}
