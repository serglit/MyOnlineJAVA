package sl.paket.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactAddTest extends TestBase {

    @Test
    public void createContact() {

        gotoHomepage();
        newContactOpen();
        fillUpTextFields(new ContactData("First", "Last", "ZYX", "123 Blossom ave", "123-456-7890", "second@mail.org"));
        submitForm();
        gotoHomepage();
    }


    private void submitForm() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillUpTextFields(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(contactData.getCompanyName());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactData.getAddressName());
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(contactData.getPhoneNumber());
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmailAddress());
    }

    private void newContactOpen() {
        wd.findElement(By.linkText("add new")).click();
    }

    private void gotoHomepage() {
        wd.findElement(By.id("content")).click();
        wd.findElement(By.linkText("home")).click();
    }


    }

