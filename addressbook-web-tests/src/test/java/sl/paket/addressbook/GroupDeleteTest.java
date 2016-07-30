package sl.paket.addressbook;

import org.testng.annotations.Test;

public class GroupDeleteTest extends TestBase {

    @Test
    public void testGroupDeletion() {
        goToGroupPage();
        selectGroup();
        deleteSelectedGroup();
        returnToGroupPage();
    }

}
    

