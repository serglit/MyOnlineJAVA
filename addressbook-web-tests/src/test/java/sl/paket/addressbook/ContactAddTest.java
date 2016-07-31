package sl.paket.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactAddTest extends TestBase {

    @Test
    public void createContact() {

        gotoHomepage();
        newContactOpen();
        fillUpTextFields(new ContactData("First", "Last", "ZYX", "123 Blossom ave", "123-456-7890", "second@mail.org"));
        submitForm();
        gotoHomepage();
    }


}

