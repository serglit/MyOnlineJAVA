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
       app.goTo().contactPage();
       if (!app.contact().isThereAnyContact()) {
           app.contact().create(new ContactData().withFirstName("First").withLastName( "Last").withCompanyName("ZYX").withAddressName("123 Blossom ave"));
       }
   }

    @Test
    public void testContactModification() {

        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
        app.contact().select();
        app.contact().initModify();
        ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstName("Firstest").withLastName( "Lastest").withCompanyName("uweyrtw").withAddressName("345 Holiday street")
                .withEmailAddress("sdkjfhskdf@wityu.com").withPhoneNumber("234-9987888").withWorkPhone("987-12331231");
        app.contact().fillUpTextFields(contact, false);
        app.contact().submitForm();
        app.goTo().contactPage();
        List<ContactData> after = app.contact().list();

        Comparator<? super ContactData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);

    }

}
