package sl.paket.addressbook.tests;

import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;

public class GroupDeleteTest extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAnyGroup()){
            app.getGroupHelper().createTestGroup(new GroupData("TestGroup", "HeaderTestGroup", "FooterTestyGroup"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().returnToGroupPage();
    }

}
    

