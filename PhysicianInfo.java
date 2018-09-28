import java.util.Date;

public class PhysicianInfo {

    String firstname;
    String lastname;
    String time;
    String date;

    public PhysicianInfo(String firstname, String lastname, String time, String date) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.time = time;
        this.date = date;
    }

    public PhysicianInfo() {
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
