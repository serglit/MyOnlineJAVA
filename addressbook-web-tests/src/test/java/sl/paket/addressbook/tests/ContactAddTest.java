package sl.paket.addressbook.tests;

import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;

public class ContactAddTest extends TestBase {

    @Test
    public void createContact() {

        app.getNavigationHelper().returnToContactPage();
        app.getContactHelper().newContactOpen();
        app.getContactHelper().fillUpTextFields(new ContactData("First", "Last", "ZYX", "123 Blossom ave", "123-456-7890", "second@mail.org", "098-234-4667","MynewGroup3"),true);
        app.getContactHelper().submitForm();
        app.getNavigationHelper().returnToContactPage();
    }

}

