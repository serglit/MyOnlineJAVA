package sl.paket.addressbook.tests;

import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;

public class ContactDeleteTest extends TestBase{

    
    @Test
    public void contactDeleteTest() {

        app.getNavigationHelper().returnToContactPage();
        if (! app.getContactHelper().isThereAnyContact()) {
            app.getContactHelper().createTestContact(new ContactData(1,"First", "Last", "ZYX", "123 Blossom ave", null, null, null,null));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().returnToContactPage();
    }
}
