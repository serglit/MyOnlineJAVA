package sl.paket.addressbook.tests;

import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;

/**
 * Created by serglit on 31.07.16.
 */
public class GroupModificationTests extends TestBase{
    @Test
    public void testGroupModification(){

        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAnyGroup()){
            app.getGroupHelper().createTestGroup(new GroupData("TestGroup", "HeaderTestGroup", "FooterTestyGroup"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillupGroupForm(new GroupData("MynewGroup3", "Header_Group", "Footer_Group"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
