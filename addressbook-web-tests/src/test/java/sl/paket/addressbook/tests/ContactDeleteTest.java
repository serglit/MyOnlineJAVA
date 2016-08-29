package sl.paket.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;
import sl.paket.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactDeleteTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondContact() {
        app.goTo().contactPage();
        if (app.contact().all().size()==0) {
            app.contact().create(new ContactData().withFirstName("First").withLastName("Last").withCompanyName("ZYX").withAddressName("123 Blossom ave")
            .withGroup("MynewGroup2"));
        }
    }
    
    @Test
    public void contactDeleteTest() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().deleteC(deletedContact);

        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()-1));
        assertThat(after, equalTo(before.without(deletedContact)));
    }




}
