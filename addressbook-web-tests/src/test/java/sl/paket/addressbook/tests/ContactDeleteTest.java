package sl.paket.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;

public class ContactDeleteTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondContact() {
        app.getNavigationHelper().returnToContactPage();
        if (!app.getContactHelper().isThereAnyContact()) {
            app.getContactHelper().createTestContact(new ContactData("First", "Last", "ZYX", "123 Blossom ave", null, null, null, null));
        }
    }
    
    @Test
    public void contactDeleteTest() {

        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().returnToContactPage();
    }
}
