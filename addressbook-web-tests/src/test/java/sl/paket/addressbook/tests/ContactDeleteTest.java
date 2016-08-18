package sl.paket.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;

public class ContactDeleteTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondContact() {
        app.goTo().contactPage();
        if (!app.contact().isThereAnyContact()) {
            app.contact().create(new ContactData().withFirstName("First").withLastName("Last").withCompanyName("ZYX").withAddressName("123 Blossom ave"));
        }
    }
    
    @Test
    public void contactDeleteTest() {

        app.contact().select();
        app.contact().delete();
        app.goTo().contactPage();
    }
}
