package prog;

import java.io.Serializable;

public class Person implements Serializable {
    protected String id;
    protected String address;
    protected String phoneNumber;
    protected Gender gender;
    protected String email;
    protected String firstName;
    protected String lastName;
    protected String password;
    protected AccessLevel accessLevel;
    private String userName;

    // the constructor for person, gets all the details for a person and creates a new person
    public Person(String id, String address, Gender gender, String email, String firstName, String lastName, String password, AccessLevel accessLevel, String userName) {
        this.id = id;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.accessLevel = accessLevel;
        this.userName = userName;
    }
    // set ID
    public void setId(String id) {
        this.id = id;
    }
    // set first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    // return the gender for person
    public Gender getGender() {
        return gender;
    }
    // set the gender for the person
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    // set the address
    public void setAddress(String address) {
        this.address = address;
    }
    // set the phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    // set the email for the person
    public void setEmail(String email) {
        this.email = email;
    }

    // set the last name for the person
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // set the password for the person
    public void setPassword(String password) {
        this.password = password;
    }
    // get the ID for the person
    public String getId() {
        return id;
    }
    // get the address for the person
    public String getAddress() {
        return address;
    }
    // get the phone number for the person
    public String getPhoneNumber() {
        return phoneNumber;
    }
    // get the email for the person
    public String getEmail() {
        return email;
    }
    // get the first name for the person
    public String getFirstName() {
        return firstName;
    }
    // get the last name for the person
    public String getLastName() {
        return lastName;
    }
    // returns the password
    public String getPassword() {
        return password;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    // transfers the details of the person to string
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", accessLevel=" + accessLevel +
                ", userName='" + userName + '\'' +
                '}';
    }
}
