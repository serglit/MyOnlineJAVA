package sl.paket.addressbook.model;

public class ContactData {
    private  int id;
    private final String firstName;
    private final String lastName;
    private final String companyName;
    private final String addressName;
    private final String phoneNumber;
    private final String emailAddress;
    private final String workPhone;
    private String group;



    public ContactData(String firstName, String lastName, String companyName, String addressName, String phoneNumber, String emailAddress, String workPhone, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.addressName = addressName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.workPhone = workPhone;
        this.group = group;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddressName() {
        return addressName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {return emailAddress; }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}

