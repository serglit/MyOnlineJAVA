package sl.paket.addressbook.tests;


import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;


public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreateTest() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createTestGroup(new GroupData("MynewGroup2", "HeaderForMyGroup", "FooterForMyGroup"));

    }

}
