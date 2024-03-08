package tests;

import com.codeborne.selenide.Configuration;
import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

//import helpers.Attach;

//import static io.qameta.allure.Allure.step;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    /*@BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        /*Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }*/

        //@AfterEach
        //void addAttachments() {
        // Attach.screenshotAs("Last screenshot");
        // Attach.pageSource();
        //Attach.browserConsoleLogs();
        //Attach.addVideo();

        //}*/

        @Test
        void successfulRegistrationTest() {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
            $("#firstName").setValue("Aleksandr");
            $("#lastName").setValue("Exile");
            $("#userEmail").setValue("AleksandrExile@gmail.com");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("900112299");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOptionByValue("6");
            $(".react-datepicker__year-select").selectOption("1988");
            $(".react-datepicker__day--009:not(.react-datepicker__day--outside-month)").click();
            $("#subjectsInput").setValue("Arts").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("9.png");
            $("#currentAddress").setValue("www.Leningrad.spb.ru");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("Rajasthan")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Jaipur")).click();
            $("#submit").click();
        }
    }
