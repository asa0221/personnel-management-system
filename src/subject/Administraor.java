package subject;

public class Administraor {
    private String Administraor_id;
    private String Administraor_passward;
    private String Administraor_name;

    public Administraor(){

    }

    public Administraor(String administraor_id, String administraor_passward, String administraor_name) {
        Administraor_id = administraor_id;
        Administraor_passward = administraor_passward;
        Administraor_name = administraor_name;
    }

    public Administraor(String Adminisitraor_id, String Administraor_password){
        this.Administraor_id=Adminisitraor_id;
        this.Administraor_passward=Administraor_password;
    }

    public String getAdministraor_id() {
        return Administraor_id;
    }

    public void setAdministraor_id(String administraor_id) {
        Administraor_id = administraor_id;
    }

    public String getAdministraor_passward() {
        return Administraor_passward;
    }

    public void setAdministraor_passward(String administraor_passward) {
        Administraor_passward = administraor_passward;
    }

    public String getAdministraor_name() {
        return Administraor_name;
    }

    public void setAdministraor_name(String administraor_name) {
        Administraor_name = administraor_name;
    }
}
