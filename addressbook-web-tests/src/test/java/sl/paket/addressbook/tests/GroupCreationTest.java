package sl.paket.addressbook.tests;


import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;


public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreateTest() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillupGroupForm(new GroupData("MynewGroup2", "HeaderForMyGroup", "FooterForMyGroup"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

}
