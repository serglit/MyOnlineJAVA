package sl.paket.addressbook.tests;


import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;
import sl.paket.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreateTest() {

        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("My_newGroup3");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(app.group().count(), equalTo(before.size() + 1));

        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
    }

    @Test
    public void groupBadCreateTest() {

        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("My_bad_Group3'");// '-special restricted symbol in group name
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();

        assertThat(after, equalTo(before));
    }

}



