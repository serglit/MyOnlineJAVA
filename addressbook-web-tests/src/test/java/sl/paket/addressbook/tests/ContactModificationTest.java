package sl.paket.addressbook.tests;

import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;

/**
 * Created by serglit on 31.07.16.
 */
public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification(){
        app.getNavigationHelper().returnToContactPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillUpTextFields(new ContactData("FirstName", "LastName", "ABC", "123 NewGampshir", "123-4560000","098-234-34-45", "third@mail.com", null),false);
        app.getContactHelper().submitForm();
    }

}
