package sl.paket.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;
import sl.paket.addressbook.model.Groups;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeleteTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().groups().size()==0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("TestGroup"));
        }
    }


    @Test
    public void testGroupDeletion() {

        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.goTo().groupPage();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() - 1));
        Groups after = app.db().groups();

        assertThat(after, equalTo(before.without(deletedGroup)));

       // for (int i=0; i < after.size();i++){ // 1 вариант проверки списка с использ.цикла
       //     Assert.assertEquals(before.get(i), after.get(i));
       // assertEquals(before, after); // 2 вариант проверки списков
        }


}


    

