package sl.paket.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by serglit on 31.07.16.
 */
public class GroupModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions(){

       app.goTo().groupPage();
       if (!app.group().isThereAnyGroup()) {
           app.group().create(new GroupData().withName("TestGroup"));
       }
   }


    @Test
    public void testGroupModification() {

        List<GroupData> before = app.group().list();
        int index = before.size()-1;
        GroupData group = new GroupData().withId(before.get(index).getId())
                .withName("MynewGroup2").withHeader("Header_Group").withFooter("Footer_Group");
        app.group().modify(index, group);
        List<GroupData> after = app.group().list();

        Assert.assertEquals(after.size(), before.size());


        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> ById = (g1,g2)-> Integer.compare(g1.getId(),g2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before,after);
    }

}
