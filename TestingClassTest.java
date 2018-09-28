import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

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
        $("input[value='Otsi']").click();
        sleep(2000);
        result = $("div[class='mob-table-wrap']");
        toObject(result);
    }

    public List<PhysicianInfo> toObject(SelenideElement result) {
        List<PhysicianInfo> physicianList = new ArrayList<PhysicianInfo>();
             String[] results = result.text().split("\n");
        for (String line:results) {
            String[] splitted = line.split(" ");
            if (splitted[1].equals("GÜNEKOLOOGI")) {
                PhysicianInfo info = new PhysicianInfo();
                info.setFirstname(splitted[4]);
                info.setLastname(splitted[3].substring(0,splitted[3].length()-1));
                info.setTime(splitted[6]);
                info.setDate(splitted[5]);
                physicianList.add(info);
            }
        }
        return physicianList;
    }
}

