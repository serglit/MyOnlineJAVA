package sl.paket.addressbook;


import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreateTest() {

        goToGroupPage();
        initGroupCreation();
        fillupGroupForm(new GroupData("MynewGroup2", "HeaderForMyGroup", "FooterForMyGroup"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
