package subject;

public class Salary {
    private String Year;
    private String Month;
    private String S_id;
    private String Name;
    private String D_id;
    private String D_name;
    private float Basic_salary;
    private String Rate;
    private float Bonus;
    private float Bonus_salary;
    private float Attendance_fine;
    private float Before_tax;
    private float tax_rate;
    private float tax;
    private float After_tax;

    public Salary(String year, String month, String s_id, String name, String d_id,
                  String d_name, float basic_salary, String rate, float bonus, float bonus_salary,
                  float attendance_fine, float before_tax, float tax_rate, float tax, float after_tax) {
        Year = year;
        Month = month;
        S_id = s_id;
        Name = name;
        D_id = d_id;
        D_name = d_name;
        Basic_salary = basic_salary;
        Rate = rate;
        Bonus = bonus;
        Bonus_salary = bonus_salary;
        Attendance_fine = attendance_fine;
        Before_tax = before_tax;
        this.tax_rate = tax_rate;
        this.tax = tax;
        After_tax = after_tax;
    }
    public Salary(){
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
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

    public String getD_id() {
        return D_id;
    }

    public void setD_id(String d_id) {
        D_id = d_id;
    }

    public String getD_name() {
        return D_name;
    }

    public void setD_name(String d_name) {
        D_name = d_name;
    }

    public float getBasic_salary() {
        return Basic_salary;
    }

    public void setBasic_salary(float basic_salary) {
        Basic_salary = basic_salary;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public float getBonus() {
        return Bonus;
    }

    public void setBonus(float bonus) {
        Bonus = bonus;
    }

    public float getBonus_salary() {
        return Bonus_salary;
    }

    public void setBonus_salary(float bonus_salary) {
        Bonus_salary = bonus_salary;
    }

    public float getAttendance_fine() {
        return Attendance_fine;
    }

    public void setAttendance_fine(float attendance_fine) {
        Attendance_fine = attendance_fine;
    }

    public float getBefore_tax() {
        return Before_tax;
    }

    public void setBefore_tax(float before_tax) {
        Before_tax = before_tax;
    }

    public float getTax_rate() {
        return tax_rate;
    }

    public void setTax_rate(float tax_rate) {
        this.tax_rate = tax_rate;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getAfter_tax() {
        return After_tax;
    }

    public void setAfter_tax(float after_tax) {
        After_tax = after_tax;
    }
}