package sl.paket.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;
import sl.paket.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactAddTest extends TestBase {

    @Test
    public void createContact() {

        app.getNavigationHelper().returnToContactPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().newContactOpen();
        ContactData contact = new ContactData("First", "Last", "ZYX", "123 Blossom ave",
                null, null, null, "MynewGroup2");
        app.getContactHelper().fillUpTextFields(contact, true);
        app.getContactHelper().submitForm();
        app.getNavigationHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();

        before.add(contact);
        Comparator<? super ContactData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);
    }
}
