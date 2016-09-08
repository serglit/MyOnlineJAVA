package sl.paket.addressbook.model;

public class ContactData {
    private int id= Integer.MAX_VALUE;
    private String firstName;
    private String lastName;
    private String addressName;
    private String phoneHome;
    private String phoneMobile;
    private String phoneWork;
    private String emailAddress;
    private String allPhones;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (addressName != null ? !addressName.equals(that.addressName) : that.addressName != null) return false;
        if (phoneHome != null ? !phoneHome.equals(that.phoneHome) : that.phoneHome != null) return false;
        if (phoneMobile != null ? !phoneMobile.equals(that.phoneMobile) : that.phoneMobile != null) return false;
        if (phoneWork != null ? !phoneWork.equals(that.phoneWork) : that.phoneWork != null) return false;
        if (emailAddress != null ? !emailAddress.equals(that.emailAddress) : that.emailAddress != null) return false;
        return allPhones != null ? allPhones.equals(that.allPhones) : that.allPhones == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (addressName != null ? addressName.hashCode() : 0);
        result = 31 * result + (phoneHome != null ? phoneHome.hashCode() : 0);
        result = 31 * result + (phoneMobile != null ? phoneMobile.hashCode() : 0);
        result = 31 * result + (phoneWork != null ? phoneWork.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressName='" + addressName + '\'' +
                ", phoneHome='" + phoneHome + '\'' +
                ", phoneMobile='" + phoneMobile + '\'' +
                ", phoneWork='" + phoneWork + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", allPhones='" + allPhones + '\'' +
                '}';
    }


    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withAddressName(String addressName) {
        this.addressName = addressName;
        return this;
    }

    public ContactData withPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
        return this;
    }
    public ContactData withPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
        return this;
    }
    public ContactData withPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
        return this;
    }
    public ContactData withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddressName() {return addressName;}
    public String getPhoneHome() {
        return phoneHome;
    }
    public String getPhoneMobile() {
        return phoneMobile;
    }
    public String getPhoneWork() {
        return phoneWork;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getAllPhones() {return allPhones;}

}

