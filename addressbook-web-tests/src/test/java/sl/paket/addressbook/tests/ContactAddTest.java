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
        ContactData contact = new ContactData(0, "First", "Last", "ZYX", "123 Blossom ave",
                "123-456-7890", "second@mail.org", "098-234-4667", "MynewGroup3");
        app.getContactHelper().newContactOpen();
        app.getContactHelper().fillUpTextFields(contact, true);

        app.getContactHelper().submitForm();
        List<ContactData> after = app.getContactHelper().getContactList();
        app.getNavigationHelper().returnToContactPage();


        Comparator<? super ContactData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);
    }
}
