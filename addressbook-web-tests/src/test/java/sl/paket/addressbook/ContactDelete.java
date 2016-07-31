package sl.paket.addressbook;

import org.testng.annotations.Test;

public class ContactDelete extends TestBase{

    
    @Test
    public void contactDeleteTest() {

        gotoHomepage();
        selectContact();
        deleteContact();
    }


}
