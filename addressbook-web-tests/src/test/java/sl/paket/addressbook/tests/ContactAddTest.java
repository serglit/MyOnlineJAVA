package sl.paket.addressbook.tests;

import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;
import sl.paket.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactAddTest extends TestBase {

    @Test
    public void createContact() {

        app.goTo().contactPage();
        Contacts before = app.contact().alll();
        ContactData contact = new ContactData()
                .withFirstName("First").withLastName("Last")
                .withAddressName("123 Blossom ave")
                .withPhoneHome("981283919")
                .withPhoneMobile("+798728734812341")
                .withPhoneWork("800992929393")
                .withEmailAddress("newemail@postoffice.com");

        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact().alll();
         assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
         assertThat(after, equalTo(before.withAdded(contact)));
    }

    @Test (enabled = false)
    public void createBadContact() {

        app.goTo().contactPage();
        Contacts before = app.contact().alll();
        ContactData contact = new ContactData()
                .withFirstName("First.").withLastName("Last")
                .withAddressName("123 Blossom ave")
                .withPhoneHome("981283919")
                .withPhoneMobile("+798728734812341")
                .withPhoneWork("800992929393")
                .withEmailAddress("newemail@postoffice.com");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact().alll();
        assertThat(after, equalTo(before.withAdded(contact)));
    }

    }






