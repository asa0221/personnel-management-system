package subject;

public class Staff {
    private String S_id;
    private String Name;
    private String Sex;
    private String D_id;
    private String Position;
    private String Age;
    private String Telephone;
    private String Email;
    private String Address;
    private String Password;
    private String State;

    public Staff(){};

    public Staff(String s_id, String name, String sex, String d_id, String position,
                 String age, String telephone, String email, String address, String password, String state) {
        S_id = s_id;
        Name = name;
        Sex = sex;
        D_id = d_id;
        Position = position;
        Age = age;
        Telephone = telephone;
        Email = email;
        Address = address;
        Password = password;
        State = state;
    }

    public String getS_id() {
        return S_id;
    }

    public void setS_id(String s_id) {
        S_id = s_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getD_id() {
        return D_id;
    }

    public void setD_id(String d_id) {
        D_id = d_id;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}