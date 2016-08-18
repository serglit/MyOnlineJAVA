package sl.paket.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sl.paket.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serglit on 02.08.16.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
    super(wd);
    }

    public void fillUpTextFields(ContactData contactData, Boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("company"), contactData.getCompanyName());
        type(By.name("address"), contactData.getAddressName());
        type(By.name("home"), contactData.getPhoneNumber());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmailAddress());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }else {
        Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }
    public void newOpen() {
        click(By.linkText("add new"));
    }

    public void delete() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();

    }

    public void select() {
        click(By.name("selected[]"));
    }

    public void initModify() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitForm() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void create(ContactData contact) {
        newOpen();
        fillUpTextFields(contact,true);
        submitForm();
    }
    public boolean isThereAnyContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
        for (WebElement element : elements) {
            String name = element.getTagName();
            String lName = element.getText();
            String compName = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            ContactData contact = new ContactData().withId(id).withFirstName(name).withLastName(lName).withCompanyName(compName);
            contacts.add(contact);
        }
        return contacts;
    }
}
