package sl.paket.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;
import sl.paket.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by serglit on 31.07.16.
 */
public class ContactModificationTest extends TestBase {

   @BeforeMethod
   public void ensurePrecondContact() {
       app.goTo().contactPage();
       if (app.contact().all().size()==0) {
           app.contact().create(new ContactData().withFirstName("First").withLastName( "Last").withCompanyName("ZYX")
                   .withAddressName("123 Blossom ave").withPhoneHome("123-3412-0987").withPhoneMobile("+7 0987 2324 325432")
                   .withPhoneWork("80099991111").withEmailAddress("newemail@postoffice.com").withGroup("My_newGroup3"));
       }
   }

    @Test
    public void testContactModification() {

        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()). withFirstName("Firstest"). withLastName( "Lastest").withCompanyName("uweyrtw").withAddressName("345 Holiday street");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }

}
