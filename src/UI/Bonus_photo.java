package UI;

import dao.Salary_dao;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import subject.Database;
import subject.Staff;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Bonus_photo {
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
        ChartPanel frame1;

        public Bonus_photo(Connection con, String D_id) throws Exception {

            XYDataset xydataset = createDataset(con,D_id);

            JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("部门员工月绩效汇总折线图", "日期", "水平",xydataset, true, true, true);

            XYPlot xyplot = (XYPlot) jfreechart.getPlot();

            DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();

            dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

            frame1=new ChartPanel(jfreechart,true);

            dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题

            dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题

            ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状

            rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));

            jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));

            jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体

        }

        private static XYDataset createDataset(Connection con,String D_id) throws Exception {
            String S_id = null;
            Salary_dao salary_dao = new Salary_dao();
            ResultSet rs = salary_dao.select_all_by_D_id(con, D_id);
            TimeSeries timeseries = null;
            TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
            while (rs.next()) {
                if (S_id == null) {
                    S_id = rs.getString("S_id");
                    timeseries = new TimeSeries(S_id, org.jfree.data.time.Month.class);
                } else if (!Objects.equals(S_id, rs.getString("S_id"))) {
                    timeseriescollection.addSeries(timeseries);
                    S_id = rs.getString("S_id");
                    timeseries = new TimeSeries(S_id, org.jfree.data.time.Month.class);
                } else {
                }
                timeseries.add(new Month(rs.getInt("Month"), rs.getInt("Year")), rs.getFloat("Bonus"));
            }
            timeseriescollection.addSeries(timeseries);
            return timeseriescollection;
        }

        public ChartPanel getChartPanel(){

            return frame1;

        }

    }


