package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.HomePage;
import pages.OnlineBankPage;

public class OnlineBankPageTest extends BaseTest {

    @Test
    @DisplayName("")
    public void checkingTheTransitionBetweenForms() {
        HomePage homepage = new HomePage();
        homepage.openPage()
                .clickToOnlineBank();

        OnlineBankPage onlineBankPage = new OnlineBankPage();
        onlineBankPage.clickPhoneInput()
                .enteringValues("9999999998")
                .checkSwitchingWithGoodPhone();
    }

    @Test
    @DisplayName("")
    public void checkingErrorPhone() {
        HomePage homepage = new HomePage();
        homepage.openPage()
                .clickToOnlineBank();

        OnlineBankPage onlineBankPage = new OnlineBankPage();
        onlineBankPage.clickPhoneInput()
                .enteringValues("999999")
                .checkError();
    }

    @Test
    @DisplayName("")
    public void checkingDeletePhone() {
        HomePage homepage = new HomePage();
        homepage.openPage()
                .clickToOnlineBank();

        OnlineBankPage onlineBankPage = new OnlineBankPage();
        onlineBankPage.clickPhoneInput()
                .enteringValues("9898998888")
                .clickDeletePhone();
    }
}
