package sl.paket.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;

import java.util.List;

public class GroupDeleteTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        app.goTo().groupPage();
        if (!app.group().isThereAnyGroup()) {
            app.group().create(new GroupData().withName("TestGroup"));
        }
    }


    @Test
    public void testGroupDeletion() {
        app.goTo().groupPage();
        if (! app.group().isThereAnyGroup()){
            app.group().create(new GroupData().withName("TestGroup"));
        }
        List<GroupData> before = app.group().list();
        int index = before.size()-1;
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
       // for (int i=0; i < after.size();i++){ // 1 вариант проверки списка с использ.цикла
       //     Assert.assertEquals(before.get(i), after.get(i));
        Assert.assertEquals(before, after); // 2 вариант проверки списков
        }


}


    

