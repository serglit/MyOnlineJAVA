package sl.paket.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreateTest() {

        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("MynewGroup2", "HeaderForMyGroup", "FooterForMyGroup");
        app.getGroupHelper().createTestGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();


    //    Assert.assertEquals(after.size(), before.size() + 1);
   //     int max = 0;
   //     for (GroupData g : after){    1  способ сравнения
   //         if(g.getId()>max){
   //             max=g.getId();
   //         }
        //    group.setId(after.stream().max((o1,o2)-> Integer.compare(o1.getId(),o2.getId())).get().getId());
        before.add(group);
        Comparator<? super GroupData> ById = (g1, g2)-> Integer.compare(g1.getId(),g2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before,after);
    }

    }



