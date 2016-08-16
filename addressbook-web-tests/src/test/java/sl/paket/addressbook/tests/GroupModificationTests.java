package sl.paket.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by serglit on 31.07.16.
 */
public class GroupModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions(){

       app.getNavigationHelper().goToGroupPage();
       if (!app.getGroupHelper().isThereAnyGroup()) {
           app.getGroupHelper().createTestGroup(new GroupData("TestGroup", "HeaderTestGroup", "FooterTestyGroup"));
       }
   }


    @Test
    public void testGroupModification() {

        List<GroupData> before = app.getGroupHelper().getGroupList();
        int index = before.size()-1;
        GroupData group = new GroupData(before.get(index).getId(),"MynewGroup2", "Header_Group", "Footer_Group");
        app.getGroupHelper().modifyGroup(index, group);
        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size());


        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> ById = (g1,g2)-> Integer.compare(g1.getId(),g2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before,after);
    }

}
