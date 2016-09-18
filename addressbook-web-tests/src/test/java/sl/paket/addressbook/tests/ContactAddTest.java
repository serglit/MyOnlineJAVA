package sl.paket.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sl.paket.addressbook.model.ContactData;
import sl.paket.addressbook.model.Contacts;
import sl.paket.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactAddTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromXML() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
          /*  String[] split = line.split(";");
            list.add(new Object[] {new ContactData().withFirstName(split [0])
                    .withLastName(split [1])
                    .withAddressName(split [2])
                    .withEmailAddress(split[3])
                    .withPhoneHome(split [4])}); */
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactData.class);
            List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
            return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();

        }
    }
    @DataProvider
    public Iterator<Object[]> validContactsFromJSON() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
            }.getType());
            return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();

        }
    }
    @Test (dataProvider = "validContactsFromJSON")
     public void testContactCreation(ContactData contact) {
        app.goTo().contactPage();
        Contacts before = app.contact().al();
        app.contact().create(contact);
        Contacts after = app.contact().al();
        assertThat(after, equalTo(
                          before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }



    @Test (enabled = true)
    public void createContact() {

        app.goTo().contactPage();
        Contacts before = app.db().contacts();
        File photo = new File("src/test/resources/woof.gif");
        ContactData contact = new ContactData()
                .withFirstName("First")
                .withLastName("Last")
                .withAddressName("123 Blossom ave")
                .withPhoneHome("981283919")
                .withPhoneMobile("+798728734812341")
                .withPhoneWork("800992929393")
                .withEmailAddress("newemail@postoffice.com")
                .withPhoto(photo);

        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.db().contacts();
         assertThat(after, equalTo(
                 before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));


         assertThat(after, equalTo(before.withAdded(contact)));
    }

    @Test (enabled = false)
    public void createBadContact() {

        app.goTo().contactPage();
        Contacts before = app.contact().alll();
        ContactData contact = new ContactData()
                .withFirstName("First.").withLastName("Last")
                .withAddressName("123 Blossom ave")
                .withPhoneHome("981283919")
                .withPhoneMobile("+798728734812341")
                .withPhoneWork("800992929393")
                .withEmailAddress("newemail@postoffice.com");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact().alll();
        assertThat(after, equalTo(before.withAdded(contact)));
    }



    @Test (enabled = false)
    public void testCurrentDir() {
      File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/woof.gif");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());

    }

    }






