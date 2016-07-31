package sl.paket.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTest extends TestBase{

    
    @Test
    public void contactDeleteTest() {

        app.gotoHomepage();
        app.selectContact();
        app.deleteContact();
    }


}
