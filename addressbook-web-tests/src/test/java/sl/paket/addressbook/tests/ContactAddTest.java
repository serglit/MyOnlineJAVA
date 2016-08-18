package sl.paket.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactAddTest extends TestBase {

    @Test
    public void createContact() {

        app.goTo().contactPage();
        List<ContactData> before = app.contact().list();
        app.contact().newOpen();
        ContactData contact = new ContactData("First", "Last", "ZYX", "123 Blossom ave",
                null, null, null, "MynewGroup2");
        app.contact().fillUpTextFields(contact, true);
        app.contact().submitForm();
        app.goTo().contactPage();
        List<ContactData> after = app.contact().list();

        before.add(contact);
        Comparator<? super ContactData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);
    }
}
