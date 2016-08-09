package sl.paket.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;

import java.util.List;


public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreateTest() {

        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().createTestGroup(new GroupData("MynewGroup2", "HeaderForMyGroup", "FooterForMyGroup"));
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
