package subject;
public class Department {
    private String D_name;
    private String D_id;
    private String S_id;
    private String Name;
    public Department(String D_name,String D_id,String S_id,String Name){
        this.D_name=D_name;
        this.D_id=D_id;
        this.S_id=S_id;
        this.Name=Name;
    }
    public Department(){

    }
    public String getD_name() {
        return D_name;
    }
    public void setD_name(String d_name) {
        D_name = d_name;
    }
    public String getD_id() {
        return D_id;
    }
    public void setD_id(String d_id) {
        D_id = d_id;
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
       Name=name;
    }
}
