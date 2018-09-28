import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

class TestingClassTest {

    SelenideElement registratuuriVorm = $(By.xpath("//*[@id=\"registratuurIframe\"]"));
    ElementsCollection radioButtons = $$("input[name='search_location']");
    SelenideElement result;

    @Test
    public void ScanTimes() {
        open("https://www.medicum.ee/registratuur/");
        $(By.xpath("//*[@id=\"registratuurIframe\"]")).scrollTo();
        switchTo().frame("registratuurIframe");
        $(radioButtons.get(0)).click();
        $("select[name='search_group']").click();
        $("select[name='search_group']").selectOptionByValue("E1");
        $("select[name='search_service']").click();
        $("select[name='search_service']").selectOptionByValue("EG");
        //$("select[name='search_group']").selectOptionByValue("AKU");
        $("input[value='Otsi']").click();
        sleep(2000);
        result = $("div[class='mob-table-wrap']");
        System.out.println(result.text());
    }
}

