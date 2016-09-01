package sl.paket.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;
import sl.paket.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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

        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId())
                .withName("MynewGroup2").withHeader("Header_Group").withFooter("Footer_Group");
        app.group().modify(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }

}
