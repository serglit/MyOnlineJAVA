package sl.paket.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;

public class GroupDeleteTest extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAnyGroup()){
            app.getGroupHelper().createTestGroup(new GroupData("TestGroup", "HeaderTestGroup", "FooterTestyGroup"));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);
    }

}
    

