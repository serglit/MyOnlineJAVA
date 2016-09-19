package sl.paket.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import sl.paket.addressbook.appmanager.ApplicationManager;
import sl.paket.addressbook.model.GroupData;
import sl.paket.addressbook.model.Groups;

import java.util.stream.Collectors;

import static java.lang.System.getProperty;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by serglit on 29.07.16.
 */
public class TestBase {

    protected static ApplicationManager app;

    @BeforeSuite
    public void setUp() throws Exception {
        app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    public void verifyGroupListInUI() {
        if (Boolean.getBoolean("verifyUI") ) {
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
                    .collect(Collectors.toSet())));
        }
    }
}