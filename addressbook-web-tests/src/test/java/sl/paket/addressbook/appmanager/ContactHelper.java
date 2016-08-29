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

    public void fillUpTextFields(ContactData contactData, Boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("company"), contactData.getCompanyName());
        type(By.name("address"), contactData.getAddressName());
 //       type(By.name("home"), contactData.getPhoneNumber());
 //       type(By.name("work"), contactData.getWorkPhone());
 //       type(By.name("email"), contactData.getEmailAddress());


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
        returnToHomePage();
    }
    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void selectContactById(int id) {

            wd.findElement(By.cssSelector("input[id = '"+ id +"']")).click();
    }

    public void initModify() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }
    public void submitForm() { click(By.name("submit"));
    }
    public void updateForm() {click(By.name("Update"));
    }

    public void create(ContactData contact) {
        newOpen();
        fillUpTextFields(contact,true);
        submitForm();
        returnToHomePage();

    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initModify();
        fillUpTextFields(contact, false);
        updateForm();
        returnToHomePage();

    }
    public void deleteC(ContactData contact) {

        selectContactById(contact.getId());
        delete();
        returnToHomePage();
    }

  public boolean isThereAnyContact() {
        return isElementPresent(By.name("selected[]"));
  }



    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements) {
            String name = element.getText();
            String lName = element.getText();
            String compName = element.getText();
            String address = element.getText();
            String group = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            contacts.add(new ContactData().withId(id).withFirstName(name).withLastName(lName).withCompanyName(compName)
                    .withAddressName(address).withGroup(group));
        }
        return contacts;
}
}
