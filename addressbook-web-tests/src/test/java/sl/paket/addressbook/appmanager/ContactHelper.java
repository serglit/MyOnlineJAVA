package sl.paket.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sl.paket.addressbook.model.ContactData;
import sl.paket.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by serglit on 02.08.16.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void fillUpTextFields(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddressName());
        type(By.name("home"), contactData.getPhoneHome());
        type(By.name("email"), contactData.getEmailAddress());
     //   type(By.name("mobile"),contactData.getPhoneMobile());
     //   type(By.name("work"), contactData.getPhoneWork());
     //   attach(By.name("photo"),contactData.getPhoto());


   //     if (creation) {
   //         new Select(wd.findElement(By.name("new_group"))).selectByValue(contactData.getGroup());
   //     } else {
   //         Assert.assertFalse(isElementPresent(By.name("new_group")));
   //     }
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
        fillUpTextFields(contact);
        submitForm();
        contactCache = null;
        returnToHomePage();

    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initModify();
        fillUpTextFields(contact);
        updateForm();
        returnToHomePage();
        //contactCache = null;
    }

    public void deleteC(ContactData contact) {

        selectContactById(contact.getId());
        delete();
        contactCache = null;
        returnToHomePage();

    }

    public boolean isThereAnyContact() {
        return isElementPresent(By.name("selected[]"));
    }

    private Contacts contactCache = null;

    public Contacts al() {
        Contacts contacts = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String nameLast = cells.get(1).getText();
            String nameFirst = cells.get(2).getText();
            String address = cells.get(3).getText();
            String email = cells.get(4).getText();
            String phone = cells.get(5).getText();
            contacts.add(new ContactData()
                    .withId(id)
                    .withLastName(nameLast)
                    .withFirstName(nameFirst)
                    .withAddressName(address)
                    .withEmailAddress(email)
                    .withPhoneHome(phone));
        }
        return new Contacts(contacts);
    }

    public Contacts alll() {
         Contacts contacts = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String nameLast = cells.get(1).getText();
            String nameFirst = cells.get(2).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String  allPhones = cells.get(5).getText();
            contacts.add(new ContactData()
                    .withId(id)
                    .withLastName(nameLast)
                    .withFirstName(nameFirst)
                    .withAddressName(address)
                    .withAllEmailAddress(allEmails)
                    .withAllPhones(allPhones));
        }
        return new Contacts(contacts);
    }

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
            String email = cells.get(4).getText();
            String  phone = cells.get(5).getText();
            // String[] phones = cells.get(5).getText().split("\n");
           // String  allPhones = cells.get(5).getText();


            contactCache.add(new ContactData()
                    .withId(id)
                    .withLastName(nameLast)
                    .withFirstName(nameFirst)
                    .withAddressName(address)
                    .withEmailAddress(email)
                    .withPhoneHome(phone));
                   // .withPhoneMobile(phones[1])
                   // .withPhoneWork(phones[2]));
                   // .withAllPhones(allPhones));
        }
             return new Contacts(contactCache);
        }

        public int count () {
            return wd.findElements(By.cssSelector("img[title='vCard")).size();
        }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getText();
        String email = wd.findElement(By.name("email")).getAttribute("value");
       // String email2 = wd.findElement(By.name("email2")).getAttribute("value");
       // String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
       // wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
                .withAddressName(address)
                .withEmailAddress(email)
                .withPhoneHome(home).withPhoneMobile(mobile).withPhoneWork(work);
    }

    private void initContactModificationById(int id) {
      /*- 1ый вариант поиска элемента на странице

        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells= row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click(); */

       /* - 2ой вариант поиска с использованием XPath
        wd.findElement (By.xpath(String.format("//input[@value='%s']/../../td[8]/a",id))).click();

        - 3ий вариант поиска с использованием XPath
        wd.findElement (By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a",id))).click();
         */
        //- 4ый вариант
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();





    }
}
