package subject;

import java.sql.Date;

public class Attendance_data {
    private String S_id;
    private Date Time;
    private String Attendance;
    private String D_name;
    public Attendance_data(String S_id, Date Time, String Attendance, String D_name){
        this.S_id=S_id;
        this.Time=Time;
        this.Attendance=Attendance;
        this.D_name=D_name;
    }
    public String getS_id() {
        return S_id;
    }
    public void setS_id(String s_id) {
        S_id = s_id;
    }
    public Date getTime() {
        return Time;
    }
    public void setTime(Date time) {
        Time = time;
    }
    public String getAttendance() {
        return Attendance;
    }
    public void setAttendance(String attendance) {
        Attendance = attendance;
    }
    public String getD_name() {
        return D_name;
    }
    public void setD_name(String d_name) {
        D_name = d_name;
    }
}
