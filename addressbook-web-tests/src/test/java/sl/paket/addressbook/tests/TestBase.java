package sl.paket.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import sl.paket.addressbook.appmanager.ApplicationManager;

/**
 * Created by serglit on 29.07.16.
 */
public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }


}
