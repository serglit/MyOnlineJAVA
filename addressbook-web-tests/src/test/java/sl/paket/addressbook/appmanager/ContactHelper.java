package sl.paket.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import sl.paket.addressbook.model.ContactData;

/**
 * Created by serglit on 02.08.16.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
    super(wd);
    }

    public void fillUpTextFields(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("company"), contactData.getCompanyName());
        type(By.name("address"), contactData.getAddressName());
        type(By.name("home"), contactData.getPhoneNumber());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmailAddress());
    }

    public void newContactOpen() {
        click(By.linkText("add new"));
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();

    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitForm() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }
}
