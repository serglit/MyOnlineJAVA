package sl.mynewjob.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import sl.mynewjob.mantis.appmanager.ApplicationManager;




public class TestBase {

    protected static ApplicationManager app;
    @BeforeSuite
    public void setUp() throws Exception {
        app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));
        app.init();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


}