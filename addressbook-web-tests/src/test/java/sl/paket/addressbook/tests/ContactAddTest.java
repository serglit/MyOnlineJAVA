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
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("First").withLastName("Last").withAddressName("123 Blossom ave").withGroup("MynewGroup2");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()+1));
      //  Contacts after = app.contact().all();
     // assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    //  assertThat(after, equalTo(before.withAdded(contact)));
    }

    @Test (enabled = true)
    public void createBadContact() {

        app.goTo().contactPage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("'First").withLastName("Last").withAddressName("123 Blossom ave").withGroup("My_newGroup3");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
        assertThat(after, equalTo(before.withAdded(contact)));
    }

    }






