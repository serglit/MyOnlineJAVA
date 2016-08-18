package sl.paket.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;


public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreateTest() {

        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        GroupData group = new GroupData().withName("MynewGroup2");
        app.group().create(group);
        List<GroupData> after = app.group().list();


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



