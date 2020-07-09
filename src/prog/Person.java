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
    // creates a new person, gets the details and put in accordingly
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
    // setting an ID to the person
    public void setId(String id) {
        this.id = id;
    }
    // setting first name for the person
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    // return the gender for the person
    public Gender getGender() {
        return gender;
    }
    // setting the gender for the person
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    // setting the address
    public void setAddress(String address) {
        this.address = address;
    }
    // setting the phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    // setting the email
    public void setEmail(String email) {
        this.email = email;
    }

    // set the last name of the person
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // setting the password of the person in order to connect to the project
    public void setPassword(String password) {
        this.password = password;
    }
    // returns the ID for the person
    public String getId() {
        return id;
    }
    // returns the address for the person
    public String getAddress() {
        return address;
    }
    // get the phone number of the person
    public String getPhoneNumber() {
        return phoneNumber;
    }
    // get the email
    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

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
    // setting the access lever for the person, whether he is a client, worker or manager
    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    // takes all the parameters for person and convert it to string
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
