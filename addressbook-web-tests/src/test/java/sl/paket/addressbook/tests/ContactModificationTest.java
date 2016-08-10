package sl.paket.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;
import sl.paket.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by serglit on 31.07.16.
 */
public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification(){
        app.getNavigationHelper().returnToContactPage();

        if (! app.getContactHelper().isThereAnyContact()) {
            app.getContactHelper().createTestContact(new ContactData(0,"First", "Last", "ZYX", "123 Blossom ave", null, null, null,null));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData(0,"FirstName", "LastName", "ABC",null, null,null, null, null);
        app.getContactHelper().fillUpTextFields(contact,false);
        List<ContactData> after = app.getContactHelper().getContactList();
        app.getContactHelper().submitForm();

        Comparator<? super ContactData> ById = (c1, c2)-> Integer.compare(c1.getId(),c2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before,after);

    }

}
