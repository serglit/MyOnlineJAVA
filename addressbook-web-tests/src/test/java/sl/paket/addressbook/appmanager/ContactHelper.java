package sl.paket.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sl.paket.addressbook.model.ContactData;
import sl.paket.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by serglit on 02.08.16.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public Contacts getContactCache() {
        return contactCache;
    }

    public void setContactCache(Contacts contactCache) {
        this.contactCache = contactCache;
    }

    public void fillUpTextFields(ContactData contactData, Boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("company"), contactData.getCompanyName());
        type(By.xpath("//div[@id='content']/form/textarea[1]"), contactData.getAddressName());
        type(By.name("home"), contactData.getPhoneHome());
        type(By.name("mobile"),contactData.getPhoneMobile());
        type(By.name("work"), contactData.getPhoneWork());
        type(By.name("email"), contactData.getEmailAddress());


        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
           // new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void newOpen() {
        click(By.linkText("add new"));
    }

    public void delete() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();
        returnToHomePage();
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void selectContactById(int id) {

        wd.findElement(By.cssSelector("input[id = '" + id + "']")).click();
    }

    public void initModify() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitForm() {
        click(By.cssSelector("input[value='Enter']"));
    }

    public void updateForm() {
        click(By.cssSelector("input[value='Update']"));
    }

    public void create(ContactData contact) {
        newOpen();
        fillUpTextFields(contact, true);
        submitForm();
        returnToHomePage();
        //contactCache = null;


    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initModify();
        fillUpTextFields(contact, false);
        updateForm();
        returnToHomePage();
       // contactCache = null;


    }

    public void deleteC(ContactData contact) {

        selectContactById(contact.getId());
        delete();
        returnToHomePage();
       // contactCache = null;

    }

    public boolean isThereAnyContact() {
        return isElementPresent(By.name("selected[]"));
    }

    private Contacts contactCache = null;


    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();

        List<WebElement> rows = wd.findElements(By.name("entry"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String nameLast = cells.get(1).getText();
            String nameFirst = cells.get(2).getText();
            String address = cells.get(3).getText();


            contactCache.add(new ContactData().withId(id).withLastName(nameLast).withFirstName(nameFirst)
                            .withAddressName(address).withGroup(""));
        }
            return new Contacts(contactCache);
        }

        public int count () {
            return wd.findElements(By.cssSelector("img[title='vCard")).size();
        }
    }
