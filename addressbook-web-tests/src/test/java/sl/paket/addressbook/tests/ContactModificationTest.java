package sl.paket.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by serglit on 31.07.16.
 */
public class ContactModificationTest extends TestBase {

   @BeforeMethod
   public void ensurePrecondContact() {
       app.getNavigationHelper().returnToContactPage();
       if (!app.getContactHelper().isThereAnyContact()) {
           app.getContactHelper().createTestContact(new ContactData("First", "Last", "ZYX", "123 Blossom ave", null, null, null, null));
       }
   }

    @Test
    public void testContactModification() {

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData("FirstName", "LastName", "ABC","23252 Highway street", null, null, null, null);
        app.getContactHelper().fillUpTextFields(contact, false);
        app.getContactHelper().submitForm();
        app.getNavigationHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();

        Comparator<? super ContactData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);

    }

}
