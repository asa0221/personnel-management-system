package UI;

import dao.Salary_dao;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import subject.Database;
import subject.Staff;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class Salary_photo extends JPanel{
    public static final Database db=new Database();

    public static final Connection con;

    static {
        try {
            con = db.getCon();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Staff user;
    ChartPanel chartPane ;
    public Salary_photo(Connection con, String year, String s_id){
        CategoryDataset dataset = getDataSet(con,year,s_id);
        JFreeChart chart = ChartFactory.createBarChart3D(
                "个人月薪资组成", // 图表标题
                "Month", // 目录轴的显示标签
                "金额", // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true,      // 是否显示图例(对于简单的柱状图必须是false)
                false,     // 是否生成工具
                true      // 是否生成URL链接
        );
        //从这里开始
        chartPane = new ChartPanel(chart);
        chartPane.setSize(500,200);
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();     //水平底部列表
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));     //水平底部标题
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12)); //垂直标题
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
        //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题
//        chartPane= new ChartFrame("str",chart).getChartPanel();    //这里也可以用chartFrame,可以直接生成一个独立的Frame
//        JFrame frame = new JFrame("月薪资柱状图");
//        frame.add(chartPane);
//        frame.setSize(800, 500);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
    }
//    CategoryDataset用来储存数据
    private static CategoryDataset getDataSet(Connection con, String year, String s_id) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       try {
           Salary_dao salary_dao = new Salary_dao();
           ResultSet rs = salary_dao.select_year_salary(Salary_photo.con, year,s_id);
           while(rs.next()){
               dataset.addValue(rs.getFloat("Basic_salary"),"基本工资",rs.getString("Month"));
               dataset.addValue((rs.getFloat("Bonus_salary")-rs.getFloat("Basic_salary")),"绩效提成",rs.getString("Month"));
               dataset.addValue((rs.getFloat("Attendance_fine"))*(-1),"考勤罚金",rs.getString("Month"));
               dataset.addValue(rs.getFloat("tax")*(-1),"个人所得税",rs.getString("Month"));
               dataset.addValue(rs.getFloat("After_tax"),"当月所得",rs.getString("Month"));
           }
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
        return dataset;
    }
    public ChartPanel getChartPanel(){

        return chartPane;

    }
}
