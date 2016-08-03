package sl.paket.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by serglit on 31.07.16.
 */
public class NavigationHelper extends HelperBase{

    public NavigationHelper(FirefoxDriver wd)
    {
       super(wd);
    }
    public void goToGroupPage() {
        click(By.linkText("groups"));
    }

    public void returnToContactPage() {
        click(By.linkText("home"));
    }
}
