package sl.paket.addressbook.tests;

import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by serglit on 05.09.16.
 */
public class ContactPhoneTest extends TestBase {

    @Test
    public void testContactPhones(){
        app.goTo().contactPage();
        ContactData contact = app.contact().alll().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
       // assertThat(contact.getPhoneHome(), equalTo(cleaned(contactInfoFromEditForm.getPhoneHome())) );
       // assertThat(contact.getPhoneMobile(), equalTo(cleaned(contactInfoFromEditForm.getPhoneMobile()) ));
       // assertThat(contact.getPhoneWork(), equalTo(cleaned(contactInfoFromEditForm.getPhoneWork())) );
    }

    private String mergePhones(ContactData contact) {
       return Arrays.asList(contact.getPhoneHome(),contact.getPhoneMobile(),contact.getPhoneWork())
                .stream().filter((s)-> ! s.equals(""))
               .map(ContactPhoneTest::cleaned)
               .collect(Collectors.joining("\n"));

    }

       public static String  cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]","");
    }
}
