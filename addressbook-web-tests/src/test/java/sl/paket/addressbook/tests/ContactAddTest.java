package sl.paket.addressbook.tests;

import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;

public class ContactAddTest extends TestBase {

    @Test
    public void createContact() {

        app.gotoHomepage();
        app.newContactOpen();
        app.fillUpTextFields(new ContactData("First", "Last", "ZYX", "123 Blossom ave", "123-456-7890", "second@mail.org"));
        app.submitForm();
        app.gotoHomepage();
    }


}

