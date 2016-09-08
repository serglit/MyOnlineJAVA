package sl.paket.addressbook.tests;

import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by serglit on 05.09.16.
 */
public class ContactPhoneAddressEmailTest extends TestBase {

    @Test
    public void testContactPhones(){
        app.goTo().contactPage();
        ContactData contact = app.contact().alll().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(),  equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAddressName(), equalTo(contactInfoFromEditForm.getAddressName()));
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
       // assertThat(contact.getPhoneHome(), equalTo(cleaned(contactInfoFromEditForm.getPhoneHome())) );
       // assertThat(contact.getPhoneMobile(), equalTo(cleaned(contactInfoFromEditForm.getPhoneMobile()) ));
       // assertThat(contact.getPhoneWork(), equalTo(cleaned(contactInfoFromEditForm.getPhoneWork())) );
    }

    private String mergePhones(ContactData contact) {
       return Arrays.asList(contact.getPhoneHome(),contact.getPhoneMobile(),contact.getPhoneWork())
                .stream().filter((s)-> ! s.equals(""))
               .map(ContactPhoneAddressEmailTest::cleaned)
               .collect(Collectors.joining("\n"));

    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmailAddress(), contact.getEmailAddress1(), contact.getEmailAddress2())
                .stream().filter((e)-> ! e.equals(""))
                .map(ContactPhoneAddressEmailTest::cleaned1)
                .collect(Collectors.joining("\n"));

    }

    private static  String cleaned1(String emails ) {
       return emails.replaceAll("\\s","");
    }

    public static String  cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]","");
    }

}
