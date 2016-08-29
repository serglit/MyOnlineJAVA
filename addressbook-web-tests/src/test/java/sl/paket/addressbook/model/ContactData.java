package sl.paket.addressbook.model;

public class ContactData {
    private  int id= Integer.MAX_VALUE;
    private  String firstName;
    private  String lastName;
    private  String companyName;
    private  String addressName;
    private  String group;


    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", addressName='" + addressName + '\'' +
                ", group='" + group + '\'' +
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

    public ContactData withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (addressName != null ? !addressName.equals(that.addressName) : that.addressName != null) return false;
        return group != null ? group.equals(that.group) : that.group == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (addressName != null ? addressName.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }

    public ContactData withAddressName(String addressName) {
        this.addressName = addressName;
        return this;
    }


    public ContactData withGroup(String group) {
        this.group = group;
       return this;
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

    public String getGroup() {
        return group;
}

    public int getId() {
        return id;
    }

}

