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
       if (app.contact().al().size()==0) {
           app.goTo().contactPage();
           app.contact().create(new ContactData().withFirstName("First").withLastName( "Last")
                   .withAddressName("123 Blossom ave").withPhoneHome("123-3412-0987").withPhoneMobile("+7 987 2324 325432")
                   .withPhoneWork("80099991111").withEmailAddress("newemail@postoffice.com"));
       }

   }

    @Test
    public void testContactModification() {

        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact1 = new ContactData().withId(modifiedContact.getId()).withFirstName("First").withLastName( "Last")
                .withAddressName("123 Blossom ave").withPhoneHome("123-3412-0987").withPhoneMobile("+7 987 2324 325432")
                .withPhoneWork("80099991111").withEmailAddress("newemail@postoffice.com");
        app.goTo().contactPage();
        app.contact().modify(contact1);
        assertThat(app.db().contacts().size(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(modifiedContact)));
      //  assertThat(after, equalTo(before));
    }

}
