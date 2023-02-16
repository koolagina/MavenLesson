package HW6;

import org.example.HW6.MainMenu;
import org.example.HW6.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainPageTest extends AbstractTest{

    @Test
    void mainMenuNavigateTest(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clicknauka()
                .clickabit()
                .clicksotrudniku()
                .clickstudent()
                .clickabit();
        Assertions.assertEquals("https://www.vstu.ru/abit/",getWebDriver().getCurrentUrl());
    }

    @Test
    void mainMenuWelcomeTest(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu.clickWelcome();
        Assertions.assertEquals("https://welcome.vstu.ru/",getWebDriver().getCurrentUrl());
    }

    @Test
    void searchTest(){
        SearchPage searchPage = new SearchPage(getWebDriver());
        searchPage.toSearch("кравец");
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://www.vstu.ru/search"));
        Assertions.assertDoesNotThrow(() ->searchPage.takeItem(9));

    }

}
