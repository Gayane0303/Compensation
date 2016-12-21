package Compensation.home;

import Compensation.core.Driver;
import Compensation.core.Functions;
import com.codeborne.selenide.junit.TextReport;
import org.junit.*;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class HomeTest {
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);
    Driver driver = new Driver();
    Functions functions = new Functions();

    @Before
    public void doBefore() {
        driver.Driver();
    }

    @After
    public void doAfter() {
        close();
    }

    @Test
    public void singIn() {
        $(By.xpath("//a[contains(.,'Sign in')]")).waitUntil(appear, 5000).click();
        $(By.xpath("//input[@value='Login']")).click();
        $$(By.xpath("//span[contains(.,'This field is required.')]")).shouldHaveSize(2);
        $("#id_username").setValue("dallas");
        $("#id_password").setValue("Password").pressEnter();
        $(By.xpath("//a[contains(.,'Logout')]")).waitUntil(appear, 5000).shouldBe(exist);
    }

}