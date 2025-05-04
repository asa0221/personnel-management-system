package subject;


public class Performance {
    private String Year;
    private String Month;
    private String S_id;
    private String Report;
    private String Review;
    private String Rate;

    public Performance(String year, String month, String s_id, String report, String review, String rate) {
        Year = year;
        Month = month;
        S_id = s_id;
        Report = report;
        Review = review;
        Rate = rate;
    }
    public Performance(){

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

    public String getReport() {
        return Report;
    }

    public void setReport(String report) {
        Report = report;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }
}
