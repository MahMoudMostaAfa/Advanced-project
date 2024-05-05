import java.util.Date;

public abstract class  User {
    private String id ;
    private String firstName;
    private String lastName;
    private String email ;
    private String password ;
    private String phone ;
    private String image ;
    private boolean gender ;
    private String country ;
    Date joinedAt ;
    public User(){
Online_Course_Site.incrementTotalUsersnum();
    }
    public User(String firstName, String lastName, String email, String password, String phone, String image, boolean gender, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.image = image;
        this.gender = gender;
        this.country = country;
        this.joinedAt = new Date();
        this.id = new Date().toString();
        Online_Course_Site.incrementTotalUsersnum();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
