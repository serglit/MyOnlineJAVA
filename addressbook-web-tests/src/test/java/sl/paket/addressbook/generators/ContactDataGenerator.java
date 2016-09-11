package sl.paket.addressbook.generators;

import sl.paket.addressbook.model.ContactData;
import sl.paket.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serglit on 10.09.16.
 */
public class ContactDataGenerator {

        public static void main(String[] args) throws IOException {
            int count = Integer.parseInt(args[0]);
            File file = new File(args[1]);

            List<ContactData> contacts = generateContacts(count);
            save(contacts, file);
        }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName(),  contact.getAddressName(),
                    contact.getEmailAddress(), contact.getPhoneHome(), contact.getPhoneMobile(),contact.getPhoneWork()));
        }
    writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for (int i=0;i< count; i++) {
         contacts.add(new ContactData().withLastName(String.format("Last %s",i)).withFirstName(String.format("First %s", i))
                 .withAddressName(String.format("Address %s", i))
                .withEmailAddress(String.format("email%s@office.com",i)).withPhoneHome(String.format("111-222-111 %s",i))
                 .withPhoneMobile(String.format("888-333-111%s",i))
                .withPhoneWork(String.format("999-111-22%s",i)));
        }
        return contacts;
    }
}
