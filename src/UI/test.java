package UI;



public class test {
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new log().setVisible(true);
                } catch (Exception ex) {

                }
            }
        });
    }
}