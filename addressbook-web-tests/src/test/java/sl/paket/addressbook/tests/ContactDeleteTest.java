package sl.paket.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTest extends TestBase{

    
    @Test
    public void contactDeleteTest() {

        app.getNavigationHelper().returnToContactPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().returnToContactPage();
    }
}
