package sl.paket.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;


public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreateTest() {

        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createTestGroup(new GroupData("MynewGroup2", "HeaderForMyGroup", "FooterForMyGroup"));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }

}
